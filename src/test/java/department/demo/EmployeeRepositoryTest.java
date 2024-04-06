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

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

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
        service.addEmployee("Иванова Иванна Ивановна", 345000, "2");
        verify(repositoryMock, times(1)).save(any());
    }

    private EmployeeRepository verify(EmployeeRepository repositoryMock, VerificationMode times) {
        return null;
    }

    @Test
    void addEmployeeMock2() {
        Employee employee = new Employee("Никадимова Наталья Николаевна", 500000, "2");
        when(repositoryMock.save(any(Employee.class))).thenReturn(employee);
        String actual = service.addEmployee("Никадимова Наталья Николаевна", 500000, "2");
        verify(repositoryMock, times(1)).save(any());
        assertEquals(String.valueOf(employee),
                actual);
    }
    @Test
    void findEmployeeMock() {
        Employee employee = new Employee("Никадимова Наталья Николаевна", 500000, "2");
        when(repositoryMock.save(any(Employee.class))).thenReturn(employee);
        String actual = service.findEmployee("Никадимова Наталья Николаевна");
        verify(repositoryMock, times(1)).save(any());
        assertEquals(String.valueOf(employee),
                actual);
    }
    @Test
    void removeEmployeeMock() {
        Employee employee = new Employee("Никадимова Наталья Николаевна", 500000, "2");
        when(repositoryMock.save(any(Employee.class))).thenReturn(employee);
        String actual = service.removeEmployee("Никадимова Наталья Николаевна");
        verify(repositoryMock, times(1)).save(any());
        assertEquals(String.valueOf(employee),
                actual);
    }
}
