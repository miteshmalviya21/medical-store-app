package com.medical.medicalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.medicalstore.entity.Sales;

public interface SaleRepository extends JpaRepository<Sales, Long>{

}
