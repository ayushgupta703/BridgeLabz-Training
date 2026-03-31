package BridgeLabz_Training.csv_data_handling;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.*;

public class SortTopPaidEmployees {
    public static void main(String[] args) throws Exception {

        CSVReader reader = new CSVReaderBuilder(new FileReader("CSV_Files/Employees.csv"))
                .withSkipLines(1)
                .build();

        List<String[]> records = new ArrayList<>();
        String[] row;

        while ((row = reader.readNext()) != null) {
            records.add(row);
        }
        reader.close();

        records.sort((a, b) ->
                Integer.parseInt(b[3]) - Integer.parseInt(a[3]));

        for (int i = 0; i < Math.min(5, records.size()); i++) {
            String[] r = records.get(i);
            System.out.println(r[1] + " | " + r[2] + " | " + r[3]);
        }
    }
}
