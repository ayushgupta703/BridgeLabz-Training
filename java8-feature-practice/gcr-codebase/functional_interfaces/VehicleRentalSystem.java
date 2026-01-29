package functional_interfaces;

interface RentalSystem {
	void rent();
	void returnVehicle();
}

class Cars implements RentalSystem {
	@Override
	public void rent() {
		System.out.println("Car Rented!!");
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Car Returned!!");
	}
}

class Bikes implements RentalSystem {
	@Override
	public void rent() {
		System.out.println("Bike Rented!!");
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Bike Returned!!");
	}
}
class Buses implements RentalSystem {
	@Override
	public void rent() {
		System.out.println("Bus Rented!!");
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Bus Returned!!");
	}
}

public class VehicleRentalSystem {
	public static void main(String[] args) {
		RentalSystem[] vehicles = {
				new Cars(), new Bikes(), new Buses()
		};
		for (RentalSystem vehicle : vehicles) {
			vehicle.rent();
			vehicle.returnVehicle();
		}
	}
}
