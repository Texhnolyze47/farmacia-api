package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.dto.ErrorDTO;
import com.texhnolyze.farmacia.exceptions.UsernameAlreadyTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UsernameAlreadyTakenException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(UsernameAlreadyTakenException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO,HttpStatus.CONFLICT);
    }


}
