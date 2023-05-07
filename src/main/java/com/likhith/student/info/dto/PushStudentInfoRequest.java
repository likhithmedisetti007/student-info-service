package com.likhith.student.info.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushStudentInfoRequest {

	private String name;
	private String age;
	private String gender;
	private String schoolName;
	private String remarks;

}