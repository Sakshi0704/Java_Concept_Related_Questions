package com.school.model;

import jakarta.persistence.Enumerated;


public class Subject {
	
	private Integer subject_Id;

	private SubjectName subjectName;

	@Enumerated
	private Course course;
	
}
