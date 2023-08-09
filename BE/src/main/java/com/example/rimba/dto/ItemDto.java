package com.example.rimba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Integer id;
    private String namaItem;
    private String unit;
    private Integer stok;
    private double hargaSatuan;
    private String barangImage;
    
    // private Integer id_rak;
}
