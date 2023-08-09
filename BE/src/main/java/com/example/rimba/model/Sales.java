package com.example.rimba.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code_transaksi", nullable = false)
    private String codeTransaksi;
    
    @Column(name = "tanggal_transaksi", nullable = false)
    private Date tanggalTransaksi;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "transaction_items")
    private List<Item> items = new ArrayList<>();

    @Column(name = "qty", nullable = false)
    private List<Integer> qty = new ArrayList<>();

    @Column(name = "total_diskon", nullable = false)
    private double totalDiskon;
    
    @Column(name = "total_harga", nullable = false)
    private double totalHarga;

    @Column(name = "total_bayar", nullable = false)
    private double totalBayar;
}