package service;

import employee.Employee;
import exceptions.DepartmentIsBlankException;
import exceptions.NoDepartmentException;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeRepository repository;
    public DepartmentServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }
    private void throwExceptions(String department){
        if (department.isBlank()){
            throw new DepartmentIsBlankException("Department is blank");
        }
    }
    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        throwExceptions(department);
        List<Employee> employeesByDepartment = repository.findEmployeesByDepartment(department);
        if (employeesByDepartment.isEmpty())
            throw new NoDepartmentException("No department");
        return employeesByDepartment;
    }
    @Override
    public int sumSalaryByDepartment(String department) {
        throwExceptions(department);
        return repository.sumSalaryByDepartment(department);
    }
    @Override
    public int maxSalaryByDepartment(String department) {
        throwExceptions(department);
        return repository.maxSalaryByDepartment(department);
    }
    @Override
    public int minSalaryByDepartment(String department) {
        throwExceptions(department);
        return repository.minSalaryByDepartment(department);
    }
    @Override
    public Map<String, List<Employee>> getEmployeesByDepartments() {
        return repository.findEmployeesGroupByDepartments();
    }
}
