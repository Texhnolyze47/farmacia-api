package com.texhnolyze.farmacia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medication")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    @ManyToOne
    private Manufacturer manufacturer;

}
