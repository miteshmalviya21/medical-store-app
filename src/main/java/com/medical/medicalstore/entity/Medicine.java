package com.medical.medicalstore.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name; // ye jo name medicine ka 
	
	@Column(nullable = false)
	private String brand; // ye konsa brand h -> cipla, sun pharma
	
	@Column(nullable = false)
	private String category; // tablet h,injection
	
	// One medicine can have multiple stock batches 
	@OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL) 
	private List<Stock> stocks;
	

}
