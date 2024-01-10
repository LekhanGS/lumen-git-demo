package com.bank;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() throws SQLException {
        accountDAO = new AccountDAO();
    }

    public void addAccountForCustomer(int customerId, Account account) {
        try {
            accountDAO.addAccount(customerId, account);
            //System.out.println("Account added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding account: " + e.getMessage());
        }
    }

    public List<Account> getAccountsByCustomerId(int customerId) {
        try {
            return accountDAO.getAccountsByCustomerId(customerId);
        } catch (SQLException e) {
            System.out.println("Error getting accounts: " + e.getMessage());
        }
        return null;
    }


}
