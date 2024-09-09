package com.ibm.hotel_management_system.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

	@Id
	private int id;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String password;
	
	
}
