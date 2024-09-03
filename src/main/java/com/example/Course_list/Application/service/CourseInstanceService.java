package com.example.Course_list.Application.service;

import com.example.Course_list.Application.DAO.CourseInstanceDAO;
import com.example.Course_list.Application.model.CourseInstance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseInstanceService {
	
	@Autowired
	CourseInstanceDAO  cidao;
	
	public ResponseEntity<List<CourseInstance>> getAllCourseInstances() {
        try {
            return new ResponseEntity<>(cidao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
	
	public ResponseEntity<List<CourseInstance>> getInstancesByCourseYearAndSem(String courseYear, String sem) {
	    try {
	        return new ResponseEntity<>(cidao.findByCourseYearAndSem(courseYear, sem), HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}


	   

	   public ResponseEntity<String> add(CourseInstance courseInstance) {
		    try {
		    	cidao.save(courseInstance);
		        return new ResponseEntity<>("success",HttpStatus.CREATED);
		    } catch (Exception e) {
		        // Log and handle exception
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create instance");
		    }
		}

	   public ResponseEntity<String> deleteCourseInstance(String id) {
	        if (cidao.existsById(id)) {
	            cidao.deleteById(id);
	            return ResponseEntity.ok("Course instance deleted successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course instance not found");
	        }
	    }
	   
	
	
}
	
	

	
	

