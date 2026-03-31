package bridgeLabz_Training.jdbc.dao;

import bridgeLabz_Training.jdbc.model.Doctor;
import java.util.List;

public interface DoctorDAO {

    int addDoctor(Doctor doctor);

    boolean updateDoctorSpecialty(int doctorId, int specialtyId);

    List<Doctor> getDoctorsBySpecialty(String specialtyName);

    boolean deactivateDoctor(int doctorId);

    boolean hasFutureAppointments(int doctorId);
}