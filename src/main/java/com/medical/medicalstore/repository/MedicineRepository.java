package com.medical.medicalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.medicalstore.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}
