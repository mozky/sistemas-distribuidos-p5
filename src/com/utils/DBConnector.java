package com.utils;

import java.sql.*;

public class DBConnector {
    public Connection conn = null;
    public Statement stmt = null;
    public PreparedStatement preparedStmt = null;
    public ResultSet resultSet = null;

    public DBConnector() {
        LoadDriver.load();
    }

    public void openDBConnection() {
        try {
             conn = DriverManager.getConnection("jdbc:mysql://localhost/distribuidos?"
                    + "user=root&password=&serverTimezone=UTC&useSSL=false");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readDataBase() throws Exception {
        try {
            // Setup the connection with the DB
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost/distribuidos?"
                            + "user=root&password=&serverTimezone=UTC&useSSL=false");

            // Statements allow to issue SQL queries to the database
            stmt = conn.createStatement();
            // Result set get the result of the SQL query
            resultSet = stmt
                    .executeQuery("select * from distribuidos.equipos");
            writeResultSet(resultSet);

/*            // PreparedStatements can use variables and are more efficient
            preparedStmt = conn
                    .prepareStatement("insert into  test.comments values (default, ?, ?, ?, ? , ?, ?)");
            // "myuser, webpage, datum, summary, COMMENTS from test.comments");
            // Parameters start with 1
            preparedStmt.setString(1, "Test");
            preparedStmt.setString(2, "TestEmail");
            preparedStmt.setString(3, "TestWebpage");
            preparedStmt.setDate(4, new java.sql.Date(2009, 12, 11));
            preparedStmt.setString(5, "TestSummary");
            preparedStmt.setString(6, "TestComment");
            preparedStmt.executeUpdate();

            preparedStmt = conn
                    .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from test.comments");
            resultSet = preparedStmt.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
            preparedStmt = conn
                    .prepareStatement("delete from test.comments where myuser= ? ; ");
            preparedStmt.setString(1, "Test");
            preparedStmt.executeUpdate();

            resultSet = stmt
                    .executeQuery("select * from test.comments");
            writeMetaData(resultSet);*/

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            String ID = resultSet.getString(1);
            String IP = resultSet.getString(2);
            String Nombre = resultSet.getString(3);
            String Latencia = resultSet.getString(4);
            System.out.println("ID: " + ID);
            System.out.println("IP: " + IP);
            System.out.println("Nombre: " + Nombre);
            System.out.println("Latencia: " + Latencia);
        }
    }

    // You need to close the resultSet
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {

        }
    }
}
