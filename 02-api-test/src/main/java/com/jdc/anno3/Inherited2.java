package com.jdc.anno3;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Inherited2 {
	public static void main(String[] args) {

		Role base = BaseService.class.getAnnotation(Role.class);
		System.out.println("Base Service Role \n*****************");
//		for (String role : base.value()) {
//			System.out.println(role);
//		}

		System.out.println(base != null ? String.join(" , ", base.value()) : "No base roles defined.");

		var admin = AdminService.class.getAnnotation(Role.class);
		System.out.println("\nAdmin Service Role \n*****************");
//		for (String role : admin.value()) {
//			System.out.println(role);
//		}

		System.out.println(admin != null ? String.join(" | ", admin.value()) : "No admin roles defined.");

		var user = UserService.class.getAnnotation(Role.class);
		System.out.println("\nUser Service Role \n*****************");
		for (String role : user.value()) {
			System.out.println(role);
		}

		System.out.println("==========================================================");

		try {
			Method adminMethod = AdminService.class.getMethod("doMethod");
			Method childMethod = Child.class.getMethod("doMethod");

			Role parentRole = adminMethod.getAnnotation(Role.class);
			System.out.println(
					"Parent Method Role: " + (parentRole != null ? String.join(", ", parentRole.value()) : "None"));

			Role childRole = childMethod.getAnnotation(Role.class);
			System.out.println(
					"Child Method Role: " + (childRole != null ? String.join(", ", childRole.value()) : "None"));

		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

	}
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Role {
	String[] value();
}

@Role({ "ADMIN", "MANAGER" })
class BaseService {
	public void performAction() {
		System.out.println("Base service action performed.");
	}
}

class AdminService extends BaseService {
	public void adminServicePerformed() {
		System.out.println("Admin service action!!!");
	}

	@Role("Admin doMethod")
	public void doMethod() {
		System.out.println("doMethod from Base Service.");
	}
}

class Child extends AdminService {
	@Override
	public void doMethod() {
		System.out.println("doMethod overrides from Parent Service.");
	}
}

@Role({ "USER" })
class UserService extends BaseService {
	public void userServicePerformed() {
		System.out.println("User service action!!!");
	}
}
