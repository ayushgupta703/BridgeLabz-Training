package collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
	private String name;
	private String gradeLevel;
	
	public Student(String name, String gradeLevel) {
		this.name = name;
		this.gradeLevel = gradeLevel;
	}
	
	public String getName() {
		return name;
	}
	public String getGradeLevel() {
		return gradeLevel;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}

public class StudentResultGrouping {
	public static void main(String[] args) {
		List<Student> students = List.of(
				new Student("Rahul", "A"),
				new Student("Ananya", "B"),
				new Student("Priya", "A"),
				new Student("Karan", "C"),
				new Student("Sneha", "B"),
				new Student("Amit", "A"),
				new Student("Neha", "C")
		);
		
		Map<String, List<Student>> studentGrouper = students.stream().collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.toList()));
		studentGrouper.forEach((grade, name) -> System.out.println(grade + " -> " + name.toString()));
	}
}
