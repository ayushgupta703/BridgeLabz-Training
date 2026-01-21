package BridgeLabz_Training.CSV_Handling;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;

public class CountRowsInCSV {
	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReaderBuilder(new FileReader("../CSV_Files/Output.csv")).withSkipLines(1).build();
		int count = 0;
		while (reader.readNext() != null) {
			count++;
		}
		System.out.println("Number of Rows Excluding Headers Is: " + count);
		reader.close();
	}
}
