package com.texhnolyze.farmacia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicineImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id")
    private Medication medication;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_data_id")
    private FileData fileData;
}
