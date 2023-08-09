package com.example.rimba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_history")
public class CustomerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nama", nullable = false)
    private String nama;
    
    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "diskon", nullable = false)
    private double diskon;
    
    @Column(name = "tipe_diskon", nullable = false)
    private String tipeDiskon;

    @Column(name = "ktp_image", nullable = false)
    private String ktpImage;
}
