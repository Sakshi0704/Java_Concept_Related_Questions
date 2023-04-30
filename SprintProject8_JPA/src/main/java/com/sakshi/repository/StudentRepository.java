package com.sakshi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakshi.model.Student;

/*this annotation @Repository apply here just to indicate that this class is belong to data access layer 
	 otherwise as soon as this interface extends the JpaRepository our data Jpa framework will internally 
	 and dynamically implement this interface
		and also it will register that implementation class with our spring container*/
@Repository 
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
