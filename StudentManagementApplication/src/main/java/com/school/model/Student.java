package com.school.model;

import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyEnumerated;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	
	private Integer sRollNo;
	
	private String sName;
	
	private String persentAddress;
	
	@Enumerated(EnumType.STRING)
	private Course sCourse;
	
	private OptionalSubject subject;
	
	private Parent parentDetails;
	
}
