package com.likhith.student.info.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.likhith.student.info.entity.StudentInfoEntity;

@Repository
@Transactional
public interface StudentInfoRepository extends JpaRepository<StudentInfoEntity, Long> {

	List<StudentInfoEntity> findByName(String name);

	List<StudentInfoEntity> findBySchoolNameIn(List<String> schoolName);

}