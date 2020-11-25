package com.karmanno.german4u.service;

import com.karmanno.german4u.model.Update;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@Slf4j
@RequiredArgsConstructor
public class UpdatesQueue {
    private final Set<Integer> processingIds = new HashSet<>();
    private final ConcurrentLinkedQueue<Update> updates = new ConcurrentLinkedQueue<>();
    private final UpdatesProcessor updatesProcessor;

    @PostConstruct
    public void initUpdatesProcessing() {
        new Thread(() -> {
            while (true) {
                Update candidate = updates.poll();
                if (candidate != null) {
                    log.info("Processing... update: {}", candidate);
                    updatesProcessor.process(candidate);
                    processingIds.remove(candidate.getUpdateId());
                }
            }
        }).start();
    }

    public void putUpdate(Update incomingUpdate) {
        if (incomingUpdate != null && !processingIds.contains(incomingUpdate.getUpdateId())) {
            updates.offer(incomingUpdate);
            processingIds.add(incomingUpdate.getUpdateId());
        }
    }
}
