package dbconnection;

import java.sql.*;

public class DbConnection {
    private static Connection conn;

    public DbConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:sqlite-tools-win32-x86-3410200/hranyFilmy.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public static void createTable() {
		
		try {
	        Statement statement = conn.createStatement();
	        statement.execute("DROP TABLE IF EXISTS hranyFilmy");
	        statement.execute("CREATE TABLE IF NOT EXISTS hranyFilmy (id INTEGER PRIMARY KEY, title TEXT, director TEXT, year INTEGER, actors TEXT, rating INTEGER, ratingText TEXT)");
	    } 
		catch (SQLException e) {
	        System.out.println("Error creating table: " + e.getMessage());
	    }
	}

	public static void insertMovie(String title, String director, int year, String actors, int rating, String ratingText) {

		try {
	        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO hranyFilmy (title, director, year, actors, rating, ratingText) VALUES (?, ?, ?, ?, ?, ?)");
	        preparedStatement.setString(1, title);
	        preparedStatement.setString(2, director);
	        preparedStatement.setInt(3, year);
	        preparedStatement.setString(4, actors);
	        preparedStatement.setInt(5, rating);
	        preparedStatement.setString(6, ratingText);
	        preparedStatement.executeUpdate();
	    } 
		catch (SQLException e) {
	        System.out.println("Error inserting movie: " + e.getMessage());
	    }
	}
}
