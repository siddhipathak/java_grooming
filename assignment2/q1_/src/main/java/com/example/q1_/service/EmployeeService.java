package com.example.q1_.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.example.q1_.enums.EmployementType;
import com.example.q1_.enums.Status;
import com.example.q1_.exception.NotFoundException;
import com.example.q1_.models.Employee;

public class EmployeeService {
    private HashMap<Integer, Employee> employees = new HashMap<>();

    private static final String EMPLOYEE_NOT_FOUND = "Employee Not Found : ";
    private static final String EMPLOYEMENTTYPE_NOT_FOUND = "Employement Type Not Found : ";
    private static final String STATUS_NOT_FOUND = "Status Not Found : ";

    public void addEmployee(int employeeId, Employee emp) {
        employees.put(employeeId, emp);
    }

    public Employee deleteEmployee(int employeeId) {
        var currEmployee = employees.get(employeeId);
        if (currEmployee != null)
            currEmployee.setStatus(Status.EXIT);
        else
            throw new NotFoundException(EMPLOYEE_NOT_FOUND + employeeId);
        return currEmployee;
    }

    public String updateRole(int employeeId, String role) {
        var currEmployee = employees.get(employeeId);
        if (currEmployee != null)
            currEmployee.setRole(role);
        else
            throw new NotFoundException(EMPLOYEE_NOT_FOUND + employeeId);
        return currEmployee.toString();
    }

    public Employee updateEmployementType(int employeeId, String employementType) {
        var currEmployee = employees.get(employeeId);
        if (currEmployee != null) {
            for (EmployementType et : EmployementType.values()) {
                if (et.name().equalsIgnoreCase(employementType)) {
                    EmployementType type = EmployementType.valueOf(employementType.toUpperCase());
                    currEmployee.setEmployementType(type);
                    break;
                } else
                    throw new NotFoundException(EMPLOYEMENTTYPE_NOT_FOUND);
            }
        } else
            throw new NotFoundException(EMPLOYEE_NOT_FOUND + employeeId);
        return currEmployee;
    }

    public Employee updateStatus(int employeeId, String status) {
        var currEmployee = employees.get(employeeId);
        if (currEmployee != null) {
            for (Status st : Status.values()) {
                if (st.name().equalsIgnoreCase(status)) {
                    Status empStatus = Status.valueOf(status.toUpperCase());
                    currEmployee.setStatus(empStatus);
                    break;
                } else
                    throw new NotFoundException(STATUS_NOT_FOUND + status);
            }
        } else
            throw new NotFoundException(EMPLOYEE_NOT_FOUND + employeeId);
        return currEmployee;
    }

    public List<Employee> getEmployeesStatus(String status) {
        List<Employee> employeeList = new ArrayList<>();
        Status empStatus = Enum.valueOf(Status.class, status.toUpperCase());
        boolean flag = false;

        for (Status st : Status.values()) {
            if (st.name().equalsIgnoreCase(status)) {
                flag = true;
                break;
            }

        }
        if (flag == false)
            throw new NotFoundException(STATUS_NOT_FOUND + status);

        for (Employee e : employees.values()) {
            if (e.getStatus().equals(empStatus))
                employeeList.add(e);
        }
        if (employeeList.size() == 0)
            throw new NotFoundException(STATUS_NOT_FOUND);
        return employeeList;

    }

    public void getSeniorEmployee() {

        List<Employee> employeList = new ArrayList<>();
        for (Employee e : employees.values()) {
            employeList.add(e);
        }
        employeList.sort(Comparator.comparing(Employee::getJoiningDate));
        System.out.println(employeList.get(0));
    }

    public void getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee e : employees.values()) {
            employeeList.add(e);
        }
        if (employeeList.size() == 0)
            throw new NotFoundException(EMPLOYEE_NOT_FOUND);
        for (Employee e : employeeList)
            System.out.println(e.toString());
    }
}
