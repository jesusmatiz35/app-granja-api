package com.cosoftia.granja.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty(value = "firstname")
	private String firstname;
	@JsonProperty(value = "lastname")
	private String lastname;
	@JsonProperty(value = "email")
	private String email;
	@JsonProperty(value = "pwd")
	private String pwd;

}
