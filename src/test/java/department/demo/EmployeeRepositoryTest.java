package department.demo;

import employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import repository.EmployeeRepository;
import service.EmployeeService;
import service.EmployeeServiceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeRepositoryTest {

    private EmployeeService service;

    @Mock
    private EmployeeRepository repositoryMock;

    @Spy
    private EmployeeRepository repositorySpy;

    @BeforeEach
    public void setUp() throws Exception {
        service = new EmployeeServiceImpl(repositoryMock);
    }

    @Test
    void addEmployeeMock() {
        service.addEmployee("Ivanov", 345000, "2");
        verify(repositoryMock, times(1)).save(any());
    }


    @Test
    void addEmployeeMock2() {

        Employee employee = new Employee("Иванов Иван Иванович", 95_000, "1");

        when(repositoryMock.save(any(Employee.class))).thenReturn(employee);

        String actual = service.addEmployee("Иванов Иван Иванович", 95_000, "1");

        verify(repositoryMock, times(1)).save(any());

        assertEquals(String.valueOf(employee),
                actual);
    }
    @Test
    void addEmployeeMock3() {

        Employee employee = new Employee("Фролов Иван Иванович",   100_000, "1");

        when(repositoryMock.save(any(Employee.class))).thenReturn(employee);

        String s = service.addEmployee("Фролов Иван Иванович",    100_000,"1");

        verify(repositoryMock, times(1)).save(any());

        assertEquals(
                String.valueOf(employee)
                , s
        );
    }
    @Test
    void findEmployeeSpy() {

        Employee employee = new Employee("Иванов Иван Иванович", 95_000, "1" );

        doReturn(employee).when(repositorySpy).findByFullName(anyString());

        service = new EmployeeServiceImpl(repositorySpy);

        assertEquals(employee.toString(),
                service.findEmployee("Иванов Иван Иванович").toString());
    }

    @Test
    void removeEmployeeSpy() {

        Employee employee = new Employee("Иванов Иван Иванович", 95_000, "1" );

        doReturn(employee).when(repositorySpy).findByFullName(anyString());

        service = new EmployeeServiceImpl(repositorySpy);


        assertEquals(employee.toString(),
                service.findEmployee("Иванов Иван Иванович").toString());
    }

}
