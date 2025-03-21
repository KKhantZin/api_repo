package com.jdc.anno3;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Inherited1 {
	public static void main(String[] args) {
		MyAnnotaion anno = ChildClass.class.getAnnotation(MyAnnotaion.class);
		System.out.println(anno.value());
		
		var anno1 = Parent.class.getAnnotation(MyAnnotaion.class);
		System.out.println(anno1.value());
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyAnnotaion {
		
	String value() default "Default with Myannoatation";
}

@MyAnnotaion(value = "Parent")
class Parent {
	
}

@MyAnnotaion(value = "Child")
class ChildClass extends Parent {
	
}
