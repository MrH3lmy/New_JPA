package com.vodafone.jpa.model;

import lombok.Data;

@Data
public class ErrorDetails {
    private String code;
    private String message;
    private String url;


}
