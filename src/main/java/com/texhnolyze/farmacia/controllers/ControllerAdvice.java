package com.texhnolyze.farmacia.controllers;

import com.texhnolyze.farmacia.dto.ErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        ErrorDTO errorDTO = new ErrorDTO("Fallo la validacion",errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> jsonExceptionHandler(HttpMessageNotReadableException ex){
        String errorMessage = "Error en el formato del JSON";
        ErrorDTO errorDTO = new ErrorDTO("Fallo la validacion",
                Collections.singletonList(errorMessage));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

}
