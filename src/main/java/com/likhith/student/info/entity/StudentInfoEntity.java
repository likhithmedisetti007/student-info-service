package com.likhith.student.info.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STUDENT_INFO")
@Data
public class StudentInfoEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	String id;

	@Column(name = "NAME")
	String name;

	@Column(name = "AGE")
	String age;

	@Column(name = "GENDER")
	String gender;

	@Column(name = "REMARKS")
	String remarks;
}