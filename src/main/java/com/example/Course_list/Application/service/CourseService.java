package com.example.Course_list.Application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Course_list.Application.DAO.CourseDAO;
import com.example.Course_list.Application.model.Course;

@Service
public class CourseService {
	
   @Autowired
   CourseDAO cDao;
   
   public ResponseEntity<List<Course>> getAllCourses(){
	   try {
           return new ResponseEntity<>(cDao.findAll(), HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
   }
	   
	   
   public ResponseEntity<Course> getByCourseCode(String code) {
       try {
           return new ResponseEntity<>(cDao.findByCourseCode(code),HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

   }

   public ResponseEntity<String> addCourse(Course course) {
       cDao.save(course);
       return new ResponseEntity<>("success",HttpStatus.CREATED);
   }
	
   public ResponseEntity<String> deleteCourse(String code) {
       try {
           Course course = cDao.findByCourseCode(code);
           if (course != null) {
               cDao.delete(course);
               return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
           } else {
               return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
           }
       } catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>("Error deleting course", HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
   
}




