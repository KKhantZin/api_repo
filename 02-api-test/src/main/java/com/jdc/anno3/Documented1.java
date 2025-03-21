package com.jdc.anno3;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Documented1 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		ApiInfo classInfo = UserServices.class.getAnnotation(ApiInfo.class);
		System.out.println("Class Info : " + classInfo.version() + " , " + classInfo.description());
		
		Method methodInfo = UserServices.class.getMethod("updateProfile", String.class);
		var methodAnno = methodInfo.getAnnotation(ApiInfo.class);
		System.out.println("Method Info : " + methodAnno.version() + " , " + methodAnno.description());
	}
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface ApiInfo {
	String version();
	String description() default "No Description";
}

@ApiInfo(version = "1.0", description = "Fetches user data")
class UserServices {
	
	@ApiInfo(version = "1.1", description = "Updates user profile")
	public void updateProfile (String userId) {
		System.out.println("Updating profile for user : " + userId);
	}
}
