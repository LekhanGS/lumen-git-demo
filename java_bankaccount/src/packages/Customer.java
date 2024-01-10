package packages;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private static List<Customer> customers = new ArrayList<>();
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String contactNumber;

    public Customer(int customerId, String firstName, String lastName, String email, String city, String contactNumber) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.contactNumber = contactNumber;
        customers.add(this);
    }

    public Customer() {

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void addCustomer(Customer customer) {
        customer.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
