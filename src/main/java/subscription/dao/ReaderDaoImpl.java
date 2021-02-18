package subscription.dao;

import subscription.model.Edition;
import subscription.model.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderDaoImpl implements ReaderDao {
    @Override
    public Reader save(Reader reader) {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1");
            String sql = "INSERT INTO readers (id_edition, surname, name, patronymic) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = null;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reader.getId());
            ps.setString(2, reader.getSurname());
            ps.setString(3, reader.getName());
            ps.setString(4, reader.getPatronymic());
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return reader;
    }

    @Override
    public void update(Reader reader, Integer id) {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1");

            String sql = "UPDATE readers SET id_user = ?, surname = ?, name = ?, patronymic = ? WHERE id_user = ?";
            PreparedStatement ps = null;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reader.getId());
            ps.setString(2, reader.getSurname());
            ps.setString(3, reader.getName());
            ps.setString(4, reader.getPatronymic());
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public Reader get(Integer id) {
        Reader reader = new Reader();
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1");

            String sql = "SELECT * FROM readers WHERE id_user = ?";
            PreparedStatement ps = null;
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeQuery();
            ResultSet resultSet = ps.getResultSet();
            resultSet.next();
            reader.setId(resultSet.getInt("id_user"));
            reader.setSurname(resultSet.getString("surname"));
            reader.setName(resultSet.getString("name"));
            reader.setPatronymic(resultSet.getString("patronymic"));
            System.out.println(reader.getId() + " " + reader.getSurname() + " " + reader.getName() + " " + reader.getPatronymic());
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return reader;
    }

    @Override
    public void remove(Integer id) {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1");

            String sql = "DELETE FROM readers WHERE id_user = ?";
            PreparedStatement ps = null;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public List<Reader> getListOfReaders() {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:postgresql://localhost/periodicals?user=postgres&password=1");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM readers" );
            ArrayList<Reader> result = new ArrayList<>();
            while (resultSet.next()) {
                int idUser = resultSet.getInt(1);
                String surnameUser = resultSet.getString(2);
                String nameUser = resultSet.getString(3);
                String patronymicUser = resultSet.getString(4);
                Reader reader = new Reader();
                reader.setId(idUser);
                reader.setSurname(surnameUser);
                reader.setName(nameUser);
                reader.setPatronymic(patronymicUser);
                result.add(reader);
            }
            for (Reader reader : result) {
                System.out.println(reader.getSurname() + " " + reader.getName() + " " + reader.getPatronymic());
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
