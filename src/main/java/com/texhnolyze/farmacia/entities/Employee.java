package com.texhnolyze.farmacia.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "El nombre del empleado es necesario")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "El correo del empleado es necesario")
    @Column(name = "email")
    private String email;
    @NotBlank(message = "El numero del empleado es necesario")
    @Column(name = "number")
    private String number;
    @NotBlank(message = "El trabajo del empleado es necesario")
    @Column(name = "job")
    private String job;
}
