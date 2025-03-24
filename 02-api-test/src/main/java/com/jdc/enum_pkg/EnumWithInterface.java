package com.jdc.enum_pkg;

public class EnumWithInterface {
	public static void main(String[] args) {
		 Animal dog = Animal.DOG;
	     dog.makeSound();  // Output: Woof Woof!

	     Animal cat = Animal.CAT;
	     cat.makeSound();  // Output: Meow Meow!

	     Animal bird = Animal.BIRD;
	     bird.makeSound();  // Output: Chirp Chirp!
	}
}

//Interface ဖန်တီးခြင်း
interface SoundMaker {
 void makeSound();  // အသံထွက်ဖို့ method
}

//Enum နဲ့ Interface ကို တွဲသုံးခြင်း
enum Animal implements SoundMaker {
 DOG {
     @Override
     public void makeSound() {
         System.out.println("Woof Woof!");
     }
 },
 CAT {
     @Override
     public void makeSound() {
         System.out.println("Meow Meow!");
     }
 },
 BIRD {
     @Override
     public void makeSound() {
         System.out.println("Chirp Chirp!");
     }
 };
}

