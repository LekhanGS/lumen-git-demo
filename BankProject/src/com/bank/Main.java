package com.bank;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        BankManagementSystem banking = new BankManagementSystem();
        banking.displayMenu();
    }
}
