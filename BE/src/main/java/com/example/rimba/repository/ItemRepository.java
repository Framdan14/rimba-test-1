package com.example.rimba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rimba.model.Item;

public interface ItemRepository extends JpaRepository<Item , Integer>{
    Iterable<Item> findByNamaItemContaining(String namaItem);
    Iterable<Item> findByUnit(String unit);
    Iterable<Item> findByHargaSatuanLessThan(Integer hargaSatuan);
}
