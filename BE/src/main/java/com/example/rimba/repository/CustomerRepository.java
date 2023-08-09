package com.example.rimba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rimba.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer , Integer>{
    Iterable<Customer> findByNamaContaining(String nama);
    Iterable<Customer> findByTipeDiskon(String tipeDiskon);
}
