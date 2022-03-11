package com.crazy_ataman.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyDAO implements DAO {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("DB");
    private final String url = resourceBundle.getString("DB.url");
    private final String user = resourceBundle.getString("DB.user");
    private final String password = resourceBundle.getString("DB.password");

    public MyDAO(){
        try{
            DriverManager.registerDriver(new SQLServerDriver());
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
