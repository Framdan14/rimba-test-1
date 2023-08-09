package com.example.rimba.service;

import org.springframework.stereotype.Component;

import com.example.rimba.dto.ItemDto;
import com.example.rimba.model.Item;
// import com.example.rimba.model.ItemHistory;

@Component
public class ItemHelper {
    public void DataItem(Item item, ItemDto itemDto){
        item.setNamaItem(itemDto.getNamaItem());
        item.setUnit(itemDto.getUnit());
        item.setStok(itemDto.getStok());
        item.setHargaSatuan(itemDto.getHargaSatuan());
        item.setBarangImage(itemDto.getBarangImage());
    }
    
    // public void DataItemHistory(ItemHistory itemHistory, Item item){
    //     itemHistory.setNamaItem(item.getNamaItem());
    //     itemHistory.setUnit(item.getUnit());
    //     itemHistory.setStok(item.getStok());
    //     itemHistory.setHargaSatuan(item.getHargaSatuan());
    //     itemHistory.setBarangImage(item.getBarangImage());
    // }
    
    public String CekDataItem(String cek, ItemDto itemDto){
        if(itemDto.getNamaItem().equals("") || itemDto.getStok() == 0 || itemDto.getHargaSatuan() == 0 || itemDto.getUnit().equals("")  ||  itemDto.getBarangImage().equals("")){
            cek = "invalid";
        }else{
            if(("persentase").equals(itemDto.getUnit()) || ("fix diskon").equals(itemDto.getUnit()) ||  ("tidak ada").equals(itemDto.getUnit())){
                cek = "valid";
            }else{
                cek = "invalid";
            }
        }
        return cek;
    }
}