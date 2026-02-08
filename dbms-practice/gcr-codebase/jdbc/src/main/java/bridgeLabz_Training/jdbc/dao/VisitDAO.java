package bridgeLabz_Training.jdbc.dao;

import bridgeLabz_Training.jdbc.model.Prescription;
import bridgeLabz_Training.jdbc.model.Visit;

import java.util.List;

public interface VisitDAO {

    int recordVisit(Visit visit);

    void updateAppointmentStatus(int appointmentId, String status);

    List<String> getMedicalHistory(int patientId);

    void addPrescriptions(List<Prescription> prescriptions);
}