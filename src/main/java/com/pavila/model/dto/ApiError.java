package com.pavila.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ApiError {

    @JsonProperty("http_code")
    int httpCode;

    String url;

    @JsonProperty("http_method")
    String httpMethod;

    String message;

    @JsonProperty("backend_message")
    String backendMessage;

    @JsonFormat(pattern = "dd:MM:yyyy HH:mm:ss")
    LocalDateTime timestamp;

    List<String> details;
}
