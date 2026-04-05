package com.medical.medicalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.medicalstore.entity.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long>{

}
