package bridgeLabz_Training.jdbc.service;

import bridgeLabz_Training.jdbc.dao.VisitDAO;
import bridgeLabz_Training.jdbc.dao.VisitDAOImpl;
import bridgeLabz_Training.jdbc.model.Prescription;
import bridgeLabz_Training.jdbc.model.Visit;

import java.util.List;

public class VisitServiceImpl implements VisitService {

    private final VisitDAO visitDAO = new VisitDAOImpl();

    @Override
    public int completeVisit(int appointmentId, String diagnosis,
                             String notes, List<Prescription> prescriptions) {

        try {
            int visitId = visitDAO.recordVisit(
                    new Visit(appointmentId, diagnosis, notes)
            );

            visitDAO.updateAppointmentStatus(appointmentId, "COMPLETED");

            for (Prescription p : prescriptions) {
                // attach visitId
                p = new Prescription(
                        visitId,
                        p.getMedicineName(),
                        p.getDosage(),
                        p.getDuration()
                );
            }

            visitDAO.addPrescriptions(prescriptions);
            return visitId;

        } catch (Exception e) {
            throw new RuntimeException("Visit transaction failed", e);
        }
    }

    @Override
    public List<String> getPatientHistory(int patientId) {
        return visitDAO.getMedicalHistory(patientId);
    }
}