package com.example.inditexecommerce.infraestructure.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ControllerAdvice
public class ApiErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        "INTERNAL_SERVER_ERROR", ex.getMessage() != null ? ex.getMessage() : "", ex.toString()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleSQLException(SQLException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        "INTERNAL_SERVER_ERROR", ex.getMessage() != null ? ex.getMessage() : "", ex.toString()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
