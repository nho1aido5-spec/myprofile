package aiwa.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import aiwa.customers.Customer;

public class CustomerModel {

    // 1. Lấy tất cả khách hàng
    public ArrayList<Customer> findAll() {
        ArrayList<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Customer c = new Customer();
                    c.setCustomecode(rs.getInt("customercode"));
                    c.setCustomeName(rs.getString("customername"));
                    c.setAddress(rs.getString("address"));
                    customers.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    // 2. Tìm chi tiết khách hàng theo Mã (Customecode)
    public Customer findById(int code) {
        Customer c = null;
        String sql = "SELECT * FROM customers WHERE customercode = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, code);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    c = new Customer();
                    c.setCustomecode(rs.getInt("customercode"));
                    c.setCustomeName(rs.getString("customername"));
                    c.setAddress(rs.getString("address"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    // 3. Tìm kiếm khách hàng theo từ khóa (Tên)
    public ArrayList<Customer> findByKeyWord(String word) {
        ArrayList<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE customername LIKE ?";

        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, "%" + word + "%");
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Customer c = new Customer();
                    c.setCustomecode(rs.getInt("customercode"));
                    c.setCustomeName(rs.getString("customername"));
                    c.setAddress(rs.getString("address"));
                    customers.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    // 4. Tìm kiếm khách hàng theo địa chỉ (address)
    public ArrayList<Customer> findByAddress(String address) {
        ArrayList<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE address LIKE ?";

        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, "%" + address + "%");
                ResultSet rs = stmt.executeQuery();

                    Customer c = new Customer();
                    c.setCustomecode(rs.getInt("customercode"));
                    c.setCustomeName(rs.getString("customername"));
                    c.setAddress(rs.getString("address"));
                    customers.add(c);
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}