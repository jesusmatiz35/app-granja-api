package com.cosoftia.granja.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FarmDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "farm_name")
	private String farmName;
	@JsonProperty(value = "country_id")
	private int country;
	@JsonProperty(value = "address")
	private String address;
	@JsonProperty(value = "phone")
	private String phone;

}
