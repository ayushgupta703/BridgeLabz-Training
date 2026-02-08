package bridgeLabz_Training.jdbc.service;

import bridgeLabz_Training.jdbc.model.Prescription;

import java.util.List;

public interface VisitService {

    int completeVisit(int appointmentId, String diagnosis,
                      String notes, List<Prescription> prescriptions);

    List<String> getPatientHistory(int patientId);
}