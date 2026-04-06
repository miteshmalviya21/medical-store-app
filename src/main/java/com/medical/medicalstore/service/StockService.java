package com.medical.medicalstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.medical.medicalstore.entity.Stock;
import com.medical.medicalstore.repository.StockReopsitory;

@Service
public class StockService {

	private StockReopsitory stockRepository;
	
	public StockService(StockReopsitory stockRepository) {
		this.stockRepository = stockRepository;
	}
	
	public Stock save(Stock stock) {
		return stockRepository.save(stock);
	}
	
	public List<Stock> getMedicineById(Long medicineId){
		return stockRepository.findMedicineID(medicineId);
	}
	
	public List<Stock> getExpiringStock(){
		return stockRepository.findByExpireDateLessThanEqual(LocalDate.now().plusDays(7));
	}
	
}
