package com.likhith.student.info.dto;

import lombok.Data;

@Data
public class PushStudentInfoRequest {

	private String name;
	private String age;
	private String gender;
	private String schoolName;
	private String remarks;

}