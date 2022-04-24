package com.example.demo2.DB;

import java.sql.*;

public class DB {
    private Connection connection;
    public DB() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/labjava";
        String user = "root";
        String pass = "root";
        connection = DriverManager.getConnection(url, user,pass);
    }
    public void addUser(String username, String password, String role) throws SQLException {
        Statement myStmt = connection.createStatement();
        myStmt.execute("INSERT INTO `users` (`login`, `password`, `Role`) " +
                "VALUES ('"+username+"', '"+password.hashCode()+"', '"+role+"');");
    }
    public boolean isUser(String username, String password, String role) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT `login`, `password`, `Role` FROM `users` WHERE `login` = '"+username+
                "' AND `password` = '"+password.hashCode()+"' AND `Role` = '"+role+"'");

        ResultSet resultSet = st.executeQuery();
       return resultSet.next();
    }
    public void closeConnection() throws SQLException {
        //ClearTableUsers();
        connection.close();
    }
    public void FillTableUsers() throws SQLException {
        Statement myStmt = connection.createStatement();
        myStmt.execute("INSERT INTO `users` (`login`, `password`, `Role`) " +
                "VALUES ('Vsevolod', '"+"seva123".hashCode()+"', 'admin'),"+
                "       ('Bob', '"+"asd123".hashCode()+"', 'user'),"+
                "       ('Alice', '"+"1243".hashCode()+"', 'user')");
    }
    public void ClearTableUsers() throws SQLException {
        Statement myStmt = connection.createStatement();
        myStmt.execute("DELETE FROM `users`");
    }
}
