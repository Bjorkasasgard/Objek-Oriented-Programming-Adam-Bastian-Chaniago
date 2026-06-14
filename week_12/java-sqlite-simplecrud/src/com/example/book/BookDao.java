package com.example.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao {

    public Book create(Book book) throws SQLException {
        String sql = """
                INSERT INTO books (title, author, published_year)
                VALUES (?, ?, ?)
                """;

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            if (book.getPublishedYear() != null) {
                stmt.setInt(3, book.getPublishedYear());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    book.setId(keys.getLong(1));
                }
            }
        }

        return book;
    }

    public Optional<Book> findById(long id) throws SQLException {
        String sql = "SELECT id, title, author, published_year FROM books WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        }

        return Optional.empty();
    }

    public List<Book> findAll() throws SQLException {
        String sql = "SELECT id, title, author, published_year FROM books ORDER BY id";
        List<Book> books = new ArrayList<>();

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                books.add(mapRow(rs));
            }
        }

        return books;
    }

    public boolean update(Book book) throws SQLException {
        String sql = """
                UPDATE books
                SET title = ?, author = ?, published_year = ?
                WHERE id = ?
                """;

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            if (book.getPublishedYear() != null) {
                stmt.setInt(3, book.getPublishedYear());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }
            stmt.setLong(4, book.getId());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean delete(long id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    private Book mapRow(ResultSet rs) throws SQLException {
        return new Book(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getObject("published_year") != null ? rs.getInt("published_year") : null
        );
    }
}
