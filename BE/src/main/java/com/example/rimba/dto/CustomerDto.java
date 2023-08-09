package com.example.rimba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String nama;
    private String contact;
    private String email;
    private String alamat;
    private double diskon;
    private String tipeDiskon;
    private String ktpImage;
}
