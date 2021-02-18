package subscription.dao;

import subscription.model.Edition;
import subscription.model.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDaoImpl implements SubscriptionDao {

    @Override
    public List<Edition> getEditionsByUserId(int id) {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1");
            PreparedStatement ps = conn.prepareStatement("SELECT * from EDITIONS INNER JOIN subscription ON editions.id_edition = subscription.id_edition INNER JOIN readers ON subscription.id_user = readers.id_user WHERE readers.id_user = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
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
                System.out.println(edition.getName());
            }
            return result;


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    @Override
    public List<Reader> getReaderByEditionId(int id) {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM readers INNER JOIN subscription ON readers.id_user = subscription.id_user INNER JOIN editions ON subscription.id_edition = editions.id_edition WHERE editions.id_edition = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Reader> result = new ArrayList<>();
            while (resultSet.next()) {
                int idReader = resultSet.getInt(1);
                String surnameReader = resultSet.getString(2);
                String nameReader = resultSet.getString(3);
                String patronymicReader = resultSet.getString(4);
                Reader reader = new Reader();
                reader.setId(idReader);
                reader.setSurname(surnameReader);
                reader.setName(nameReader);
                reader.setPatronymic(patronymicReader);
                result.add(reader);
            }
            for (Reader reader : result) {
                System.out.println(reader.getId() + " " + reader.getSurname() + " " + reader.getName() + " " + reader.getPatronymic());
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }
}
