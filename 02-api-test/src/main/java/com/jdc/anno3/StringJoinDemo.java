package com.jdc.anno3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringJoinDemo {
	public static void main(String[] args) {
		
		// String in array
		String[] names = {"Mg Mg", "Aung Aung", "Tun Tun"};
        String res1 = String.join(", ", names);
        System.out.println("Names: " + res1);
        
        // With Varargs
        String res2 = String.join(" - ", "Apple", "Banana", "Orange");
        System.out.println("Fruits: " + res2);
        
        // String in the list
        List<String> colors = Arrays.asList("Red", "Green", "Blue");
        String res3 = String.join(" | ", colors);
        System.out.println("Colors: " + res3);
        
        // Empty Array , Empty list
        String[] emptyArray = {};
        String res4 = String.join(", ", emptyArray);
        System.out.println("Empty Array: '" + res4 + "'");

        List<String> emptyList = Collections.emptyList();
        String res5 = String.join(" - ", emptyList);
        System.out.println("Empty List: '" + res5 + "'");
        
        // Single element
        String[] single = {"Hello"};
        String res6 = String.join(", ", single);
        System.out.println("Single Element: " + res6);
        
		// Null element
		String[] withNull = {"A", null, "B"};
        String res7 = String.join(", ", withNull);
        System.out.println("With Null: " + res7);
        
        // with custom delimiter
        String[] numbers = {"1", "2", "3", "4"};
        String res8 = String.join(" => ", numbers);
        System.out.println("Numbers: " + res8);
       
        
      
        
      
        
        
	}
}
