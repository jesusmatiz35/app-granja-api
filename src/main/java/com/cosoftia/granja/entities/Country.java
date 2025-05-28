package com.cosoftia.granja.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "countries", indexes = {
		@Index(name = "countries_code_idx", columnList = "code"),
})
public class Country implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private int contryId;
	@Column(name = "code", unique = true, nullable = false, columnDefinition = "INT(4)")
	private int code;
	@Column(name = "name", nullable = false, columnDefinition = "VARCHAR(70)")
	private String name;
	@OneToMany(mappedBy = "country")
	private List<Farm> farms;

}
