package com.example.rimba.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.rimba.model.Customer;
import com.example.rimba.model.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesDto {
    private String codeTransaksi;
    private Date tanggalTransaksi;
    private Customer customer;
    private List<Item> items = new ArrayList<>();
    private List<Integer> qty = new ArrayList<>();
    private double totalDiskon;
    private double totalHarga;
    private double totalBayar;
}
