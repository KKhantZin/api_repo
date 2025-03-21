package com.jdc.anno1;

public class Main {
	public static void main(String[] args) {
		
		try {
			var s1 = new Student("Kyaw Khant Zin", 15, "A");
			StudentValidator.validate(s1);
			s1.display();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
        try {
    		Student s2 = new Student("Su Lai", 30, "B");
			StudentValidator.validate(s2);
			 s2.display();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
        
        try {
    		Student student3 = new Student("Ko Pyae", 18, "F");
			StudentValidator.validate(student3);
			 student3.display();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
        
        try {
    		Student student4 = new Student(null, 20, "C");
			StudentValidator.validate(student4);
			 student4.display();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
