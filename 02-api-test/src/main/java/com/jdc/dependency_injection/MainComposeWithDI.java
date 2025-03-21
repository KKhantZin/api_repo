package com.jdc.dependency_injection;

class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class PetrolEngine extends Engine {
    public void start() {
        System.out.println("Petrol Engine started");
    }
}

class ElectricEngine extends Engine {
    public void start() {
        System.out.println("Electric Engine started");
    }
}

class Car {
    private Engine engine;

    public Car(Engine engine) { // Dependency ကို အပြင်ကနေ ထိုးသွင်းတယ်
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}

public class MainComposeWithDI {
    public static void main(String[] args) {
        Car petrolCar = new Car(new PetrolEngine());
        petrolCar.drive();

        Car electricCar = new Car(new ElectricEngine());
        electricCar.drive();
    }
}