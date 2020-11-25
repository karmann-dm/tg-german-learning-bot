package com.karmanno.german4u.gateway;

import com.karmanno.german4u.model.KeyboardButton;
import com.karmanno.german4u.model.Message;
import com.karmanno.german4u.model.ReplyKeyboardMarkup;
import com.karmanno.german4u.transport.MessageTransport;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TelegramApiGateway {
    private final TelegramApiClient telegramApiClient;

    @Value("${app.telegram.botToken}")
    private String botToken;

    public Message sendMessage(Integer chatId, String text, List<String> answers) {
        return telegramApiClient.sendMessage("bot" + botToken, new MessageTransport(chatId, text,
                    new ReplyKeyboardMarkup(
                            answers.stream()
                                    .map(a -> {
                                        var button = new KeyboardButton();
                                        button.setText(a);
                                        return List.of(button);
                                    }).collect(Collectors.toList()))
                    )
                );
    }
}
