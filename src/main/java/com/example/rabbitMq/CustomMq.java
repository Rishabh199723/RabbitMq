package com.example.rabbitMq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomMq {
    private String messageId;
    private String message;
    private Date created;
}
