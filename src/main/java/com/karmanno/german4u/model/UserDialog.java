package com.karmanno.german4u.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class UserDialog {
    @Id
    private String id;
    private String userId;
    private boolean waitingForUser;
}
