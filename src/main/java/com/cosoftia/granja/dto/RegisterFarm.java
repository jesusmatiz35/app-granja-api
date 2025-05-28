package com.cosoftia.granja.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RegisterFarm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "farm")
	private FarmDTO farm;
	@JsonProperty(value = "administrator")
	private UserDTO administrator;

}
