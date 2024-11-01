package com.lakhmakova.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//class to run all the functions
public class JDBCExecutor {

    public static void main(String... args){
//before running this, make sure that your database is actually running
// "C:\Program Files\PostgreSQL\17\bin\psql.exe" -h localhost -U postgres -d hplussport
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("mysql", "localhost", "hplussport", "root", "1111");//sqlManager: mysql or postgresql, user: root or postgres
        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
