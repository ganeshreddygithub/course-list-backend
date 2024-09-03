package com.example.Course_list.Application.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Course_list.Application.model.Course;


public interface CourseDAO extends JpaRepository<Course,String>{

	Course findByCourseCode(String code);

	

	
}


