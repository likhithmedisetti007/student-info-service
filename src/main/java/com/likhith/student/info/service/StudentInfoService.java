package com.likhith.student.info.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.likhith.student.info.dto.StudentInfo;
import com.likhith.student.info.entity.StudentInfoEntity;
import com.likhith.student.info.mapper.StudentInfoServiceMapper;
import com.likhith.student.info.repository.StudentInfoRepository;
import com.likhith.student.info.response.StudentInfoResponse;

@Service
public class StudentInfoService {

	@Autowired
	StudentInfoRepository studentInfoRepository;

	@Autowired
	StudentInfoServiceMapper studentInfoServiceMapper;

	public StudentInfoResponse getStudentInfoById(String id) {

		StudentInfoResponse studentInfoResponse = new StudentInfoResponse();
		StudentInfo studentInfo = new StudentInfo();

		try {
			Optional<StudentInfoEntity> studentInfoEntity = studentInfoRepository.findById(id);

			if (studentInfoEntity.isPresent()) {
				studentInfo = studentInfoServiceMapper.mapStudentInfoEntityToStudentInfo(studentInfoEntity.get());

				studentInfoResponse.setStudentInfo(studentInfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentInfoResponse;

	}

}