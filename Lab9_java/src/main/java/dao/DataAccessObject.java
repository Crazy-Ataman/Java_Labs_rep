package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataAccessObject {
    Connection getConnection() throws SQLException;
}
