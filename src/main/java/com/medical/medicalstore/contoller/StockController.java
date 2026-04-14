package com.medical.medicalstore.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.medicalstore.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {

	private final StockService service;
	
	public StockController(StockService service) {
		this.service = service;
	}
	
}
