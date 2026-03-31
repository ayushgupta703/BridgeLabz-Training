
import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name, dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

public class Serialization {
    public static void main(String[] args) throws Exception {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "A", "IT", 50000));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.dat"));
        oos.writeObject(list);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.dat"));
        List<Employee> empList = (List<Employee>) ois.readObject();

        for (Employee e : empList) {
            System.out.println(e.name + " " + e.salary);
        }
        ois.close();
    }
}
