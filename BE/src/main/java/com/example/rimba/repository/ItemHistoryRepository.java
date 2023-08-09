package com.example.rimba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rimba.model.ItemHistory;

public interface ItemHistoryRepository extends JpaRepository<ItemHistory , Integer>{
    
}
