package com.likhith.student.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.likhith.student.info.dto.PushStudentInfoRequest;
import com.likhith.student.info.dto.StudentInfo;
import com.likhith.student.info.response.StudentInfoResponse;
import com.likhith.student.info.service.StudentInfoService;

@RestController
@RequestMapping("/student-info-service")
public class StudentInfoController {

	@Autowired
	StudentInfoService studentInfoService;

	@GetMapping("/getStudentInfoByName/{name}")
	@QueryMapping
	public StudentInfoResponse getStudentInfoByName(@Argument @PathVariable String name) {

		StudentInfoResponse studentInfoResponse = null;

		try {
			studentInfoResponse = studentInfoService.getStudentInfoByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentInfoResponse;

	}

	@GetMapping("/getStudentsInfoBySchoolName/{schoolName}")
	@QueryMapping
	public List<StudentInfo> getStudentsInfoBySchoolName(@Argument @PathVariable List<String> schoolName) {

		List<StudentInfo> response = null;

		try {
			response = studentInfoService.getStudentInfoBySchoolName(schoolName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	@PostMapping("/pushStudentInfo")
	@MutationMapping
	public String pushStudentInfo(@Argument @RequestBody List<PushStudentInfoRequest> request) {

		try {
			studentInfoService.pushStudentInfo(request);
		} catch (Exception e) {
			e.printStackTrace();
			return "0 record(s) pushed in STUDENT_INFO.";
		}

		return request.size() + " record(s) pushed in STUDENT_INFO.";
	}

}