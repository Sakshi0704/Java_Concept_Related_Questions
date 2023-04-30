package com.sakshi.controller;

import java.util.List;

import org.hibernate.sql.ast.tree.expression.AliasedExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sakshi.exception.StudentException;
import com.sakshi.model.Student;
import com.sakshi.model.StudentDTO;
import com.sakshi.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student){
	
		Student registeredStudent = studentService.saveStudent(student);
		
		return new ResponseEntity<>(registeredStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable("roll") Integer roll) throws StudentException{
		
		Student student = studentService.getStudentByRoll(roll);
		
		return new ResponseEntity<>(student,HttpStatus.FOUND);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentsHandler()throws StudentException{
		
		List<Student> students= studentService.getAllStudentDetails();
		
		return new ResponseEntity<>(students,HttpStatus.FOUND);
	}
	
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deleteStudentByRollNoHandler(@PathVariable Integer roll)throws StudentException{
		
		 Student student = studentService.deletStudentByRoll(roll);
		 
		return  new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	
	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentByRollNoHandler(@PathVariable("roll") Integer roll, @RequestBody StudentDTO student)throws StudentException{
		
		Student updateStudent = studentService.updateStudent(roll, student);
		
		return new ResponseEntity<>(updateStudent,HttpStatus.ACCEPTED);
	
	}
	
	//http://localhost:8080/students/1?gmarks=20
	
	@PatchMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentMarksHandler(@PathVariable Integer roll, @RequestParam(value = "gmarks" ,required = false, defaultValue = "0") Integer gmarks) throws StudentException{
		
		Student updatedStudent = studentService.updateStudentMarks(roll, gmarks);
		
		return new ResponseEntity<>(updatedStudent,HttpStatus.ACCEPTED);
		
	}
}
