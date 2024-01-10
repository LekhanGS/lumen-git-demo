package packages;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CustomerDAL {
    private Connection connection;

    public CustomerDAL() throws SQLException, ClassNotFoundException {
        this.connection = DatabaseConnect.getConnection();
    }

    public void addCustomer(Customer customer) {
        String query = "INSERT INTO customers (first_name, last_name, email, city, contact_number) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getCity());
            statement.setString(5, customer.getContactNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            System.out.printf("Error is" + errorMessage);
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setCity(resultSet.getString("city"));
                customer.setContactNumber(resultSet.getString("contact_number"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            System.out.printf("Error is" + errorMessage);
        }
        return customers;
    }
}
