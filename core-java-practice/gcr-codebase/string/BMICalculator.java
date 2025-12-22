package String;
import java.util.Scanner;

public class BMICalculator {
	public static String[][] computeBMIAndStatus(double[][] data) {
        String[][] results = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightMeter = heightCm / 100;

            double bmi = weight / (heightMeter * heightMeter);

            String status;
            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status = "Normal";
            } else if (bmi >= 25 && bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            results[i][0] = String.format("%.2f", heightCm);
            results[i][1] = String.format("%.2f", weight);
            results[i][2] = String.format("%.2f", bmi);
            results[i][3] = status;
        }

        return results;
    }

    public static void displayResults(String[][] data) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height", "Weight", "BMI", "Status");
        System.out.println("--------------------------------------------------------------------------------");
        for (String[] person : data) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", person[0], person[1], person[2], person[3]);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] personData = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (kg) for person " + (i + 1) + ":");
            personData[i][0] = sc.nextDouble();

            System.out.println("Enter height (cm) for person " + (i + 1) + ":");
            personData[i][1] = sc.nextDouble();
        }

        String[][] results = computeBMIAndStatus(personData);

        displayResults(results);

        sc.close();
    }
}
