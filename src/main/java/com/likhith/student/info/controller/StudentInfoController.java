package com.likhith.student.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.likhith.student.info.response.StudentInfoResponse;
import com.likhith.student.info.service.StudentInfoService;

@RestController
@RequestMapping("/student-info-service")
public class StudentInfoController {

	@Autowired
	StudentInfoService studentInfoService;

	@GetMapping("/getStudentInfoById/{id}")
	@QueryMapping
	public StudentInfoResponse getStudentInfoById(@Argument @PathVariable String id) {

		StudentInfoResponse studentInfoResponse = null;

		try {
			studentInfoResponse = studentInfoService.getStudentInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentInfoResponse;

	}

}