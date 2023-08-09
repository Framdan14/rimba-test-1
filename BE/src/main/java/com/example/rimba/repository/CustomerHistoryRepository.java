package com.example.rimba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rimba.model.CustomerHistory;

public interface CustomerHistoryRepository extends JpaRepository<CustomerHistory , Integer>{
    
}
