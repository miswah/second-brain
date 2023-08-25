package io.miswah.secondbrain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private LocalDateTime timestamp;
    
}
