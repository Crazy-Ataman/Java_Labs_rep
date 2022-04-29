package requests;

import dao.*;
import models.SortMethod;

import java.sql.*;
import java.util.ArrayList;

public class DisciplineRequest {
    private final Connection connection;

    public DisciplineRequest() throws SQLException {
        DataAccessObject dao = new DAO();
        connection = dao.getConnection();
    }

    public ArrayList<SortMethod> selectSorts() throws SQLException {
        ArrayList<SortMethod> methods = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from disciplines_methods");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String discipline = resultSet.getString("discipline");
            methods.add(new SortMethod(name, discipline));
        }

        return methods;
    }

    public void addDiscipline(String name, String discipline) throws SQLException {
        String query = "insert into disciplines_methods values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, discipline);
        statement.executeUpdate();
        statement.close();
    }

    public void updateDiscipline(String name, String discipline) throws SQLException {
        String query = "update disciplines_methods set discipline = ? where name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, discipline);
        statement.setString(2, name);
        statement.executeUpdate();
        statement.close();
    }

    public void deleteDiscipline(String name) throws SQLException {
        String query = "delete from disciplines_methods where name = ?";
        //String query = "delete from java_servlet.dbo.disciplines_methods where name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.executeUpdate();
        statement.close();
    }
}