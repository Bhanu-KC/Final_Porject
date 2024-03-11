package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE Employee (" +
                    "   employeeId INT PRIMARY KEY," +
                    "   name VARCHAR(255)," +
                    "   address VARCHAR(255)," +
                    "   contactNumber VARCHAR(20)," +
                    "   position VARCHAR(50)," +
                    "   isActive BOOLEAN" +
                    ")";

    private static final String INSERT_EMPLOYEE_SQL =
            "INSERT INTO Employee (employeeId, name, address, contactNumber, position, isActive) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_EMPLOYEES_SQL =
            "SELECT * FROM Employee";

    private static final String UPDATE_EMPLOYEE_SQL =
            "UPDATE Employee SET name=?, address=?, contactNumber=?, position=?, isActive=? WHERE employeeId=?";


    public static void initializeDatabase() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_TABLE_SQL)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addEmployee(Employee employee) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            statement.setInt(1, employee.getEmployeeId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getContactNumber());
            statement.setString(5, employee.getPosition());
            statement.setBoolean(6, employee.isActive());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEES_SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                employees.add(mapResultSetToEmployee(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void updateEmployee(Employee updatedEmployee) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            statement.setString(1, updatedEmployee.getName());
            statement.setString(2, updatedEmployee.getAddress());
            statement.setString(3, updatedEmployee.getContactNumber());
            statement.setString(4, updatedEmployee.getPosition());
            statement.setBoolean(5, updatedEmployee.isActive());
            statement.setInt(6, updatedEmployee.getEmployeeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static Employee mapResultSetToEmployee(ResultSet resultSet) throws SQLException {
        return new Employee(
                resultSet.getInt("employeeId"),
                resultSet.getString("name"),
                resultSet.getString("address"),
                resultSet.getString("contactNumber"),
                resultSet.getString("position"),
                resultSet.getBoolean("isActive")
        );
    }
}
