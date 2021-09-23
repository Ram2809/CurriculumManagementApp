package com.curriculum.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor

@Entity
@Table(name = "Class")
public class ClassEntity implements Serializable {
	@Id
	private Long roomNo;
	@Column(nullable = false)
	@Size(max = 3, message = "Standard cannot be empty and Standard not more than 3")
	private String standard;
	@Column(nullable = false)
	@Size(max = 2, message = "Section cannot be empty and Section length not more than 2")
	private String section;
//	@OneToMany(mappedBy = "classEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	@JsonIgnore
//	private Set<Student> student;
//	@OneToMany(mappedBy = "classRoom", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	@JsonIgnore
//	private Set<SubjectEntity> subject;
//	@OneToMany(mappedBy = "classRoom", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	@JsonIgnore
//	private Set<TimeTable> timeTable;

	public ClassEntity(Long roomNo, String standard, String section) {
		super();
		this.roomNo = roomNo;
		this.standard = standard;
		this.section = section;
	}

}
