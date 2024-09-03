package com.example.Course_list.Application.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.Course_list.Application.model.CourseInstance;
import com.example.Course_list.Application.service.CourseInstanceService;

@RestController
@RequestMapping("/Instance")
@CrossOrigin(origins = "http://localhost:3000") 
public class CourseInstanceController {

	  @Autowired
	   CourseInstanceService courseInstanceService;
	 
	  @GetMapping("/allInstances")
	    public ResponseEntity<List<CourseInstance>> getAllCourseInstance(){
	        return courseInstanceService.getAllCourseInstances();
	    }
	  
	  @GetMapping("/year/sem/{year}/{sem}")
	  public ResponseEntity<List<CourseInstance>> getInstancesByCourseYearAndSem(
	      @PathVariable String year, @PathVariable String sem) {
	      return courseInstanceService.getInstancesByCourseYearAndSem(year, sem);
	  }


	    @PostMapping("/addInstance")
	    public ResponseEntity<String> addQuestion(@RequestBody CourseInstance courseInstance){
	        return courseInstanceService.add(courseInstance);
	    }
	    
	    @DeleteMapping("/delete/{courseId}")
	    public ResponseEntity<String> deleteCourseInstance(@PathVariable String courseId ) {
	        return courseInstanceService.deleteCourseInstance(courseId);
	    }
	  
	  
}

