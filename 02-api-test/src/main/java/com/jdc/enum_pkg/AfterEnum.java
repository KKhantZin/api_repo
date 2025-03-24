package com.jdc.enum_pkg;

public class AfterEnum {

	public static void main(String[] args) {
		showDay(Days.MON);
		
		for (Days d : Days.values()) {
			System.out.println(d.getFullName());
		}
		
		for (Days d : Days.values()) {
            System.out.println(d.getFullName() + 
            		" is at position " + d.ordinal());
        }
	}
	
	public static void showDay(Days day) {
		System.out.println(day);
		System.out.println(day.getFullName());
	}
}


enum Days {
	MON("MONDAY"), 
	TUE("TUESDAY"), 
	WED("WEDNESDAY"), 
	THUR("THURSDAY"), 
	FRI("FRIDAY"), 
	SAT("SATURDAY"), 
	SUN("SUNDAY");
	
	private String fullName;
	
	Days(String fullName) {
		this.fullName = fullName;
	}
	
	public String getFullName() {
		return fullName;
	}
}
