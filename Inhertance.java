package reviews;

class Vehicle {
 String brand = "Generic Brand";

 public void honk() {
     System.out.println("Tuut, tuut!");
 }

 public void displayBrand() {
     System.out.println("Brand: " + brand);
 }
}

class Car extends Vehicle {
 String modelName = "Sedan";


 public void displayModel() {
     System.out.println("Model: " + modelName);
 }
}

class ElectricCar extends Car {
 int batteryCapacitykWh;

 public ElectricCar(int capacity) {
     this.batteryCapacitykWh = capacity;
     this.brand = "Tesla";
     this.modelName = "Model 3";
 }

 public void displayDetails() {
     System.out.println("--- Electric Car Details ---");
     displayBrand();
     displayModel();
     System.out.println("Battery Capacity: " + batteryCapacitykWh + " kWh");
     honk();
 }
}

public class Inhertance {
 public static void main(String[] args) {
     ElectricCar myEV = new ElectricCar(75);
     myEV.displayDetails();

     System.out.println();
 }
}
