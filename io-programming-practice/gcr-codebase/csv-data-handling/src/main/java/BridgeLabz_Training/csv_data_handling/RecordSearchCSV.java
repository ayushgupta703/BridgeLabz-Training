package BridgeLabz_Training.csv_data_handling;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;

public class RecordSearchCSV {
	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReaderBuilder(new FileReader("CSV_Files/Employees.csv")).withSkipLines(1).build();
		String[] row;
		String name = "Rohit Verma";
		while((row = reader.readNext()) != null) {
			if (name.equals(row[1])) {
				System.out.println("Department: " + row[2] + " | Salary: " + row[3]);
				return;
			}
		}
		System.out.println("Name not found in records.");
	}
}
