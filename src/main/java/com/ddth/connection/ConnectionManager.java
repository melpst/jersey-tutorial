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

            Context initContext = null;
            try {
                initContext = new InitialContext();
            } catch (NamingException e) {
                e.printStackTrace();
            }
            DataSource ds = null;
            ds = (DataSource) initContext.lookup("MySqlDS");
            connection = ds.getConnection();
			/*
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://localhost:1433;databaseName=PrimaryDB";
			String user = "aep";
			String password = "aep01";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			 */
//		}catch (NamingException e) {
//			e.printStackTrace();
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
