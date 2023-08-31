package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.dto.ErrorDTO;
import com.texhnolyze.farmacia.exceptions.UsernameAlreadyTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler( value = UsernameAlreadyTakenException.class)
    public ResponseEntity<ErrorDTO> handleUsernameAlreadyTakenException(UsernameAlreadyTakenException ex) {
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.CONFLICT.value(), ex.getMessage(), Instant.now());
        return new ResponseEntity<>(errorDTO,HttpStatus.CONFLICT);
    }


}
