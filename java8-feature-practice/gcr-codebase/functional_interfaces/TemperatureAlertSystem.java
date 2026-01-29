package functional_interfaces;

import java.util.function.Predicate;
import java.util.Scanner;

public class TemperatureAlertSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double thresholdTemperature = 40;
		Predicate<Double> alert = temperature -> temperature > thresholdTemperature;
		System.out.print("Enter Temperature: ");
		boolean isAlert = alert.test(scanner.nextDouble());
		if (isAlert) {
			System.out.println("Alert! Temperature is Dangerous");
		} else {
			System.out.println("Normal Temperature!!");
		}
		scanner.close();
	}
}
