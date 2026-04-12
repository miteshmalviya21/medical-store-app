package com.medical.medicalstore.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medical.medicalstore.entity.Medicine;
import com.medical.medicalstore.service.MedicineService;

@Controller
@RequestMapping(name = "/medicines")
public class MedicineController {

	private final MedicineService service;
	
	public MedicineController(MedicineService service) {
		this.service = service;
	}
	
	@PostMapping
	public Medicine add(@RequestBody Medicine medicine) {
		return service.save(medicine);
	}
	
	@GetMapping
	public List<Medicine> getAll(){
		return service.getAll();
	}
	
}
