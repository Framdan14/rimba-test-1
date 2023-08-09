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

import com.example.rimba.model.Customer;
import com.example.rimba.dto.CustomerDto;
import com.example.rimba.repository.CustomerRepository;
import com.example.rimba.service.ApiResponse;
import com.example.rimba.service.CustomerHelper;
import com.example.rimba.service.ResponseHelper;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerHelper customerHelper;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerHelper customerHelper) {
        this.customerRepository = customerRepository;
        this.customerHelper = customerHelper;
    }

    @GetMapping("/find-all")
    public ApiResponse getAllCustomer(){
        try {
            Iterable<Customer> customer = customerRepository.findAll();
            return ResponseHelper.createSuccessResponse(200,"Sukses",customer);
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
        }
    }

    @GetMapping("/find-customer-by-nama/{nama}")
    public ApiResponse getCustomer(@PathVariable String nama){
        try {
            Iterable<Customer> customer = customerRepository.findByNamaContaining(nama);
            return ResponseHelper.createSuccessResponse(200,"Sukses",customer);
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(404,"Data Not Found",null);
        }
    }

    @GetMapping("/find-customer-by-tipe-diskon/{tipe}")
    public ApiResponse getCustomerUnit(@PathVariable String tipe){
        try {
            if(("persentase").equals(tipe) || ("fix diskon").equals(tipe) ||  ("tidak ada").equals(tipe)){    
                Iterable<Customer> customer = customerRepository.findByTipeDiskon(tipe);
                return ResponseHelper.createSuccessResponse(200,"Sukses",customer);
            }else{
                throw new IllegalArgumentException("Invalid Tipe");
            }
        } catch (Exception e) {
            return ResponseHelper.createErrorResponse(404,"Data Not Found",null);
        }
    }

    @PostMapping("/create-customer")
    public ApiResponse create(@RequestBody CustomerDto customerDto){
        try{
            String cek = "";
            cek = customerHelper.CekDataCustomer(cek, customerDto);
            if(("valid").equals(cek)){
                // menulis Customer baru
                Customer newCustomer = new Customer();
                customerHelper.DataCustomer(newCustomer, customerDto);
                // menyimpan data baru
                Customer customerSaved = customerRepository.save(newCustomer);
                // beri respon
                return ResponseHelper.createSuccessResponse(200,"Success",customerSaved);
            }else{
                throw new IllegalArgumentException("Invalid Tipe");
            }
        }catch(Exception e){
            return ResponseHelper.createErrorResponse(400,"Bad Request",null);
        }
    }

    @PutMapping("/update-customer/{id}")
    public ApiResponse update(@PathVariable Integer id, @RequestBody CustomerDto customerDto){
        Customer customer = customerRepository.findById(id).orElse(null);
        try{
            String cek = "";
            cek = customerHelper.CekDataCustomer(cek, customerDto);
            if(("valid").equals(cek)){
                // menulis Data Customer baru
                customerHelper.DataCustomer(customer, customerDto);
                // menyimpan data baru
                Customer customerSaved = customerRepository.save(customer);
                // beri respon
                return ResponseHelper.createSuccessResponse(200,"Success",customerSaved);
            }else{
                throw new IllegalArgumentException("Invalid Tipe");
            }
        }catch(Exception e){
            return ResponseHelper.createErrorResponse(400,"Bad Request",null);
        }
    }

    @DeleteMapping("/delete-customer/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null){
            return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
        }else{
            customerRepository.deleteById(id);
            return ResponseHelper.createSuccessResponse(200,"Success",null);
        }
    }

    // Mau bikin Soft Delete cmn masi eror

    // @GetMapping("/find-all-history")
    // public ApiResponse getAllCustomerHistory(){
    //     try {
    //         Iterable<CustomerHistory> customerHistory = customerHistoryRepository.findAll();
    //         return ResponseHelper.createSuccessResponse(200,"Sukses",customerHistory);
    //     } catch (Exception e) {
    //         return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
    //     }
    // }
    // @DeleteMapping("/delete-customer/{id}")
    // public ApiResponse delete(@PathVariable Integer id){
    //     Customer customer = customerRepository.findById(id).orElse(null);
    //     if(customer == null){
    //         return ResponseHelper.createErrorResponse(500,"Internal Server Error",null);
    //     }else{
    //         customerRepository.deleteById(id);
    //         CustomerHistory customerHistory = new CustomerHistory();
    //         customerHelper.DataCustomerHistory(customerHistory, customer);
    //         customerHistoryRepository.save(customerHistory);
    //         return ResponseHelper.createSuccessResponse(200,"Success",null);
    //     }
    // }
}