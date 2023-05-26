package com.masai.model;

import com.masai.enums.Position;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;

	@NotNull(message = "first name should not be null")
	@NotEmpty(message = "First Name should not be empty")
	private String firstName;
	
	
	private String lastName;
	
	@NotNull(message = "Email should not be null")
	@NotEmpty(message = "Email should not be empty")
	@Pattern(regexp = "^\\w{1,12}@gmail\\.com$",message = "please provide the correct email address")
	private String email;
	
	
	@Pattern(regexp = "\\d{10}")
	@Size(min = 1 , max = 10)
	private String phoneNo;
	
	
	@NotNull(message = "Address should not be null")
	@NotEmpty(message = "Address should not be empty")
	@Pattern(regexp = "yyyy/MM/dddd")
	private String dob;
	
	@NotNull(message = "Address should not be null")
	@NotEmpty(message = "Address should not be empty")
	private String address;
	
	
	@NotNull(message = "Position should not be null")
	@NotEmpty(message = "Position should not be empty")
	@Enumerated(EnumType.STRING)
	private Position position;
	
	
}
