package com.jdc.enum_pkg;

public class BeforeEnum {
	public static void main(String[] args) {
		showDay(Day.MON);
		int monday = Day.MON;
		monday ++;
		monday += 20;
		System.out.println(monday);
	}
	
	static void showDay(int day) {
		System.out.println(day);
	}
}

interface Day {
	static final int MON = 1;
	static final int TUE = 1;
	static final int WED = 1;
	static final int THUR = 1;
	static final int FRI = 1;
	static final int SAT = 1;
	static final int SUN = 1;
}
