package com.jdc.nested_class;

public class StaticNestedVsInnerMain {
	public static void main(String[] args) {
		OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
		nested.dispaly();
		System.out.println();
		
//		OuterClass outer = new OuterClass();
//		OuterClass.NonStaticInnerClass inner = outer.new NonStaticInnerClass();
		
		OuterClass.NonStaticInnerClass inner = new OuterClass().new NonStaticInnerClass();
		inner.display();
		System.out.println();
		
		OuterClass out = new OuterClass();
		out.myMethod();
	}
}


class OuterClass {
	static int outerStaticVariable = 10;
	
	// Static Nested Class
	static class StaticNestedClass {
		void dispaly () {
			System.out.println("Static Nested Class.");
			System.out.println("Outer Static Variable : " + outerStaticVariable);
		}
	}
	
	// Non Static Inner Class
	public class NonStaticInnerClass {
		void display () {
			System.out.println("Non Static Inner Class.");
			System.out.println("Outer Static Variable : " + outerStaticVariable);
		}
	}
	
	// Local Class
	void myMethod () {
		class LocalInnerClass {
			void display () {
				System.out.println("Hello from Local Inner Class.");
				System.out.println("Outer Static Variable : " + outerStaticVariable);
			}
		}
		LocalInnerClass local = new LocalInnerClass();
		local.display();
	}
}

/*
Encapsulation: Outer class နဲ့ ဆက်နွယ်တဲ့ logic ကို သီးသန့်ထားလို့ရတယ်။
Code Readability: ကုဒ်ကို ပိုပြီး သပ်ရပ်စွာ စီစဉ်လို့ရတယ်။
Access Control: Inner class က outer class ရဲ့ private member တွေကို သုံးလို့ရတာမို့ အဆင်ပြေတယ်။
*/