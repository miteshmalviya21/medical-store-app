package com.medical.medicalstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.medical.medicalstore.entity.Stock;
import com.medical.medicalstore.repository.StockRepository;

@Service
public class StockService {

	private StockRepository stockRepository;
	
	public StockService(StockRepository stockRepository) {
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
