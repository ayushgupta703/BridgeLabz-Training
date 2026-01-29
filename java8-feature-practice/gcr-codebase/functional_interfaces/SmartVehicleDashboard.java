package functional_interfaces;

interface VehicleDashboard {
    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery: 75%");
    }
}

class ElectricVehicle implements VehicleDashboard {
    public void displaySpeed() {
        System.out.println("Speed: 60 km/h");
    }
}

public class SmartVehicleDashboard {
    public static void main(String[] args) {
        VehicleDashboard v = new ElectricVehicle();
        v.displaySpeed();
        v.displayBattery();
    }
}
