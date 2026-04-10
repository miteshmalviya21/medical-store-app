package com.medical.medicalstore.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medical.medicalstore.service.MedicineService;

@Controller
@RequestMapping(name = "/medicines")
public class MedicineController {

	private final MedicineService service;
	
	public MedicineController(MedicineService service) {
		this.service = service;
	}
	
}
