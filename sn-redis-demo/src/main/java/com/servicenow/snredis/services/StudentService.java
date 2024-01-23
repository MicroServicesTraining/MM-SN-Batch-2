/**
 * 
 */
package com.servicenow.snredis.services;

import java.util.List;

import com.servicenow.snredis.entities.Student;

/**
 * 
 */
public interface StudentService {

	Student createStudent(Student student);

	List<Student> getStudentsList();

	Student findStudent(Long rollNo) throws Exception;

	void removeStudent(Long rollNo) throws Exception;

}
