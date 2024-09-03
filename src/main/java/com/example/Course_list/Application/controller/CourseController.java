package com.example.Course_list.Application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Course_list.Application.model.Course;
import com.example.Course_list.Application.service.CourseService;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/Course")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
	
	@Autowired
	CourseService cs ;
	
	 @GetMapping("/allCourses")
	  public ResponseEntity<List<Course>> getAllCourses(){
	        
		 return cs.getAllCourses();
	    }
	 
	
	 @GetMapping("/code/{code}")
	    public ResponseEntity<Course> getByCourseCode(@PathVariable String code){
	        return cs.getByCourseCode(code);
	    }
	 
	  @PostMapping("/addCourse")
	    public ResponseEntity<String> addCourse(@RequestBody Course course){
	        return  cs.addCourse(course);
	    }
	 
	
	  @DeleteMapping("/delete/{code}")
		public ResponseEntity<String> deleteCourse(@PathVariable String code) {
			return cs.deleteCourse(code);
		}
		
		
		
				

	}
	




