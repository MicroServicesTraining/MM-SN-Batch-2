/**
 * 
 */
package com.servicenow.snredis.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.servicenow.snredis.entities.Student;
import com.servicenow.snredis.repositories.StudentRepository;
import com.servicenow.snredis.services.StudentService;

/**
 * 
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudentsList() {
		return studentRepository.findAll();
	}

	@Override
	@Cacheable(key="#rollNo", value = "Student", unless = "#result.fee > 9000")
	public Student findStudent(Long rollNo) throws Exception {
		return studentRepository.findById(rollNo).orElseThrow(() -> new Exception("No student available with given roll no"));
	}
	
	@Override
	@CacheEvict(key="#rollNo", value = "Student")
	//@CachePut(key="#rollNo", value = "Student")
	public void removeStudent(Long rollNo) throws Exception {
		Student student = findStudent(rollNo);
		studentRepository.delete(student);
	}

}
