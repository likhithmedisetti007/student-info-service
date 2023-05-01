package com.likhith.student.info.response;

import java.util.List;

import com.likhith.student.info.dto.StudentInfo;

import lombok.Data;

@Data
public class StudentInfoResponse {

	private List<StudentInfo> studentInfo;

}