package com.example.inditexecommerce.infraestructure.controller.exception;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private String code;
    private String message;
    @Nullable
    private String stackTrace;
}
