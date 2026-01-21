package BridgeLabz_Training.CSV_Handling;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
	public static void main(String[] args) {
		try (CSVWriter writer = new CSVWriter(new FileWriter("../CSV_Files/Output.csv"))) {
			String[] header = {"ID", "Name", "Department", "Salary"};
            String[] emp1 = {"101", "Alice Williams", "Finance", "62000"};
            String[] emp2 = {"102", "Bob Johnson", "Sales", "58000"};
            writer.writeNext(header);
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            System.out.println("CSV File Written Successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
