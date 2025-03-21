package com.jdc.dependency_injection;

class Engine1 {
    public void start() {
        System.out.println("Engine started");
    }
}

class PetrolEngine1 extends Engine1 {
    public void start() {
        System.out.println("Petrol Engine started");
    }
}

class Car1 {
    private Engine1 engine;

    public void setEngine1(Engine1 engine) { // Setter ကနေ Inject လုပ်တယ်
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}

public class MainComposeWithSettor {
    public static void main(String[] args) {
        Car1 car = new Car1();
        car.setEngine1(new PetrolEngine1());
        car.drive();
    }
}

/*
 1. Tight Coupling အနည်းငယ် ကျန်နေသေးခြင်း
ပြဿနာ: Car Class က Engine Class ကို တိုက်ရိုက် မှီခိုနေတယ်။ 
Interface မသုံးထားတာကြောင့် Engine ရဲ့ Subclass တွေကိုပဲ Inject လုပ်လို့ရပြီး၊ လုံးဝ မသက်ဆိုင်တဲ့ Class (ဥပမာ Motor) ကို Inject လုပ်လို့မရဘူး။
ဒါက Flexibility ကို ကန့်သတ်ထားတယ်။

class Motor { // Engine နဲ့ မသက်ဆိုင်တဲ့ Class
    public void start() {
        System.out.println("Motor started");
    }
}

class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car(new Motor()); // Error: Motor is not an Engine
    }
}

ရလဒ်: Compilation Error ဖြစ်မယ်။ Motor က Engine ရဲ့ Subclass မဟုတ်လို့ Car က လက်ခံလို့မရဘူး။
ဘာကြောင့် အားနည်းလဲ?: Interface သုံးရင် Motor ကို Interface ကို Implement လုပ်ပြီး Inject လို့ရမယ်။ အခုတော့ Engine Class ကိုပဲ မှီခိုနေရတယ်။

==============================================

Scalability နဲ့ Extensibility အားနည်းခြင်း
ပြဿနာ: အနာဂတ်မှာ ပိုရှုပ်ထွေးတဲ့ Engine အမျိုးအစားတွေ ထပ်ထည့်ချင်တယ်ဆိုရင်၊ Engine Class ကို အခြေခံပြီး Subclass တွေ အများကြီး လုပ်ရမယ်။
 ဒါက Codebase ကို ရှုပ်ထွေးစေပြီး ထိန်းသိမ်းရခက်တယ်။ Interface သုံးရင် ပိုမိုလွယ်ကူစွာ တိုးချဲ့လို့ရတယ်။
ကုဒ်နဲ့ ဥပမာ:
အကယ်၍ Engine မှာ နောက်ထပ် Method တွေ ထပ်ထည့်ချင်တယ် (ဥပမာ stop())၊ Subclass တွေအားလုံးကို ပြင်ရမယ်။

class Engine {
    public void start() {
        System.out.println("Engine started");
    }
    public void stop() {
        System.out.println("Engine stopped");
    }
}

class PetrolEngine extends Engine {
    public void start() {
        System.out.println("Petrol Engine started");
    }
    // stop() ကို Override မလုပ်ရင် Parent ရဲ့ Implementation ကိုပဲ သုံးမယ်
}

class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
        engine.stop();
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car(new PetrolEngine());
        car.drive();
    }
}

အားနည်းချက် အနှစ်ချုပ်
Tight Coupling: Engine Class ကို တိုက်ရိုက် မှီခိုနေရတာကြောင့် လုံးဝ မသက်ဆိုင်တဲ့ Class တွေကို Inject လုပ်လို့မရဘူး။
Inheritance Dependency: Engine ရဲ့ Subclass တွေကိုပဲ အားကိုးရပြီး Inheritance Hierarchy ကို ထိန်းသိမ်းရတယ်။
Scalability အားနည်းတယ်: အနာဂတ်မှာ ပိုရှုပ်ထွေးတဲ့ လိုအပ်ချက်တွေ ပေါ်လာရင် ဒီဇိုင်းက အဆင်မပြေနိုင်ဘူး။

============================================

ဖြေရှင်းနည်း (Optional)
ဒီအားနည်းချက်တွေကို ဖြေရှင်းဖို့ Interface ထည့်သုံးတာက အကောင်းဆုံးပါ။ Interface သုံးရင်:

Car က Abstraction (Engine Interface) ကို မှီခိုမှာမို့ Loose Coupling ပိုဖြစ်မယ်။
Inheritance မလိုဘဲ မတူညီတဲ့ Class တွေကို Implement လုပ်ပြီး Inject လို့ရမယ်။
Scalability ပိုကောင်းမယ်။

interface Engine {
    void start();
}

class PetrolEngine implements Engine {
    public void start() {
        System.out.println("Petrol Engine started");
    }
}

class ElectricEngine implements Engine {
    public void start() {
        System.out.println("Electric Engine started");
    }
}

class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}

public class Main {
    public static void main(String[] args) {
        Car petrolCar = new Car(new PetrolEngine());
        petrolCar.drive();

        Car electricCar = new Car(new ElectricEngine());
        electricCar.drive();
    }
}
 */
