package com.example.rimba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nama_item", nullable = false)
    private String namaItem;
    
    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "stok", nullable = false)
    private Integer stok;

    @Column(name = "harga_satuan", nullable = false)
    private double hargaSatuan;

    @Column(name = "barang_image", nullable = false)
    private String barangImage;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "id_rak", referencedColumnName = "id")
    // private Rak rak;
}