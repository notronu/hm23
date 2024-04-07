package service;

import employee.Employee;
import exceptions.WrongSymbolsException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import repository.EmployeeRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class EmployeeServiceImpl implements EmployeeService {


    Map<String, Employee> employees = new HashMap<>(Map.of(

            "Иванов",

            new Employee("Иванов", 95_000, "1"),

            "Петров Петр Петрович",

            new Employee("Петров Петр Петрович", 197_000, "1")
    ));
    public Map<String, Employee> getEmployees() {

        return employees;
    }
    private final EmployeeRepository employeesRepository;

    public EmployeeServiceImpl(EmployeeRepository employeesRepository) {

        this.employeesRepository = employeesRepository;
    }
    @Override
    public String addEmployee(String fullName, Integer salary, String department) {

        Employee employee = new Employee(fullName,  salary, department);

        return String.valueOf(employeesRepository.save(employee));
    }
    @Override
    public String removeEmployee(String fullName) {


        return employeesRepository.removeByFullName(fullName).toString();
    }
    @Override
    public String findEmployee(String fullName) {


        return employeesRepository.findByFullName(fullName).toString();
    }


}
