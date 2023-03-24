package com.texhnolyze.farmacia.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "El nombre del cliente es necesario")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "El email del cliente es necesario")
    @Column(name = "email")
    private String email;
    @NotBlank(message = "El numero del cliente es necesario")
    @Column(name = "number")
    private String number;
}
