package streamAPI;

import java.util.List;

public class IOTSensorReadings {
	public static void main(String[] args) {
		List<Double> readings = List.of(100.00, 50.00, 40.00, 75.50, 85.00);
		readings.stream()
		.filter(reading->reading > 75)
		.forEach(System.out::println);
	}
}
