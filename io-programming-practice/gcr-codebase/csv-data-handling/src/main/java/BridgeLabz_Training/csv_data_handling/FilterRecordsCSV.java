package BridgeLabz_Training.csv_data_handling;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;

public class FilterRecordsCSV {
	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReaderBuilder(new FileReader("CSV_Files/Student.csv")).withSkipLines(1).build();
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			int marks = Integer.parseInt(nextLine[3]);
			if (marks > 80) {
				System.out.println("ID: " + nextLine[0] + " | Name: " + nextLine[1] + " | Subject: " + nextLine[2] + " | Marks: " + nextLine[3]);
			}
		}
		reader.close();
	}
}
