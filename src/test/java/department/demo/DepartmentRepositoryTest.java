package department.demo;

import employee.Employee;
import exceptions.DepartmentIsBlankException;
import exceptions.NoDepartmentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.EmployeeRepository;
import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.EmployeeService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static repository.EmployeeRepository.employee_mock;


@ExtendWith(MockitoExtension.class)
public class DepartmentRepositoryTest {

    private EmployeeService service;

    private DepartmentService depService;

    @Mock
    private EmployeeRepository repositoryMock;

    @Spy
    private EmployeeRepository repositorySpy;

    private Employee expectedEmployee;

    @BeforeEach
    public void setUp() throws Exception {
        depService = new DepartmentServiceImpl(repositoryMock) {

            @Override
            public Map<String, Employee> getEmployees3(Map<String, Employee> employees2) {

                return employees2;

            }
        };
    }


    @Test
    public void getEmployeesByDepartmentTest() {

        assertNotNull(repositoryMock);

        Employee employee = new Employee("Иванов Иван Иванович", 95_000, "1");

        Map<String, Employee> employees = new HashMap<>();

        employees.put("Иванов Иван Иванович", employee);

        Mockito.when(repositoryMock.findEmployeesByDepartment("1")).thenReturn(Collections.singletonList(employee));

        List<Employee> expected = new ArrayList<>();

        expected.add(employee);

        List<Employee> actual = depService.getEmployeesByDepartment("1");

        assertEquals(expected, actual);
    }

    @Test
    public void getEmployeesByDepartmentTestExceptions() {

        assertNotNull(repositoryMock);

        Employee employee = new Employee("Петров Петр Петрович", 197_000, "1"

        );
        Map<String, Employee> employees = new HashMap<>();

        employees.put("Петров Петр Петрович", employee);

        when(repositoryMock.save(any(Employee.class))).thenReturn(employee);

        assertThrows(DepartmentIsBlankException.class, () -> depService.getEmployeesByDepartment(""));

        assertThrows(NoDepartmentException.class, () -> depService.getEmployeesByDepartment("1"));
    }

    @Test
    public void sumSalaryByDepartmentTest3() {

        assertNotNull(repositoryMock);

        Employee employee1 = new Employee("Иванов Иван Иванович", 95_000, "1"
        );

        Employee employee2 = new Employee("Петров Петр Петрович", 197_000, "1"
        );

        Employee employee3 = new Employee("Семенов Семен Семенович", 167_000, "3"
        );

        Map<String, Employee> employees = new HashMap<>();

        employees.put("Иванов Иван Иванович", employee1);

        employees.put("Петров Петр Петрович", employee2);

        when(repositoryMock.sumSalaryByDepartment(anyString())).thenReturn(292000);

        int expected = 292_000;

        int actual = depService.sumSalaryByDepartment("1");

        assertEquals(expected, actual);
    }

    @Test
    public void sumSalaryByDepartmentTestExceptions() {
        assertNotNull(repositoryMock);

        Employee employee = new Employee("Петров Петр Петрович", 197_000, "1");

        Map<String, Employee> employees = new HashMap<>();

        employees.put("Петров Петр Петрович", employee);

        assertThrows(DepartmentIsBlankException.class, () -> depService.sumSalaryByDepartment(""));


    }

    @Test
    public void maxSalaryByDepartmentTest() {
        assertNotNull(repositoryMock);
        Employee employee1 = new Employee("Иванов Иван Иванович", 95_000, "1"
        );

        Employee employee2 = new Employee("Петров Петр Петрович", 197_000, "1"
        );

        Employee employee3 = new Employee("Васильев Василий Васильев", 165_000, "2"
        );


        Map<String, Employee> employees = new HashMap<>();

        employees.put("Иванов Иван Иванович", employee1);

        employees.put("Петров Петр Петрович", employee2);

        when(repositoryMock.maxSalaryByDepartment(anyString())).thenReturn(197_000);

        int expected = 197_000;

        int actual = depService.maxSalaryByDepartment("1");

        assertEquals(expected, actual);
    }

    @Test
    public void maxSalaryByDepartmentTestExceptions() {

        assertNotNull(repositoryMock);

        Map<String, Employee> employees = new HashMap<>();

        assertThrows(DepartmentIsBlankException.class, () -> depService.maxSalaryByDepartment(""));
    }


    @Test
    public void minSalaryByDepartmentTest() {

        assertNotNull(repositoryMock);

        Employee employee1 = new Employee("Иванов Иван Иванович", 95_000, "1"
        );

        Employee employee2 = new Employee("Петров Петр Петрович", 197_000, "1"
        );

        Employee employee3 = new Employee("Васильев Василий Васильев", 165_000, "2"
        );

        Map<String, Employee> employees = new HashMap<>();

        employees.put("Иванов Иван Иванович", employee1);

        employees.put("Петров Петр Петрович", employee2);

        when(repositoryMock.minSalaryByDepartment(anyString())).thenReturn(95_000);

        int expected = 95_000;

        int actual = depService.minSalaryByDepartment("1");

        assertEquals(expected, actual);
    }

    @Test
    public void minSalaryByDepartmentTestExceptions() {
        assertNotNull(repositoryMock);

        Map<String, Employee> employees = new HashMap<>();

        assertThrows(DepartmentIsBlankException.class, () -> depService.minSalaryByDepartment(""));

    }

    @Test
    public void getEmployeesByDepartmentsTest1() {

        Employee employee1 = new Employee("Иванов Иван Иванович", 95_000, "1"
        );

        Employee employee2 = new Employee("Васильев Василий Васильев", 165_000, "2"
        );

        Employee employee3 = new Employee("Семенов Семен Семенович", 167_000, "3"
        );

        Map<String, Employee> employees = new HashMap<>();

        employees.put("Иванов Иван Иванович", employee1);

        employees.put("Васильев Василий Васильев", employee2);

        employees.put("Семенов Семен Семенович", employee3);

        Map<String, List<Employee>> expected = new HashMap<>();

        expected.put("1", Arrays.asList(employee1, employee2));

        expected.put("2", Arrays.asList(employee3));

    }

    @Test
    public void getAllEmployeesTest() {

        Employee employee1 = new Employee("Иванов Иван Иванович", 95_000, "1"
        );

        Employee employee2 = new Employee("Петров Петр Петрович", 197_000, "1"
        );


        Map<String, Employee> expected = new HashMap<>();

        expected.put("Иванов Иван Иванович", employee1);

        expected.put("Петров Петр Петрович", employee2);

        Map<String, Employee> actual = depService.getEmployees(employee_mock);

        assertEquals(expected, actual);

    }
}

