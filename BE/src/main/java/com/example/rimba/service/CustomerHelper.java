package com.example.rimba.service;

import org.springframework.stereotype.Component;

import com.example.rimba.dto.CustomerDto;
import com.example.rimba.model.Customer;
// import com.example.rimba.model.CustomerHistory;

@Component
public class CustomerHelper {
    public void DataCustomer(Customer customer, CustomerDto customerDto){
        customer.setNama(customerDto.getNama());
        customer.setContact(customerDto.getContact());
        customer.setEmail(customerDto.getEmail());
        customer.setAlamat(customerDto.getAlamat());
        customer.setDiskon(customerDto.getDiskon());
        customer.setTipeDiskon(customerDto.getTipeDiskon());
        customer.setKtpImage(customerDto.getKtpImage());
    }
    
    // public void DataCustomerHistory(CustomerHistory customerHistory, Customer customer){
    //     customer.setNama(customer.getNama());
    //     customer.setContact(customer.getContact());
    //     customer.setEmail(customer.getEmail());
    //     customer.setAlamat(customer.getAlamat());
    //     customer.setDiskon(customer.getDiskon());
    //     customer.setTipeDiskon(customer.getTipeDiskon());
    //     customer.setKtpImage(customer.getKtpImage());
    // }

    public String CekDataCustomer(String cek, CustomerDto customerDto){
        if(customerDto.getNama().equals("") || customerDto.getContact().equals("") || customerDto.getEmail().equals("") || 
        customerDto.getAlamat().equals("") || customerDto.getTipeDiskon().equals("")  ||  customerDto.getKtpImage().equals("")){
            cek = "invalid";
        }else{
            if(("persentase").equals(customerDto.getTipeDiskon()) || ("fix diskon").equals(customerDto.getTipeDiskon()) ||  ("tidak ada").equals(customerDto.getTipeDiskon())){
                cek = "valid";
                if(("persentase").equals(customerDto.getTipeDiskon())){
                    customerDto.setDiskon(10);
                }else{
                    customerDto.setDiskon(50000);
                }
            }else{
                cek = "invalid";
            }
        }
        return cek;
    }
}
