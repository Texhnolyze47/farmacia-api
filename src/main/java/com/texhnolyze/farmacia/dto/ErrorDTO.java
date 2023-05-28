package com.texhnolyze.farmacia.dto;

import java.util.List;

public record ErrorDTO(String code, List<String> message) {}
