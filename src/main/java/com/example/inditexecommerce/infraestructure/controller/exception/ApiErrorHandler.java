package com.example.inditexecommerce.infraestructure.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.text.ParseException;

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

    @ExceptionHandler(ParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleParseException(ParseException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        "BAD_REQUEST", ex.getMessage() != null ? ex.getMessage() : "", ex.toString()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleParseException(ResponseStatusException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        "BAD_REQUEST", ex.getMessage() != null ? ex.getMessage() : "", ex.toString()),
                HttpStatus.BAD_REQUEST);
    }
}
