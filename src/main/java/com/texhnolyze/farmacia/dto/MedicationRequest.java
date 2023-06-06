package com.texhnolyze.farmacia.dto;

import com.texhnolyze.farmacia.entities.Manufacturer;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequest {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    @ManyToOne
    private Manufacturer manufacturer;
}
