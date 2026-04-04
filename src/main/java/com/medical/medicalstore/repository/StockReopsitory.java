package com.medical.medicalstore.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.medicalstore.entity.Stock;

public interface StockReopsitory extends JpaRepository<Stock, Long> {

	List<Stock> findMedicineID(Long id);
	
	List<Stock> findByExpireDateLessThanEqual(LocalDate date);
	
}
