package com.lakhmakova.lil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
  private final String url;
  private final Properties properties;

  //constructor for this class
  public DatabaseConnectionManager(String sqlManager, String host, String databaseName,
                                   String username, String password){
    this.url = "jdbc:" + sqlManager + "://" + host + "/" + databaseName;//jdbc:mysql://localhost:3306/wsda_music
    this.properties = new Properties();
    this.properties.setProperty("user", username);
    this.properties.setProperty("password", password);

  }
  //create a connection to the database
public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(this.url, this.properties);
}
}
