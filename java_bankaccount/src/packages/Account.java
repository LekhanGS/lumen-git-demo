package packages;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Connection connection;
    private int customerID;
    private String type;
    private int savingsAccountNumber;
    private double savingsBalance;

    private int currentAccountNumber;

    private double currentBalance;
    private Customer customer;

    public int getCustomerId() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSavingsAccountNumber() {
        return savingsAccountNumber;
    }

    public void setSavingsAccountNumber(int savingsAccountNumber) {
        this.savingsAccountNumber = savingsAccountNumber;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public int getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public void setCurrentAccountNumber(int currentAccountNumber) {
        this.currentAccountNumber = currentAccountNumber;
    }

    public double getGetCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double getCurrentBalance) {
        this.currentBalance = currentBalance;
    }

    public Account() throws SQLException, ClassNotFoundException {
        this.connection = DatabaseConnect.getConnection();
    }

    public void addSavingsAccount(Account account) {
        String query = "INSERT INTO accounts (customer_id, type, savings_account_number, savings_balance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, account.getCustomerId());
            statement.setString(2, account.getType());
            statement.setInt(3, account.getSavingsAccountNumber());
            statement.setDouble(4, account.getSavingsBalance());
            statement.executeUpdate();
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            System.out.printf("Error is" + errorMessage);
        }
    }


    public void addCurrentAccount(Account account) {
        String query = "INSERT INTO accounts (customer_id, type, current_account_number, current_balance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, account.getCustomerId());
            statement.setString(2, account.getType());
            statement.setInt(3, account.getCurrentAccountNumber());
            statement.setDouble(4, account.getCurrentBalance());
            statement.executeUpdate();
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            System.out.printf("Error is" + errorMessage);
        }
    }

    private double getCurrentBalance() {
        return currentBalance;
    }


    public List<Account> getAccountsByCustomerId(int customerId) {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM accounts WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Account account = new Account();
                    account.setCustomerId(resultSet.getInt("customer_id"));
                    account.setType(resultSet.getString("type"));
                    account.setSavingsAccountNumber(resultSet.getInt("savings_account_number"));
                    account.setCurrentAccountNumber(resultSet.getInt("current_account_number"));
                    account.setSavingsBalance(resultSet.getDouble("savings_balance"));
                    account.setCurrentBalance(resultSet.getDouble("current_balance"));
                    accounts.add(account);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            System.out.printf("Error is" + errorMessage);
        }
        return accounts;
    }

    void setCustomerId(int customerId) {
        this.customerID = customerId;
    }
}
