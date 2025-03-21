package com.jdc.tight_coupling;

public class Car {
	
	private Engine engine;
	private PetroEngine petroEngine; // Specific type 
	
	// car make an engine itself.
	public Car() {
		this.engine = new Engine(); // Tight coupling
	}
	
	void drive() {
		engine.start();
		System.out.println("Car is driving now.");
	}
}

/*
Car Class က Engine ကို သူ့အတွင်းမှာ ကိုယ်တိုင် new Engine() နဲ့ ဖန်တီးတယ်။
ဒါက Tight Coupling ဖြစ်စေတယ်။ ဘာလို့ဆို Car က Engine အမျိုးအစားကို သူကိုယ်တိုင် ထိန်းချုပ်ထားတယ်။
အကယ်၍ PetrolEngine ဒါမှမဟုတ် ElectricEngine သုံးချင်ရင် Car Class ကို ပြင်ရမယ်။
*/
