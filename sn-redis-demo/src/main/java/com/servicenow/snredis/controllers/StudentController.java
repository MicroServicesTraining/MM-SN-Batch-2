/**
 * 
 */
package com.servicenow.snredis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicenow.snredis.entities.Student;
import com.servicenow.snredis.services.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 */
@Tag(name = "Students", description = "Students management APIs")
@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@Operation(summary = "Creates a Student object", description = "Creates a Student object by specifying roll number, name and fee. The response is Student object with roll number, name, and fee.", tags = {
			"post", "new" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@Operation(summary = "Retrieve all Students", description = "Get Students list without any filter. The response is list of Student objects with roll number, name, and fee.", tags = {
			"get", "read" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping
	public List<Student> getStudentsList() {
		return studentService.getStudentsList();
	}

	@Operation(summary = "Retrieve a Student by Roll Number", description = "Get a Student object by specifying roll number. The response is Student object with roll number, name, and fee.", tags = {
			"get", "read" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

	@GetMapping("/{rollNo}")
	public Student findStudent(@PathVariable Long rollNo) throws Exception {
		return studentService.findStudent(rollNo);
	}

	@Operation(summary = "Remove a Student by Roll Number", description = "Delete a Student object by specifying roll number. The response is Student removal message.", tags = {
			"delete", "remove" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping("/{rollNo}")
	public String removeStudent(@PathVariable Long rollNo) throws Exception {
		studentService.removeStudent(rollNo);
		return "Student removed";
	}

}
