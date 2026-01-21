package BridgeLabz_Training.csv_data_handling;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class ValidateCSV {
    public static void main(String[] args) throws Exception {

        CSVReader reader = new CSVReader(new FileReader("CSV_Files/users.csv"));
        String[] row;

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "\\d{10}";

        reader.readNext(); // skip header

        while ((row = reader.readNext()) != null) {
            if (!row[2].matches(emailRegex) || !row[3].matches(phoneRegex)) {
                System.out.println("Invalid Row: " + String.join(",", row));
            }
        }
        reader.close();
    }
}
