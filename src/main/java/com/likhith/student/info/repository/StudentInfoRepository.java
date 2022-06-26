package com.likhith.student.info.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.likhith.student.info.entity.StudentInfoEntity;

@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfoEntity, String> {

	public Optional<StudentInfoEntity> findById(String id);
}