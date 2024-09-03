

package com.example.Course_list.Application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CourseInstance {
	
    @Id
	String courseId;
	String courseYear;
    String sem;
    
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	 public String getCourseYear() {
			return courseYear;
		}
		public void setCourseYear(String courseYear) {
			this.courseYear = courseYear;
		}
	
	
	public String getSem() {
			return sem;
		}
		public void setSem(String sem) {
			this.sem = sem;
		}
		@Override
		public String toString() {
			return "CourseInstance [courseId=" + courseId + ", courseYear=" + courseYear + ", sem=" + sem + "]";
		}
	
	
	
	
	
	
}


