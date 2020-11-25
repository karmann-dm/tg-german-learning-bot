package com.karmanno.german4u.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyKeyboardMarkup {
    private List<List<KeyboardButton>> keyboard;
}
