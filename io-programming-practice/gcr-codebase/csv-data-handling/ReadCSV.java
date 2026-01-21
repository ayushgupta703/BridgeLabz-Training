package BridgeLabz_Training.CSV_Handling;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class ReadCSV {
	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReader(new FileReader("../CSV_Files/Output.csv"));
		String[] nextLine;
		while((nextLine = reader.readNext()) != null) {
			System.out.println("ID: " + nextLine[0] + " Name: " + nextLine[1]);
		}
		reader.close();
	}
}
