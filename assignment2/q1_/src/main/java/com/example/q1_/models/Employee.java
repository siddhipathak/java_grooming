package com.example.q1_.models;

import com.example.q1_.enums.EmployementType;
import com.example.q1_.enums.Status;

public class Employee{
    private int employeeId;
    private String employeeName;
    private String joiningDate;
    private EmployementType employementType;
    private Status status;
    private String role;

    public Employee(int employeeId, String employeeName, String joiningDate, EmployementType employementType, Status status,
            String role) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.joiningDate = joiningDate;
        this.employementType = employementType;
        this.status = status;
        this.role = role;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public EmployementType getEmployementType() {
        return employementType;
    }

    public Status getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setEmployementType(EmployementType employementType) {
        this.employementType = employementType;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRole(String role) {
        this.role = role;
    }
      
    @Override
    public String toString() {
        return "Details are as follows: employeeId=" + employeeId + ", employeeName=" + employeeName + ", joiningDate=" + joiningDate
                + ", employmentType=" + employementType + ", status=" + status + ", role=" + role + "]";
    }
}
