package com.karmanno.german4u.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {
    @JsonProperty("message_id")
    private Integer messageId;

    private TelegramUser from;

    private Chat chat;
}
