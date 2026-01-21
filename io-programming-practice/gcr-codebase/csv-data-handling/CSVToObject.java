package BridgeLabz_Training.CSV_Handling;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

class Student {
    String id, name;
    int marks;

    Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return id + " | " + name + " | " + marks;
    }
}

public class CSVToObject {
    public static void main(String[] args) throws Exception {

        CSVReader reader = new CSVReader(new FileReader("../CSV_Files/students.csv"));
        List<Student> list = new ArrayList<>();
        String[] row;

        reader.readNext();

        while ((row = reader.readNext()) != null) {
            list.add(new Student(row[0], row[1], Integer.parseInt(row[2])));
        }

        reader.close();
        list.forEach(System.out::println);
    }
}