package com.sakshi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String name;

	@NotNull
	@NotBlank
	@NotEmpty
	private String moblieNo;
	
	
	private String password;
	
	@NotNull
	@Column(nullable = true)
	private String email;
	
	
	
	
	
	
}
