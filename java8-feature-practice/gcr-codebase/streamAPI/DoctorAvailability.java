package streamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Doctor {
	private String name;
	private String speciality;
	private String weekendAvailability;
	
	public Doctor(String name, String speciality, String weekendAvailability) {
		this.name = name;
		this.speciality = speciality;
		this.weekendAvailability = weekendAvailability;
	}

	public String getName() {
		return name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public String getWeekendAvailability() {
		return weekendAvailability;
	}

	@Override
	public String toString() {
		return "\"" + name + "\"" + " Speciality In " + "\"" + speciality + "\"";
	}
}

public class DoctorAvailability {
	public static void main(String[] args) {
		List<Doctor> doctors = List.of(
				new Doctor("Dr. Amit Sharma", "Cardiologist", "yes"),
				new Doctor("Dr. Neha Verma", "Dermatologist", "no"),
				new Doctor("Dr. Rahul Mehta", "Orthopedic", "yes"),
				new Doctor("Dr. Pooja Iyer", "Pediatrician", "yes"),
				new Doctor("Dr. Arjun Rao", "Neurologist", "yes"),
				new Doctor("Dr. Sneha Kulkarni", "Gynecologist", "no"),
				new Doctor("Dr. Kunal Desai", "ENT Specialist", "yes"),
				new Doctor("Dr. Ritu Malhotra", "Ophthalmologist", "no"),
				new Doctor("Dr. Suresh Nair", "General Physician", "yes"),
				new Doctor("Dr. Ananya Bose", "Psychiatrist", "no")
		);
		
		List<Doctor> weekendDoctors = doctors.stream()
				.filter(doctor->doctor.getWeekendAvailability() == "yes")
				.sorted(Comparator.comparing(Doctor::getSpeciality))
				.collect(Collectors.toList());
		
		weekendDoctors.forEach(System.out::println);
	}
}
