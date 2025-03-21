package com.jdc.anno1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import com.jdc.annos.FieldAnno;
import com.jdc.annos.GradeChecker;
import com.jdc.annos.ParamAnno;

public class StudentValidator {

	@SuppressWarnings("null")
	public static void validate(Student student) throws IllegalArgumentException, IllegalAccessException {
		var stuClass = student.getClass();
		
		var fields = stuClass.getDeclaredFields();
		
		for (Field field : fields) {
			field.setAccessible(true);
			
			// for name field
			if(field.isAnnotationPresent(FieldAnno.class)) {
				
				FieldAnno fieldAnno = field.getAnnotation(FieldAnno.class); // get anno of this field
				String nameField = (String) field.get(student); // get out fields from this anno
				
				if(nameField == null || nameField.trim().isEmpty()) {
					field.set(student, fieldAnno.name());
				}
			}
			
			// for grade field
			if(field.isAnnotationPresent(GradeChecker.class)) {

				GradeChecker gradeChecker = field.getAnnotation(GradeChecker.class); 
				String gradeField = (String) field.get(student);
				
				if(gradeField != null || !gradeField.trim().isEmpty()) {
					Grade grade = Grade.valueOf(gradeField);
					
					Grade[] allowedGrades = gradeChecker.allowedGrades();
					
					// to check the grade ,exit or not in the allowGrades
					boolean isGradeAllowed = false;
					
					// compare each grade existing in the array
					for(var allG : allowedGrades) {
						if(allG == grade) {
							isGradeAllowed = true;
							break;
						}
					}
					
					if (!isGradeAllowed) {
                        String allowedGradesStr = Arrays.toString(allowedGrades);
                        throw new IllegalArgumentException(
                            "Grade (" + grade + ") is not in allowed grades: " + allowedGradesStr
                        );
                    }
					
				}
			}
			
			// for age field
			try {
				Field ageField = stuClass.getDeclaredField("age");
				
				ageField.setAccessible(true);
				
				int age = (int) ageField.get(student);
				
				Constructor<?> constructor = stuClass.getDeclaredConstructors()[0];
				Parameter[] parameters = constructor.getParameters();
				
				int minAge = 5;
				int maxAge = 25;
				
				for (var para : parameters) {
					if(para.isAnnotationPresent(ParamAnno.class)) {
						var pAnno = para.getAnnotation(ParamAnno.class);
						
						minAge = pAnno.minAge();
						maxAge = pAnno.maxAge();
						break;
					}
				}
				
				if (age < minAge || age > maxAge) {
	                throw new IllegalArgumentException(
	                    "Age (" + age + ") is out of allowed range [" + minAge + ", " + maxAge + "]"
	                );
	            }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
