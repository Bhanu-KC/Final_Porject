package org.example;

public class Employee {
    private int employeeId;
    private String name;
    private String address;
    private String contactNumber;
    private String position;
    private boolean isActive;

    public Employee(int employeeId, String name, String address, String contactNumber, String position, boolean isActive) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.position = position;
        this.isActive = isActive;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
