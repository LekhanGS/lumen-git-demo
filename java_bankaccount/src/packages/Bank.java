package packages;

import java.sql.SQLException;
import java.util.List;

public class Bank {
    private Customer customer;
    private Account account;

    public void BankService() throws SQLException, ClassNotFoundException {
        this.customer = new Customer();
        this.account = new Account();
    }

    public void addNewCustomer(Customer customer) {
        customer.addCustomer(customer);
    }

    public void addSavingsAccount(Account account) {
        account.setType("savings");
        account.addSavingsAccount(account);
    }

    public void addCurrentAccount(Account account) {
        account.setType("current");
        account.addCurrentAccount(account);
    }

    public List<Customer> getAllCustomers() {
        return customer.getAllCustomers();
    }

    public List<Account> getAccountsByCustomerId(int customerId) {
        return account.getAccountsByCustomerId(customerId);
    }
}
