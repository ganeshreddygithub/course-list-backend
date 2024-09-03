package com.example.Course_list.Application.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.Course_list.Application.model.CourseInstance;

public interface CourseInstanceDAO extends JpaRepository<CourseInstance, String> {

    List<CourseInstance> findByCourseYearAndSem(String courseYear, String sem);
}

