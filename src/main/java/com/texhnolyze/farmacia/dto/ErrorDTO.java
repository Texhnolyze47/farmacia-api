package com.texhnolyze.farmacia.dto;

import lombok.Builder;
import java.time.Instant;


public record ErrorDTO(Integer statusCode, String message, Instant timestamp) {}
