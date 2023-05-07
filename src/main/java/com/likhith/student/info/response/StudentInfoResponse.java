package com.likhith.student.info.response;

import java.util.List;

import com.likhith.student.info.dto.StudentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoResponse {

	private List<StudentInfo> studentInfo;

}