package ScenarioBased;
import java.util.Scanner;

public class CoffeeCounter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final double gst_rate = 0.05;
		while(true) {
			System.out.print("Tell Your Coffee Type('exit' to stop): ");
			String coffee = scanner.nextLine();
			if (coffee.equals("exit") || coffee.equals("Exit")) {
				System.out.println("Thank You! Cafe Closed....");
				break;
			}
			System.out.print("Quantity: ");
			int quantity = scanner.nextInt();
			scanner.nextLine();
			int unitPrice = 0;
			
			switch (coffee) {
				case "cappucino":
				case "Cappucino": {
					unitPrice = 60;
					break;
				}
				case "espresso":
				case "Espresso": {
					unitPrice = 80;
					break;
				}
				case "mocha":
				case "Mocha": {
					unitPrice = 50;
					break;
				}
				case "lattes":
				case "Lattes": {
					unitPrice = 100;
					break;
				}
				default: {
					System.out.println("We don't have this option.");
				}
			
			}
			double baseBill = unitPrice * quantity;
			double gst = baseBill *gst_rate;
			double finalBill = baseBill + gst;
			
			System.out.println("Base Bill: " + baseBill);
			System.out.println("GST (5%): " + gst);
			System.out.println("Total Bill: " + finalBill);
				
		}
		scanner.close();
	}
}
