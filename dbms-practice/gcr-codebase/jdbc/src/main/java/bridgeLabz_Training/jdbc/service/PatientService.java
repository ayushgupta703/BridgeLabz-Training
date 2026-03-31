package bridgeLabz_Training.jdbc.service;

import bridgeLabz_Training.jdbc.model.Patient;
import java.util.List;

public interface PatientService {

    int registerPatient(Patient patient);

    Patient getPatientById(int patientId);

    boolean updatePatient(Patient patient);

    List<Patient> searchPatientsByName(String name);

    Patient getPatientByPhone(String phone);

    List<String> getVisitHistory(int patientId);
}