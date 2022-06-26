package com.likhith.student.info.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.likhith.student.info.dto.StudentInfo;
import com.likhith.student.info.entity.StudentInfoEntity;


@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentInfoServiceMapper {

	StudentInfo mapStudentInfoEntityToStudentInfo(StudentInfoEntity studentInfoEntity);
}