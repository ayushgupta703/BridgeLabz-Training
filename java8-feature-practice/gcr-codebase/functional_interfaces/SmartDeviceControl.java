package functional_interfaces;

interface DeviceControls {
	void turnOn();
	void turnOff();
}

class Lights implements DeviceControls {
	@Override
	public void turnOn() {
		System.out.println("Lights Turned On!!");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Lights Turned Off!!");
	}
}

class AC implements DeviceControls {
	@Override
	public void turnOn() {
		System.out.println("AC Turned On!!");
	}
	
	@Override
	public void turnOff() {
		System.out.println("AC Turned Off!!");
	}
}
class TV implements DeviceControls {
	@Override
	public void turnOn() {
		System.out.println("TV Turned On!!");
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV Turned Off!!");
	}
}

public class SmartDeviceControl {
	public static void main(String[] args) {
		DeviceControls[] devices = {
				new Lights(), new AC(), new TV()
		};
		for (DeviceControls device : devices) {
			device.turnOn();
			device.turnOff();
		}
	}
}
