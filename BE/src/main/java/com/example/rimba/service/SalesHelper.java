package com.example.rimba.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rimba.dto.ItemDto;
import com.example.rimba.dto.SalesDto;
import com.example.rimba.model.Customer;
import com.example.rimba.model.Item;
import com.example.rimba.model.Sales;

@Component
public class SalesHelper {
    public void DataItem(Sales sales, SalesDto salesDto, Customer customer, List<Integer> data){
        sales.setCodeTransaksi(salesDto.getCodeTransaksi());
        sales.setTanggalTransaksi(salesDto.getTanggalTransaksi());
        sales.setCustomer(customer);
        sales.setItems(salesDto.getItems());
        sales.setQty(data);
        sales.setTotalDiskon(salesDto.getTotalDiskon());
        sales.setTotalHarga(salesDto.getTotalHarga());
        sales.setTotalBayar(salesDto.getTotalBayar());
    }

    public ItemDto toItemDto(Item item) {
    ItemDto itemDto = new ItemDto();
    itemDto.setId(item.getId());
    itemDto.setNamaItem(item.getNamaItem());
    itemDto.setUnit(item.getUnit());
    itemDto.setStok(item.getStok());
    itemDto.setHargaSatuan(item.getHargaSatuan());
    itemDto.setBarangImage(item.getBarangImage());
    return itemDto;
}
}
