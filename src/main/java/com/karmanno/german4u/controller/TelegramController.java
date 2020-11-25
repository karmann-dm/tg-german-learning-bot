package com.karmanno.german4u.controller;

import com.karmanno.german4u.model.Update;
import com.karmanno.german4u.service.UpdatesQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequestMapping("telegram")
@RestController
@RequiredArgsConstructor
public class TelegramController {
    private final UpdatesQueue updatesQueue;

    @PostMapping("updates")
    public void getUpdates(@RequestBody Update request) {
        updatesQueue.putUpdate(request);
    }
}
