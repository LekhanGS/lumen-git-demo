package com.bank;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() throws SQLException {
        customerDAO = new CustomerDAO();
    }

    public void addNewCustomer(Customer customer) {
        try {
            customerDAO.addCustomer(customer);
        } catch (SQLException e) {
            System.out.println("Error adding customer: " + e.getMessage());
        }
    }

    public void deleteCustomerById(int customerId) {
        try {
            customerDAO.deleteCustomerById(customerId);
            System.out.println("Customer deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting customer: as account already exists " + e.getMessage());
        }
    }

    public Customer getCustomerById(int customerId) {
        try {
            return customerDAO.getCustomerById(customerId);
        } catch (SQLException e) {
            System.out.println("Error getting customer: " + e.getMessage());
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        try {
            return customerDAO.getAllCustomers();
        } catch (SQLException e) {
            System.out.println("Error getting all customers: " + e.getMessage());
        }
        return null;
    }
}

