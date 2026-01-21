package BridgeLabz_Training.CSV_Handling;

import com.opencsv.*;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws Exception {

        Map<String, String[]> map = new HashMap<>();

        CSVReader r1 = new CSVReader(new FileReader("../CSV_Files/students1.csv"));
        CSVReader r2 = new CSVReader(new FileReader("../CSV_Files/students2.csv"));
        CSVWriter writer = new CSVWriter(new FileWriter("../CSV_Files/Merged.csv"));

        r1.readNext();
        r2.readNext();

        String[] row;
        while ((row = r1.readNext()) != null) {
            map.put(row[0], row);
        }

        writer.writeNext(new String[]{"ID","Name","Age","Marks","Grade"});

        while ((row = r2.readNext()) != null) {
            String[] s1 = map.get(row[0]);
            if (s1 != null) {
                writer.writeNext(new String[]{
                        s1[0], s1[1], s1[2], row[1], row[2]
                });
            }
        }

        r1.close(); r2.close(); writer.close();
        System.out.println("Data Merged Successfully!!");
    }
}
