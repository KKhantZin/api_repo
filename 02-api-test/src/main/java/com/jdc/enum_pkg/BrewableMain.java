package com.jdc.enum_pkg;

//Main class မှာ စမ်းသပ်ခြင်း
public class BrewableMain {
	public static void main(String[] args) {
		// 1. Using constants and fields
		CoffeeType coffee = CoffeeType.LATTE;
		System.out.println("Selected coffee: " + coffee);
		System.out.println("Price: $" + coffee.getPrice());
		System.out.println("Flavor: " + coffee.getFlavor());
		coffee.ratingForEachTaste();

		System.out.println("----------------");

		// 2. Using regular method
		System.out.println(coffee.getPriceInfo());

		System.out.println("----------------");

		// 3. Using interface method (brew)
		Brewable brewable = CoffeeType.ESPRESSO;
		System.out.println(brewable.brew());

		System.out.println("----------------");

		// 4. Using built-in methods: values()
		System.out.println("All coffee types:");
		for (CoffeeType type : CoffeeType.values()) {
			System.out.println(type + " (Ordinal: " + type.ordinal() + ")");
		}

		System.out.println("----------------");

		// 5. Using built-in method: valueOf()
		CoffeeType cappuccino = CoffeeType.valueOf("CAPPUCCINO");
		System.out.println("Found coffee: " + cappuccino);
		System.out.println(cappuccino.brew());
		cappuccino.ratingForEachTaste();
	}
}

//Interface ဖန်တီးခြင်း
interface Brewable {
	String brew(); // ကော်ဖီဖျော်တဲ့ လုပ်ဆောင်ချက်
}

//Enum ဖန်တီးခြင်း
enum CoffeeType implements Brewable {
	// Constants with fields and constant-specific behavior
	ESPRESSO(2.5, "Strong") {
		@Override
		public String brew() {
			return "Brewing a strong Espresso shot.";
		}

		@Override
		public void ratingForEachTaste() {
			// TODO Auto-generated method stub
			System.out.println("Good taste.");
		}
	},
	LATTE(3.0, "Milky") {
		@Override
		public String brew() {
			return "Brewing a creamy Latte with steamed milk.";
		}
		@Override
		public void ratingForEachTaste() {
			// TODO Auto-generated method stub
			System.out.println("Good taste.");
		}
	},
	CAPPUCCINO(3.5, "Frothy") {
		@Override
		public String brew() {
			return "Brewing a frothy Cappuccino with foam.";
		}
		
		@Override
		public void ratingForEachTaste() {
			// TODO Auto-generated method stub
			System.out.println("Good taste.");
		}
	};

	// Fields
	private final double price; // ကော်ဖီတစ်ခွက်ရဲ့ ဈေးနှုန်း
	private final String flavor; // ကော်ဖီရဲ့ အရသာ

	// Constructor
	CoffeeType(double price, String flavor) {
		this.price = price;
		this.flavor = flavor;
	}

	// Regular method
	public double getPrice() {
		return price;
	}

	public String getFlavor() {
		return flavor;
	}

	// Method with logic
	public String getPriceInfo() {
		return String.format("%s costs $%.2f.", this.name(), this.price);
	}

	// Abstract method from interface (implemented in each constant)
	public abstract void ratingForEachTaste();
}
