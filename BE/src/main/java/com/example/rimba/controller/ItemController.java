package com.example.rimba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rimba.dto.ItemDto;
import com.example.rimba.model.Item;
import com.example.rimba.repository.ItemRepository;
import com.example.rimba.service.ApiResponse;
import com.example.rimba.service.ItemHelper;
import com.example.rimba.service.ResponseHelper;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemHelper itemHelper;

    @Autowired
    public ItemController(ItemRepository itemRepository, ItemHelper itemHelper) {
        this.itemRepository = itemRepository;
        this.itemHelper = itemHelper;
    }

    @GetMapping("/find-all")
    public ApiResponse getAllItem(){
        try {
            Iterable<Item> item = itemRepository.findAll();
            return ResponseHelper.createSuccessResponse(200,"Sukses",item);
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
        }
    }

    @GetMapping("/find-item-by-nama/{nama}")
    public ApiResponse getItem(@PathVariable String nama){
        try {
            Iterable<Item> item = itemRepository.findByNamaItemContaining(nama);
            return ResponseHelper.createSuccessResponse(200,"Sukses",item);
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(404,"Data Not Found",null);
        }
    }
    
    @GetMapping("/find-item-by-harga/{hargaSatuan}")
    public ApiResponse getItemHarga(@PathVariable Integer hargaSatuan){
        try {
            Iterable<Item> item = itemRepository.findByHargaSatuanLessThan(hargaSatuan);
            return ResponseHelper.createSuccessResponse(200,"Sukses",item);
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(404,"Data Not Found",null);
        }
    }

    @GetMapping("/find-item-by-unit/{unit}")
    public ApiResponse getItemUnit(@PathVariable String unit){
        try {
            if("pcs".equals(unit) || "kg".equals(unit)){
                Iterable<Item> item = itemRepository.findByUnit(unit);
                return ResponseHelper.createSuccessResponse(200,"Sukses",item);
            }else {
                throw new IllegalArgumentException("Invalid unit");
            }
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(404,"Data Not Found",null);
        }
    }

    @PostMapping("/create-item")
    public ApiResponse create(@RequestBody ItemDto itemDto){
        try{
            // menulis Item baru
            Item newItem = new Item();
            itemHelper.DataItem(newItem, itemDto);
            // menyimpan data baru
            Item itemSaved = itemRepository.save(newItem);
            // beri respon
            return ResponseHelper.createSuccessResponse(200,"Success",itemSaved);
        }catch(Exception e){
            return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
        }
    }

    @PutMapping("/update-item/{id}")
    public ApiResponse update(@PathVariable Integer id, @RequestBody ItemDto itemDto){
        Item item = itemRepository.findById(id).orElse(null);
        if(item == null){
            return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
        }else{
            // menulis Item baru
            itemHelper.DataItem(item, itemDto);
            // menyimpan data baru
            Item itemSaved = itemRepository.save(item);
            // beri respon
            return ResponseHelper.createSuccessResponse(200,"Success",itemSaved);
        }
    }

    @DeleteMapping("/delete-item/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        Item item = itemRepository.findById(id).orElse(null);
        if(item == null){
            return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
        }else{
            itemRepository.deleteById(id);
            return ResponseHelper.createSuccessResponse(200,"Success",null);
        }
    }
    
    
    // Mau bikin Soft Delete cmn masi eror
    
    // @GetMapping("/find-all-item-history")
    // public ApiResponse getAllItemHistory(){
    //     try {
    //         Iterable<ItemHistory> itemHistory = itemHistoryRepository.findAll();
    //         return ResponseHelper.createSuccessResponse(200,"Sukses",itemHistory);
    //     } catch (Exception e) {
    //         return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
    //     }
    // }
    // @DeleteMapping("/delete-item/{id}")
    // public ApiResponse delete(@PathVariable Integer id){
    //     Item item = itemRepository.findById(id).orElse(null);
    //     if(item == null){
    //         return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
    //     }else{
    //         itemRepository.deleteById(id);
    //         ItemHistory itemHistory = new ItemHistory();
    //         itemHelper.DataItemHistory(itemHistory, item);
    //         itemHistoryRepository.save(itemHistory);
    //         return ResponseHelper.createSuccessResponse(200,"Success",null);
    //     }
    // }
}
