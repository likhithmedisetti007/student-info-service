package com.likhith.student.info.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STUDENT_INFO", schema = "LIKHITH")
@Data
public class StudentInfoEntity {

	@Id
	@Column(name = "ID", nullable = false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StudentInfoIdSequenceGenerator")
//	@SequenceGenerator(name = "StudentInfoIdSequenceGenerator", sequenceName = "STUDENT_INFO_ID_SEQ")
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
