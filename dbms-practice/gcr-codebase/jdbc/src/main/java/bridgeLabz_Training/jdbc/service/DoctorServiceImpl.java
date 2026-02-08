package bridgeLabz_Training.jdbc.service;

import bridgeLabz_Training.jdbc.dao.DoctorDAO;
import bridgeLabz_Training.jdbc.dao.DoctorDAOImpl;
import bridgeLabz_Training.jdbc.model.Doctor;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorDAO doctorDAO = new DoctorDAOImpl();

    @Override
    public int addDoctor(Doctor doctor) {
        return doctorDAO.addDoctor(doctor);
    }

    @Override
    public boolean updateDoctorSpecialty(int doctorId, int specialtyId) {
        return doctorDAO.updateDoctorSpecialty(doctorId, specialtyId);
    }

    @Override
    public List<Doctor> getDoctorsBySpecialty(String specialty) {
        return doctorDAO.getDoctorsBySpecialty(specialty);
    }

    @Override
    public boolean deactivateDoctor(int doctorId) {
        if (doctorDAO.hasFutureAppointments(doctorId)) {
            throw new RuntimeException("Doctor has future appointments");
        }
        return doctorDAO.deactivateDoctor(doctorId);
    }
}