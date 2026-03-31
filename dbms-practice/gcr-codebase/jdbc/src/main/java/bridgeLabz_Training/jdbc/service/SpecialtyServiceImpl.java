package bridgeLabz_Training.jdbc.service;

import bridgeLabz_Training.jdbc.dao.SpecialtyDAO;
import bridgeLabz_Training.jdbc.dao.SpecialtyDAOImpl;
import bridgeLabz_Training.jdbc.model.Specialty;

import java.util.List;

public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyDAO dao = new SpecialtyDAOImpl();

    @Override
    public int addSpecialty(String name) {
        return dao.addSpecialty(new Specialty(name));
    }

    @Override
    public List<Specialty> listSpecialties() {
        return dao.getAllSpecialties();
    }

    @Override
    public void updateSpecialty(int id, String name) {
        dao.updateSpecialty(id, name);
    }

    @Override
    public void deleteSpecialty(int id) {
        if (dao.isSpecialtyInUse(id)) {
            throw new RuntimeException("Cannot delete specialty: in use by doctors");
        }
        dao.deleteSpecialty(id);
    }
}