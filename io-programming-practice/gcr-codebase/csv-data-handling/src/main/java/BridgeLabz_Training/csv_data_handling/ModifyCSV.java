package BridgeLabz_Training.csv_data_handling;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;

public class ModifyCSV {
    public static void main(String[] args) {
        try (
            CSVReader reader = new CSVReaderBuilder(new FileReader("CSV_Files/Employees.csv")).withSkipLines(1).build();
            CSVWriter writer = new CSVWriter(new FileWriter("CSV_Files/Update_Employees.csv"))) {
        	String[] header = {"ID", "Name", "Department", "Salary"};
            writer.writeNext(header);
            String[] row;
            while ((row = reader.readNext()) != null) {
                if (row[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(row[3]);
                    salary = salary + (salary * 0.10);
                    row[3] = String.valueOf((int) salary);
                }
                writer.writeNext(row);
            }
            System.out.println("Salary Updated Successfully For IT Department.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
