package dao;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DAO implements DataAccessObject{
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    private final String url = resourceBundle.getString("DB.url");
    private final String user = resourceBundle.getString("DB.user");
    private final String password = resourceBundle.getString("DB.password");

    public DAO() {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
