package com.jdc.anno3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Repeatable1 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		Method method = MyClass.class.getMethod("doWork");
		
		Task[] tasks = method.getAnnotationsByType(Task.class);
		
		for (Task task : tasks) {
            System.out.println("Task: " + task.name());
        }
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Tasks {

	Task[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Tasks.class)
@interface Task {
	
	String name();
}

class MyClass {
	
	@Task(name = "Coding")
	@Task(name = "Testing")
	public void doWork() {
		System.out.println("Working...");
	}
}
