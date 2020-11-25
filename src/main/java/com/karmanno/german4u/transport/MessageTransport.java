package com.karmanno.german4u.transport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.karmanno.german4u.model.ReplyKeyboardMarkup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageTransport {
    @JsonProperty("chat_id")
    private Integer chatId;

    private String text;

    @JsonProperty("reply_markup")
    private ReplyKeyboardMarkup replyKeyboardMarkup;
}
