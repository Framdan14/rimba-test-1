package com.example.rimba.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.example.rimba.dto.SalesDto;
import com.example.rimba.model.Customer;
import com.example.rimba.model.Item;
import com.example.rimba.model.Sales;
import com.example.rimba.repository.ItemRepository;
import com.example.rimba.repository.CustomerRepository;
import com.example.rimba.repository.SalesRepository;
import com.example.rimba.service.ApiResponse;
import com.example.rimba.service.SalesHelper;
import com.example.rimba.service.ResponseHelper;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    private final SalesRepository salesRepository;
    private final SalesHelper salesHelper;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public SalesController(SalesRepository salesRepository, SalesHelper salesHelper, ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.salesRepository = salesRepository;
        this.salesHelper = salesHelper;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/find-all")
    public ApiResponse getAllItem(){
        try {
            Iterable<Sales> sales = salesRepository.findAll();
            return ResponseHelper.createSuccessResponse(200,"Sukses",sales);
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
        }
    }
    
//     @PostMapping("/create-sales")
//     public ApiResponse create(@RequestBody SalesDto salesDto){
//         try{
//             // menulis sales baru
//             Sales sales = new Sales();

//             // ambil customer
//             Customer customer = customerRepository.findById(salesDto.getCustomer().getId()).orElse(null);
            
//             // ambil array items
//             List<Item> items = new ArrayList<>();
//             for (ItemDto itemDto : salesDto.getItems()) {
//                 Item item = itemRepository.findById(itemDto.getId()).orElse(null);
//                 if (item != null) {
//                     items.add(item);
//                 }
//             }
//             // Convert items to ItemDto using ItemHelper
//             List<ItemDto> itemDtos = new ArrayList<>();
//             for (Item item : items) {
//                 ItemDto itemDto = salesHelper.toItemDto(item);
//                 itemDtos.add(itemDto);
//             }
            
//             sales.setItems(itemDtos);
//             // sales.setItems(items);

//              // ambil list qty
//             List<Integer> qty = new ArrayList<>();
//             qty.addAll(salesDto.getQty()); // Menambahkan qty untuk item pertama

//             salesHelper.DataItem(sales, salesDto, customer, qty);
//             // menyimpan data baru
//             Sales salesSaved = salesRepository.save(sales);
//             // beri respon
//             return ResponseHelper.createSuccessResponse(200,"Success",salesSaved);
//         }catch(Exception e){
//             return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
//         }
//     }

// //     @PostMapping("/create-item")
// //     public ApiResponse create(@RequestBody ItemDto itemDto){
// //         try{
// //             // menulis Item baru
// //             Item newItem = new Item();
// //             itemHelper.DataItem(newItem, itemDto);
// //             // menyimpan data baru
// //             Item itemSaved = itemRepository.save(newItem);
// //             // beri respon
// //             return ResponseHelper.createSuccessResponse(200,"Success",itemSaved);
// //         }catch(Exception e){
// //             return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
// //         }
// //     }

//     @GetMapping("/find-item-by-id-sales/{id}")
//     public ApiResponse getItem(@PathVariable Integer id){
//         try {
//             Iterable<Sales> sales = salesRepository.findByIdSales(id);
//             return ResponseHelper.createSuccessResponse(200,"Sukses",sales);
//         } catch (Exception e) {
//             return ResponseHelper.createErrorResponse(404,"Data Not Found",null);
//         }
//     }
    
//     @GetMapping("/find-item-by-harga/{hargaSatuan}")
//     public ApiResponse getItemHarga(@PathVariable Integer hargaSatuan){
//         try {
//             Iterable<Item> item = itemRepository.findByHargaSatuanLessThan(hargaSatuan);
//             return ResponseHelper.createSuccessResponse(200,"Sukses",item);
//         } catch (Exception e) {
//             return ResponseHelper.createErrorResponse(404,"Data Not Found",null);
//         }
//     }

//     @GetMapping("/find-item-by-unit/{unit}")
//     public ApiResponse getItemUnit(@PathVariable String unit){
//         try {
//             Iterable<Item> item = itemRepository.findByUnit(unit);
//             return ResponseHelper.createSuccessResponse(200,"Sukses",item);
//         } catch (Exception e) {
//             return ResponseHelper.createErrorResponse(404,"Data Not Found",null);
//         }
//     }

//     @PutMapping("/update-item/{id}")
//     public ApiResponse update(@PathVariable Integer id, @RequestBody ItemDto itemDto){
//         Item item = itemRepository.findById(id).orElse(null);
//         if(item == null){
//             return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
//         }else{
//             // menulis Item baru
//             itemHelper.DataItem(item, itemDto);
//             // menyimpan data baru
//             Item itemSaved = itemRepository.save(item);
//             // beri respon
//             return ResponseHelper.createSuccessResponse(200,"Success",itemSaved);
//         }
//     }

    @DeleteMapping("/delete-sales/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        Sales sales = salesRepository.findById(id).orElse(null);
        if(sales == null){
            return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
        }else{
            salesRepository.deleteById(id);
            return ResponseHelper.createSuccessResponse(200,"Success",null);
        }
    }
}