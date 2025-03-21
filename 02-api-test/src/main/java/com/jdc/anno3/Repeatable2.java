package com.jdc.anno3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Repeatable2 {
	public static void main(String[] args) {
		
		try {
			Method taskMethod = TaskManager.class.getMethod("processTask");
			Schedule[] schedules = taskMethod.getAnnotationsByType(Schedule.class);
			
			for (Schedule schedule : schedules) {
				System.out.println("Task : " + schedule.task() + "\tPriority : " + schedule.priority());
			}
			
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}

class TaskManager {
	
	@Schedule(task = "Send Email", priority = 2)
    @Schedule(task = "Generate Report", priority = 1)
    @Schedule(task = "Backup Data", priority = 3)
	public void processTask() {
		System.out.println("Processing Task...");
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Schedules {
	Schedule [] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Schedules.class)
@interface Schedule {
	String task();
	int priority();
}
