package com.likhith.student.info.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.likhith.student.info.dto.PushStudentInfoRequest;
import com.likhith.student.info.dto.StudentInfo;
import com.likhith.student.info.entity.StudentInfoEntity;
import com.likhith.student.info.mapper.StudentInfoServiceMapper;
import com.likhith.student.info.repository.StudentInfoRepository;
import com.likhith.student.info.response.StudentInfoResponse;

@SpringBootTest
public class StudentInfoServiceTests {

	@Autowired
	StudentInfoService service;

	@MockBean
	StudentInfoRepository repository;

	@MockBean
	StudentInfoServiceMapper mapper;

	@Test
	public void getStudentInfoByName_NameMatchTest() {

		String name = "Likhith";

		when(repository.findByName(name))
				.thenReturn(Stream.of(new StudentInfoEntity(1L, "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new)));

		when(mapper.mapStudentInfoEntityToStudentInfo(
				Stream.of(new StudentInfoEntity(1L, "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new))))
				.thenReturn(Stream.of(new StudentInfo("1", "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new)));

		assertEquals(name, service.getStudentInfoByName(name).getStudentInfo().get(0).getName());

	}

	@Test
	public void getStudentInfoByName_StudentInfoResponseMatchTest() {

		String name = "Likhith";

		when(repository.findByName(name))
				.thenReturn(Stream.of(new StudentInfoEntity(1L, "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new)));

		when(mapper.mapStudentInfoEntityToStudentInfo(
				Stream.of(new StudentInfoEntity(1L, "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new))))
				.thenReturn(Stream.of(new StudentInfo("1", "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new)));

		assertEquals(new StudentInfoResponse(Stream.of(new StudentInfo("1", "Likhith", "25", "Male", "Chaitanya", "NA"))
				.collect(Collectors.toCollection(ArrayList::new))), service.getStudentInfoByName(name));

	}

	@Test
	public void getStudentInfoBySchoolName_SchoolNameMatchTest() {

		String schoolName = "Chaitanya";

		when(repository.findBySchoolNameIn(Stream.of(schoolName).collect(Collectors.toCollection(ArrayList::new))))
				.thenReturn(Stream.of(new StudentInfoEntity(1L, "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new)));

		when(mapper.mapStudentInfoEntityToStudentInfo(
				Stream.of(new StudentInfoEntity(1L, "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new))))
				.thenReturn(Stream.of(new StudentInfo("1", "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new)));

		assertEquals(schoolName, service
				.getStudentInfoBySchoolName(Stream.of(schoolName).collect(Collectors.toCollection(ArrayList::new)))
				.get(0).getSchoolName());

	}

	@Test
	public void getStudentInfoBySchoolName_StudentInfoListMatchTest() {

		String schoolName = "Chaitanya";

		when(repository.findBySchoolNameIn(Stream.of(schoolName).collect(Collectors.toCollection(ArrayList::new))))
				.thenReturn(Stream.of(new StudentInfoEntity(1L, "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new)));

		when(mapper.mapStudentInfoEntityToStudentInfo(
				Stream.of(new StudentInfoEntity(1L, "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new))))
				.thenReturn(Stream.of(new StudentInfo("1", "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new)));

		assertEquals(
				Stream.of(new StudentInfo("1", "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new)),
				service.getStudentInfoBySchoolName(
						Stream.of(schoolName).collect(Collectors.toCollection(ArrayList::new))));

	}

	@Test
	public void pushStudentInfo_SaveAllCountVerifyTest() {

		when(mapper.mapPushStudentInfoRequestToStudentInfoEntity(
				Stream.of(new PushStudentInfoRequest("Likhith", "25", "Male", "Chaitanya", "NA"))
				.collect(Collectors.toCollection(ArrayList::new)))).thenReturn(
						Stream.of(new StudentInfoEntity(1L, "Likhith", "25", "Male", "Chaitanya", "NA"))
						.collect(Collectors.toCollection(ArrayList::new)));

		service.pushStudentInfo(Stream.of(new PushStudentInfoRequest("Likhith","25","Male","Chaitanya","NA")).collect(Collectors.toCollection(ArrayList::new)));

		verify(repository,times(1)).saveAll(Stream.of(new StudentInfoEntity(1L, "Likhith", "25", "Male", "Chaitanya", "NA")).collect(Collectors.toCollection(ArrayList::new)));
	}

}