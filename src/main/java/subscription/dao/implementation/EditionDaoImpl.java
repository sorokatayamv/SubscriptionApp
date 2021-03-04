package subscription.dao.implementation;

import subscription.dao.interfaces.EditionDao;
import subscription.model.Edition;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EditionDaoImpl implements EditionDao {

    @Override
    public Edition save(Edition edition) {
        PreparedStatement ps = null;
        try (Connection conn =
                     DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1")) {
            String sql = "INSERT INTO editions (id_edition, name, cost) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, edition.getId());
            ps.setString(2, edition.getName());
            ps.setFloat(3, edition.getCost());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return edition;
    }

    @Override
    public Edition get(Integer id) {
        Edition edition = new Edition();
        PreparedStatement ps = null;
        try (Connection conn =
                     DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1")) {
            String sql = "SELECT * FROM editions WHERE id_edition = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();
            ResultSet resultSet = ps.getResultSet();
            resultSet.next();
            edition.setId(resultSet.getInt("id_edition"));
            edition.setName(resultSet.getString("name"));
            edition.setCost(resultSet.getFloat("cost"));
            System.out.println(edition.getId() + " " + edition.getName() + " " + edition.getCost());
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return edition;
    }

    @Override
    public void update(Edition edition, Integer id) {
        PreparedStatement ps = null;
        try (Connection conn =
                     DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1")) {

            String sql = "UPDATE editions SET id_edition = ?, name = ?, cost = ? WHERE id_edition = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, edition.getId());
            ps.setString(2, edition.getName());
            ps.setFloat(3, edition.getCost());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(Integer id) {
        PreparedStatement ps = null;
        try (Connection conn =
                     DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1")) {
            String sql = "DELETE FROM editions WHERE id_edition = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Edition> getListOfEdition() {
        try (Connection conn =
                     DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1");
             Statement statement = conn.createStatement();) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM editions");
            ArrayList<Edition> result = new ArrayList<>();
            while (resultSet.next()) {
                String nameEdition = resultSet.getString(2);
                int idEdition = resultSet.getInt(1);
                float cost = resultSet.getFloat(3);
                Edition edition = new Edition();
                edition.setId(idEdition);
                edition.setName(nameEdition);
                edition.setCost(cost);
                result.add(edition);
            }
            for (Edition edition : result) {
                System.out.println(edition.getName() + " " + edition.getCost());
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

}
