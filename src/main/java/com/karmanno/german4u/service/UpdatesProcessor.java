package com.karmanno.german4u.service;

import com.karmanno.german4u.gateway.TelegramApiGateway;
import com.karmanno.german4u.model.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpdatesProcessor {
    private final UsersService usersService;
    private final TelegramApiGateway telegramApiGateway;

    public void process(Update update) {
        if (update.getMessage() != null) { // message event
            var user = usersService.findOrCreateUser(update.getMessage().getFrom());
            telegramApiGateway.sendMessage(update.getMessage().getChat().getId(), "Message", List.of("Hi", "Hello", "NTMY"));
        }
    }
}
