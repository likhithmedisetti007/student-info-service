package com.likhith.student.info.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STUDENT_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfoEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AGE")
	private String age;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "SCHOOL_NAME")
	private String schoolName;

	@Column(name = "REMARKS")
	private String remarks;
}