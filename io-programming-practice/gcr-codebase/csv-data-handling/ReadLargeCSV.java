package BridgeLabz_Training.CSV_Handling;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;

public class ReadLargeCSV {

    public static void main(String[] args) throws Exception {

        CSVReader reader = new CSVReaderBuilder(new FileReader("../CSV_Files/LargeEmployees.csv")).withSkipLines(1).build();
        String[] row;
        int count = 0;
        int batchSize = 100;
        while ((row = reader.readNext()) != null) {
            count++;
            if (count % batchSize == 0) {
                System.out.println("Processed records: " + count);
            }
        }
        reader.close();
        System.out.println("Total records processed: " + count);
    }
}
