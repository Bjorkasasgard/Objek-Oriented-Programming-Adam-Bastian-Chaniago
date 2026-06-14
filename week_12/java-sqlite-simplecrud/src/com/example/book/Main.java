package com.example.book;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Database.initSchema();
        BookDao bookDao = new BookDao();

        Book created = bookDao.create(new Book("Bumi Manusia", "Pramoedya Ananta Toer", 1980));
        System.out.println("Created: " + created);

        Book updated = new Book(created.getId(), "Bumi Manusia", "Pramoedya Ananta Toer", 1980);
        updated.setTitle("Bumi Manusia (Edisi Revisi)");
        bookDao.update(updated);
        System.out.println("Updated: " + bookDao.findById(created.getId()).orElseThrow());

        bookDao.create(new Book("Laskar Pelangi", "Andrea Hirata", 2005));
        bookDao.create(new Book("Laut Bercerita", "Leila S. Chudori", 2017));

        System.out.println("\nAll books:");
        for (Book book : bookDao.findAll()) {
            System.out.println("  " + book);
        }

        boolean deleted = bookDao.delete(created.getId());
        System.out.println("\nDeleted book id=" + created.getId() + ": " + deleted);

        System.out.println("\nRemaining books:");
        for (Book book : bookDao.findAll()) {
            System.out.println("  " + book);
        }
    }
}
