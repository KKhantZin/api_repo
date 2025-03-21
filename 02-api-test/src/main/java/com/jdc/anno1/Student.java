package com.jdc.anno1;

import com.jdc.annos.FieldAnno;
import com.jdc.annos.GradeChecker;
import com.jdc.annos.ParamAnno;

public class Student {
	
	@FieldAnno(name = "No Name")
	private String name;
	
	private int age;
	
	@GradeChecker(allowedGrades = {Grade.A, Grade.B, Grade.C})
	private String grade;
	
	public Student(String name, @ParamAnno int age, String grade) {
		setName(name);
		setAge(age);
		setGrade(grade);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	void display() {
		System.out.println("Name : %s || Age : %d || Grade : %s".formatted(name, age, grade));
	}
}
