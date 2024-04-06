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

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentRepositoryTest {
    private DepartmentService depService;
    @Mock
    private EmployeeRepository repositoryMock;
    @Spy
    private EmployeeRepository repositorySpy;
    @BeforeEach
    public void setUp() throws Exception {
        depService = new DepartmentServiceImpl(repositoryMock);
    }
    @Test
    public void getEmployeesByDepartmentTest(){
        assertNotNull(repositoryMock);
        Employee employee = new Employee("Иванов Иван Иванович",  95_000, "1");
        Map<String, Employee> employees = new HashMap<>();
        employees.put("Иванов Иван Иванович", employee);
        Mockito.when(repositoryMock.findEmployeesByDepartment("Иванов Иван Иванович")).thenReturn(Collections.singletonList(employee));
        List<Employee> expected = new ArrayList<>();
        expected.add(employee);
        List<Employee> actual = depService.getEmployeesByDepartment("1");
        assertEquals(expected, actual);
    }
    @Test
    public void getEmployeesByDepartmentTestExceptions(){
        assertNotNull(repositoryMock);
        Employee employee = new Employee("Петров Петр Петрович",  197_000 , "1"
        );
        Map<String, Employee> employees = new HashMap<>();
        employees.put("Петров Петр Петрович", employee);
        when(repositoryMock.save(any(Employee.class))).thenReturn(employee);
        assertThrows (DepartmentIsBlankException.class, () -> depService.getEmployeesByDepartment(" "));
        assertThrows(NoDepartmentException.class, () -> depService.getEmployeesByDepartment("1"));
    }
    @Test
    public void sumSalaryByDepartmentTest(){
        assertNotNull(repositoryMock);
        Employee employee1 = new Employee("Иванов Иван Иванович", 95_000, "1"
        );
        Employee employee2 = new Employee("Петров Петр Петрович", 197_000, "1"
        );
        Employee employee3 = new Employee("Васильев Василий Васильев",165_000 , "2"
        );
        Map<String, Employee> employees = new HashMap<>();
        employees.put("Иванов Иван Иванович", employee1);
        employees.put("Петров Петр Петрович", employee2);
        when(repositoryMock.save(any(Employee.class))).thenReturn(employee1, employee2);
        int expected = 292_000;
        int actual = depService.sumSalaryByDepartment("1");
        assertEquals(expected, actual);
    }
    @Test
    public void sumSalaryByDepartmentTestExceptions(){
        assertNotNull(repositoryMock);
        Employee employee = new Employee("Петров Петр Петрович", 197_000, "1");
        Map<String, Employee> employees = new HashMap<>();
        employees.put("Петров Петр Петрович", employee);
        when(repositoryMock.save(any(Employee.class))).thenReturn(employee);
        assertThrows(DepartmentIsBlankException.class, () -> depService.sumSalaryByDepartment(""));
        assertThrows(NoDepartmentException.class, () -> depService.sumSalaryByDepartment("1"));
    }
    @Test
    public void maxSalaryByDepartmentTest(){
        assertNotNull(repositoryMock);
        Employee employee1 = new Employee("Иванов Иван Иванович", 95_000, "1"
        );
        Employee employee2 = new Employee("Петров Петр Петрович", 197_000, "1"
        );
        Employee employee3 = new Employee("Васильев Василий Васильев",165_000 , "2"
        );
        Map<String, Employee> employees = new HashMap<>();
        employees.put("Иванов Иван Иванович", employee1);
        employees.put("Петров Петр Петрович", employee2);
        when(repositoryMock.save(any(Employee.class))).thenReturn((Employee) employees );
        int expected = 197_000;
        int actual = depService.maxSalaryByDepartment("1");
        assertEquals(expected, actual);
    }
    @Test
    public void maxSalaryByDepartmentTestExceptions(){
        assertNotNull(repositoryMock);
        Map<String, Employee> employees = new HashMap<>();
        when(repositoryMock.save(any(Employee.class))).thenReturn((Employee)employees );
        assertThrows(DepartmentIsBlankException.class, () -> depService.maxSalaryByDepartment(" "));
        assertThrows(NoDepartmentException.class, () -> depService.maxSalaryByDepartment("1"));
        assertThrows(RuntimeException.class, () -> depService.maxSalaryByDepartment("2"));
    }
    @Test
    public void minSalaryByDepartmentTest(){
        assertNotNull(repositoryMock);
        Employee employee1 = new Employee("Иванов Иван Иванович", 95_000, "1"
        );
        Employee employee2 = new Employee("Петров Петр Петрович", 197_000, "1"
        );
        Employee employee3 = new Employee("Васильев Василий Васильев",165_000 , "2"
        );
        Map<String, Employee> employees = new HashMap<>();
        employees.put("Иванов Иван Иванович", employee1);
        employees.put("Петров Петр Петрович", employee2);
        when(repositoryMock.save(any(Employee.class))).thenReturn((Employee) employees );
        int expected = 95_000;
        int actual = depService.minSalaryByDepartment("1");
        assertEquals(expected, actual);
    }
    @Test
    public void minSalaryByDepartmentTestExceptions(){
        assertNotNull(repositoryMock);
        Map<String, Employee> employees = new HashMap<>();
        when(repositoryMock.save(any(Employee.class))).thenReturn((Employee) employees );
        assertThrows(DepartmentIsBlankException.class, () -> depService.minSalaryByDepartment(" "));
        assertThrows(NoDepartmentException.class, () -> depService.minSalaryByDepartment("1"));
        assertThrows(RuntimeException.class, () -> depService.minSalaryByDepartment("2"));
    }
    @Test
    public void getEmployeesByDepartmentsTest(){
        Employee employee1 = new Employee("Иванов Иван Иванович", 95_000, "1"
        );
        Employee employee2 = new Employee("Петров Петр Петрович", 197_000, "1"
        );
        Employee employee3 = new Employee("Васильев Василий Васильев",165_000 , "2"
        );
        Map<String, Employee> employees = new HashMap<>();
        employees.put("Иванов Иван Иванович", employee1);
        employees.put("Петров Петр Петрович", employee2);
        when(repositoryMock.save(any(Employee.class))).thenReturn((Employee) employees );
        Map<String, List<Employee>> expected = new HashMap<>();
        expected.put("sales", Arrays.asList(employee1, employee2));
        expected.put("it", Arrays.asList(employee3));
        Map<String, List<Employee>> actual = depService.getEmployeesByDepartments();
        assertEquals(expected, actual);
    }
}
