package com.texhnolyze.farmacia.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private String id;
    @NotBlank(message = "El nombre del producto es necesario")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "La descripcion del producto es necesario")
    @Column(name = "description")
    private String description;
    @NotNull(message = "El precio es del producto necesario")
    @Positive(message = "El precio debe ser mayor que cero")

    @Column(name = "price")
    private Double price;
    @NotNull(message = "La cantidad del producto es necesario")
    @Positive(message = "La cantidad debe ser mayor que cero")
    @Column(name = "quantity")
    private Integer quantity;

}
