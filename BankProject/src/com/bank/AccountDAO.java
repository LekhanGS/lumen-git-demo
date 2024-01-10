package com.bank;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private Connection connection;

    public AccountDAO() throws SQLException {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAccount(int customerId, Account account) throws SQLException {
        String query = "INSERT INTO accounts (customer_id, account_type, balance) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, account.getAccountType());
            preparedStatement.setBigDecimal(3, account.getBalance());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                account.setAccountNumber(generatedKeys.getInt(1));
            }
        }
    }

    public List<Account> getAccountsByCustomerId(int customerId) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM accounts WHERE customer_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = extractAccountFromResultSet(resultSet);
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving accounts: " + e.getMessage());
            throw e;
        }
        return accounts;
    }


    private Account extractAccountFromResultSet(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setAccountNumber(resultSet.getInt("account_number"));
        account.setAccountType(resultSet.getString("account_type"));
        account.setBalance(resultSet.getBigDecimal("balance"));
        return account;
    }
}
