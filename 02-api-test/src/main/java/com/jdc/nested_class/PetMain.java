package com.jdc.nested_class;

public class PetMain {
	public static void main(String[] args) {
		// create a category by using Static Nested Class
        PetStore.PetCategory category = new PetStore.PetCategory("Dogs");
        category.displayCategory();

        // use outer and inner
        PetStore store = new PetStore();
        store.addNewPet("Milo", "Dog"); // Output: Milo is Dog and come from Happy Paws Pet Store
        store.addNewPet("Luna", "Cat"); // Output: Luna က Cat and come from Happy Paws Pet Store
	}
}

class PetStore {
	private String storeName = "Happy Paws Pet Store"; 
    private int totalPets = 10;

    // Static Nested Class
    static class PetCategory {
        private String categoryName;

        PetCategory(String name) {
            this.categoryName = name;
        }

        void displayCategory() {
            System.out.println("Pet Category: " + categoryName);
        }
    }
    
    // Inner Class
    class Pet {
        private String petName;
        private String type;

        Pet(String petName, String type) {
            this.petName = petName;
            this.type = type;
        }

        void introducePet() {
            // Access Control:
            System.out.println(petName + " is " + type + " and come from " + storeName);
            System.out.println("Total pets :  " + totalPets);
        }
    }
    
    // Encapsulation:
    void addNewPet(String petName, String type) {
        Pet newPet = new Pet(petName, type);
        totalPets++;
        newPet.introducePet();
    }
}

/*
Encapsulation
PetStore class ထဲမှာ storeName နဲ့ totalPets ကို private လုပ်ထားပြီး၊ Pet inner class က အဲ့ဒီ data တွေကို အသုံးပြုနိုင်အောင် 
သီးသန့် logic ထည့်ထားတယ်။ addNewPet method ကနေ သက်ဆိုင်ရာ တိရစ္ဆာန်အသစ်ထည့်တာကို ထိန်းချုပ်ထားတာမို့ အပြင်က ဝင်မွှေလို့ မရဘူး။

Code Readability
PetCategory (static nested class) နဲ့ Pet (inner class) ကို PetStore ထဲမှာ ထည့်ထားတာမို့ 
ဆိုင်နဲ့ ဆက်နွယ်တဲ့ အရာအကုန်က တစ်နေရာထဲမှာ သပ်ရပ်စွာ ရှိနေတယ်။ 
ကုဒ်ဖတ်တဲ့သူအတွက် ဘာက ဘယ်လိုဆက်စပ်နေလဲ ရှင်းတယ်။

Access Control
Pet inner class က PetStore ရဲ့ private member တွေ (storeName, totalPets) ကို အသုံးပြုနိုင်တယ်။ 
ဒါက inner class ရဲ့ အားသာချက်ပဲ။ ဒါပေမယ့် PetCategory static nested class ကတော့ outer class ရဲ့ instance မလိုပဲ သီးသန့်အလုပ်လုပ်နိုင်တယ်။ 
*/