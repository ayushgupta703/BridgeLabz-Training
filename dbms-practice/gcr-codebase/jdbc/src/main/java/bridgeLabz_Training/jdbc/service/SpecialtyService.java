package bridgeLabz_Training.jdbc.service;

import bridgeLabz_Training.jdbc.model.Specialty;
import java.util.List;

public interface SpecialtyService {

    int addSpecialty(String name);

    List<Specialty> listSpecialties();

    void updateSpecialty(int id, String name);

    void deleteSpecialty(int id);
}