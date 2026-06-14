package com.example.book;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class Database {   

    private static final Path DB_PATH = Path.of("data", "books.db");

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning?createDatabaseIfNotExist=true", "root", "");
    }

    public static void initSchema() throws SQLException {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS books (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(100) NOT NULL,
                        author VARCHAR(100) NOT NULL,
                        published_year INT
                    )
                    """);
        }
    }
}
