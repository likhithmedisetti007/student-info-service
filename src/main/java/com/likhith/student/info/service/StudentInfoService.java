package com.likhith.student.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.likhith.student.info.dto.PushStudentInfoRequest;
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

	public StudentInfoResponse getStudentInfoByName(String name) {

		StudentInfoResponse studentInfoResponse = new StudentInfoResponse();
		List<StudentInfo> studentInfoList = null;

		try {
			List<StudentInfoEntity> studentInfoEntity = studentInfoRepository.findByName(name);

			if (!CollectionUtils.isEmpty(studentInfoEntity)) {
				studentInfoList = studentInfoServiceMapper.mapStudentInfoEntityToStudentInfo(studentInfoEntity);

				studentInfoResponse.setStudentInfo(studentInfoList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentInfoResponse;

	}

	public List<StudentInfo> getStudentInfoBySchoolName(List<String> schoolName) {

		List<StudentInfo> studentInfoList = null;

		try {
			List<StudentInfoEntity> studentInfoEntity = studentInfoRepository.findBySchoolNameIn(schoolName);

			if (!CollectionUtils.isEmpty(studentInfoEntity)) {
				studentInfoList = studentInfoServiceMapper.mapStudentInfoEntityToStudentInfo(studentInfoEntity);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentInfoList;

	}

	public void pushStudentInfo(List<PushStudentInfoRequest> request) {

		List<StudentInfoEntity> studentInfoEntity = null;

		if (!CollectionUtils.isEmpty(request)) {
			studentInfoEntity = studentInfoServiceMapper.mapPushStudentInfoRequestToStudentInfoEntity(request);
		}

		studentInfoRepository.saveAll(studentInfoEntity);
	}

}