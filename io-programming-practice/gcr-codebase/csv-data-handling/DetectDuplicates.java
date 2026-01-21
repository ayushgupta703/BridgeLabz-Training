package BridgeLabz_Training.CSV_Handling;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) throws Exception {

        CSVReader reader = new CSVReader(new FileReader("../CSV_Files/duplicates.csv"));
        Set<String> seen = new HashSet<>();
        String[] row;

        reader.readNext();

        while ((row = reader.readNext()) != null) {
            if (!seen.add(row[0])) {
                System.out.println("Duplicate: " + String.join(",", row));
            }
        }
        reader.close();
    }
}
