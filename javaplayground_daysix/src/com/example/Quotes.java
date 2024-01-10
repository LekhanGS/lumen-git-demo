package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quotes {
    private int id;
    private String quote;
    private String author;

    public Quotes() {
    }

    public Quotes(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }




    public void drive() {

        while (true) {
            System.out.println("1. Add a quotes");
            System.out.println("2. Exit");

            Scanner scanner = new Scanner(System.in);
            try {

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        this.addQuotes();
                        break;

                    case 2:
                        this.showQuotes();
                        break;

                    case 3:
                        System.out.println("Exiting the application. Bye.");
                        return;

                    default:
                        System.out.println("Invalid option selected. Try again");
                        break;
                }
            } catch (RuntimeException | ClassNotFoundException | SQLException ex) {
                System.out.println("Invalid input. Only numbers: 1 to 5");
            }
        }
    }
    public void showQuotes() throws ClassNotFoundException, SQLException{
        List<Quotes> quotes = new ArrayList<>();

        String query = "SELECT * FROM quotes";

        Statement stmt = getConnection().createStatement();
        ResultSet results = stmt.executeQuery(query);

        while (results.next()) {
            Quotes quotes1 = new Quotes();
    }
    public void addQuotes();
    {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Adding Quotes:");
            System.out.println("*****************************");
            System.out.println("Enter Qoutes: ");
            String quote = scanner.nextLine();
            System.out.println("Enter Author: ");
            String author = scanner.nextLine();

            addQoutes(quote, author);
        } catch (RuntimeException re) {
            System.out.println("Invalid input. Only numbers.");
        }
    }

    public void addQoutes(String quote, String author) {
        Quotes quotes = new Quotes(quote, author);
        try {
            createQuotes(quotes);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void createQuotes(Quotes quotes) throws SQLException, ClassNotFoundException {
        String quote = "INSERT INTO quotes(quote, author) VALUES (?, ?)";

        PreparedStatement pstmt = getConnection().prepareStatement(quote);

        // replace these ?
        pstmt.setString(1, quotes.getQuote());
        pstmt.setString(2, quotes.getAuthor());

        pstmt.execute();
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = null;

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "Admin@123");
        if (conn != null) {
            return conn;
        } else {
            throw new RuntimeException("Connection error");
        }
    }




}