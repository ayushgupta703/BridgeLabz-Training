package BridgeLabz_Training.json_handling;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
	public String brand;
	public String model;
	public String color;
	
	public Car(String brand, String model, String color) {
		this.brand = brand;
		this.model = model;
		this.color = color;
	}
}

public class ObjectToJSON {
	public static void main(String[] args) throws Exception {
		ObjectMapper oMapper = new ObjectMapper();
		Car car = new Car("BMW", "M5 Competetion", "Black");
		String jsonString = oMapper.writeValueAsString(car);
		System.out.println(jsonString);
	}
}
