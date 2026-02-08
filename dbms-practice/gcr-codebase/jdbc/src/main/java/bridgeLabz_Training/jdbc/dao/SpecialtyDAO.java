package bridgeLabz_Training.jdbc.dao;

import bridgeLabz_Training.jdbc.model.Specialty;
import java.util.List;

public interface SpecialtyDAO {

    int addSpecialty(Specialty specialty);

    List<Specialty> getAllSpecialties();

    boolean updateSpecialty(int id, String newName);

    boolean isSpecialtyInUse(int specialtyId);

    boolean deleteSpecialty(int specialtyId);
}