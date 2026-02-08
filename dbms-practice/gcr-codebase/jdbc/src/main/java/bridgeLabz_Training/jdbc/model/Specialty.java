package bridgeLabz_Training.jdbc.model;

public class Specialty {

    private int specialtyId;
    private String specialtyName;

    public Specialty() {}

    public Specialty(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public int getSpecialtyId() { return specialtyId; }
    public void setSpecialtyId(int specialtyId) { this.specialtyId = specialtyId; }

    public String getSpecialtyName() { return specialtyName; }
    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }
}