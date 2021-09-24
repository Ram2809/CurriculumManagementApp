package com.curriculum.repository;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.curriculum.dto.Subject;
import com.curriculum.entity.SubjectEntity;
import com.curriculum.exception.DatabaseException;
import com.curriculum.exception.NotFoundException;
import com.curriculum.exception.SubjectNotFoundException;

public interface SubjectRepository {
	String addSubject(Subject subject) throws DatabaseException;

//	ResponseEntity<List<Subject>> getAllSubjectDetails();
//
	SubjectEntity updateSubject(String subjectCode, Subject subject) throws DatabaseException, NotFoundException;

	SubjectEntity deleteSubject(String subjectCode) throws DatabaseException, NotFoundException;

	SubjectEntity getParticularSubject(String subjectCode) throws DatabaseException, NotFoundException;

	List<SubjectEntity> getSubjectByClass(Long roomNo) throws DatabaseException;

	List<String> getSubjectName(Long roomNo) throws DatabaseException;

	String getSubjectCode(Long roomNo, String name) throws DatabaseException;
//	void checkSubject(String code) throws SubjectNotFoundException;

}
