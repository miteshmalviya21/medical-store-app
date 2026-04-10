package com.medical.medicalstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medical.medicalstore.entity.Medicine;
import com.medical.medicalstore.repository.MedicineRepository;

@Service
public class MedicineService {

	private final MedicineRepository medicineRepository;
	
	public MedicineService(MedicineRepository medicineRepository) {
		this.medicineRepository = medicineRepository;
	}
	
	public Medicine save(Medicine med) {
		return medicineRepository.save(med);
	}
	
	List<Medicine> getAll(){
		return medicineRepository.findAll();
	}
	
}
