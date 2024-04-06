package service;

import employee.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    String addEmployee(String fullName, Integer salary, String department);
    String removeEmployee(String fullName);
    String findEmployee(String fullName);
    Map<String, List<Employee>> getEmployees();
}