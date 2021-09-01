package com.curriculum.repository;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.curriculum.entity.ClassEntity;

public interface ClassRepository {
	ResponseEntity<String> addClassDetails(ClassEntity classDetails);
	ResponseEntity<List<ClassEntity>> getAllClassDetails();
	ResponseEntity<String> updateClassDetails(Long roomNo,ClassEntity classDetails);
}
