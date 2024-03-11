package org.example;

import java.util.List;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeDAO.initializeDatabase();


        Employee emp1 = new Employee(1, "Bhanu KC", "Maijubahal", "986372891", "Developer", true);
        Employee emp2 = new Employee(2, "Ram Gurung", "Dumbahrahi", "9876543210", "Manager", true);


        EmployeeDAO.addEmployee(emp1);
        EmployeeDAO.addEmployee(emp2);
        EmployeeDAO.updateEmployee(new Employee(2, "Ram Gurung", "Dumbarhari", "9876543210", "Manager", false));


        List<Employee> allEmployees = EmployeeDAO.getAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println(" Name - "+ employee.getName() + " - Position - " + employee.getPosition() + " - Active: " + employee.isActive());
        }
    }
}
