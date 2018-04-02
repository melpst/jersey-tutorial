package com.ddth.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {

    public static Connection connection = null;

    public static Connection getConnection() throws SQLException {

        try {
            Context initContext = new InitialContext();
            DataSource ds = null;
            ds = (DataSource) initContext.lookup("MySqlDS");
            connection = ds.getConnection();
        }catch(Exception e){
            e.printStackTrace();
        }

        return connection;

    }

    public static void closeConnection(Connection connection) {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
