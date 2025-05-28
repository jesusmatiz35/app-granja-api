package com.cosoftia.granja.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entidad que registra el programa de vacunación de las aves
 */
@Data
@Entity
@Table(name = "vaccinations", indexes = {
		@Index(name = "vaccination_id_idx", columnList = "vaccination_id"),
		@Index(name = "age_idx", columnList = "age"),
})
public class Vaccination implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vaccination_id")
	private int vaccinationId;
	@Column(name = "age", nullable = false, columnDefinition = "VARCHAR(20)")
	private String age;
	@Column(name = "vaccine", nullable = false, columnDefinition = "VARCHAR(100)")
	private String vaccine;
	@Column(name = "cepa", nullable = false, columnDefinition = "VARCHAR(100)")
	private String cepa;
	@Column(name = "vaccine_type", nullable = false, columnDefinition = "VARCHAR(100)")
	private String vaccineType;
	@Column(name = "via", nullable = false, columnDefinition = "VARCHAR(100)")
	private String via;

}
