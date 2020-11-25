package com.karmanno.german4u.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private Boolean ok;
    private List<Object> result;
}
