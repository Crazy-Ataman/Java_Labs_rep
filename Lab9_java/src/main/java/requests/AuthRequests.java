package requests;

import dao.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthRequests {
    private final Connection connection;

    public AuthRequests() throws SQLException {
        DAO dao = new DAO();
        connection = dao.getConnection();
    }

    public void addUser(String login, String password) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into user_auth values(?, ?, ?)");
        statement.setString(1, login);
        statement.setString(2, String.valueOf(password.hashCode()));
        statement.setString(3, "user");
        statement.executeUpdate();
        statement.close();
    }

    public String checkUser(String login, String password) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select password, status from user_auth where login = ?");
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("password").equals(String.valueOf(password.hashCode()))
                    ? resultSet.getString("status") : "null";
        }

        return "null";
    }
}