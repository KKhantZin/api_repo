package com.jdc.annos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jdc.anno1.Grade;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GradeChecker {
	
	Grade [] allowedGrades();
}
