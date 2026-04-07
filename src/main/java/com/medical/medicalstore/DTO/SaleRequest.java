package com.medical.medicalstore.DTO;

import java.util.List;

import lombok.Data;

@Data
public class SaleRequest {

	private List<SaleItemRequest> items;
	
}
