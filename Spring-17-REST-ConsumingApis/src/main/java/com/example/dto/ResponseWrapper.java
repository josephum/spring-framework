package com.example.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseWrapper {
    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message, Object data) {
        this.message = message;
        this.data = data;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }

    public ResponseWrapper(String message) {
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }

    public ResponseWrapper(String message, HttpStatus status) {
        this.message = message;
        this.code = status.value();
        this.success = true;
    }
}
