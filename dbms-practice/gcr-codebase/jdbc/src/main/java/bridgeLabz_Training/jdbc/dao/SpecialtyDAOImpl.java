package bridgeLabz_Training.jdbc.dao;

import bridgeLabz_Training.jdbc.config.DBConnection;
import bridgeLabz_Training.jdbc.model.Specialty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyDAOImpl implements SpecialtyDAO {

    @Override
    public int addSpecialty(Specialty specialty) {
        String sql = "INSERT INTO specialties (specialty_name) VALUES (?)";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps =
                     c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, specialty.getSpecialtyName());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error adding specialty", e);
        }
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        String sql = "SELECT * FROM specialties";
        List<Specialty> list = new ArrayList<>();

        try (Connection c = DBConnection.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Specialty s = new Specialty();
                s.setSpecialtyId(rs.getInt("specialty_id"));
                s.setSpecialtyName(rs.getString("specialty_name"));
                list.add(s);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching specialties", e);
        }
    }

    @Override
    public boolean updateSpecialty(int id, String newName) {
        String sql = "UPDATE specialties SET specialty_name=? WHERE specialty_id=?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating specialty", e);
        }
    }

    @Override
    public boolean isSpecialtyInUse(int specialtyId) {
        String sql = "SELECT COUNT(*) FROM doctors WHERE specialty_id=?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, specialtyId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error checking specialty usage", e);
        }
    }

    @Override
    public boolean deleteSpecialty(int specialtyId) {
        String sql = "DELETE FROM specialties WHERE specialty_id=?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, specialtyId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting specialty", e);
        }
    }
}