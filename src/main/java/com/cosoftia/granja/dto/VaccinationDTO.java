
package com.cosoftia.granja.dto;

import lombok.Data;

@Data
public class VaccinationDTO {
	private int vaccinationId;
	private String age;
	private String vaccine;
	private String cepa;
	private String vaccineType;
	private String via;
}
