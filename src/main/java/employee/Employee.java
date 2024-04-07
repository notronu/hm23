package employee;

import java.util.Objects;

public class Employee {

    private int id;

    private final String fullName;

    private  final  Integer salary;

    private final String  department;

    public Employee(String fullName, Integer salary, String  department) {

        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
    }
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getFullName() {

        return fullName;
    }
    public Integer getSalary() {

        return salary;
    }
    public String   getDepartment() {

        return department;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return getId() == employee.getId() && Objects.equals(getFullName(), employee.getFullName()) && Objects.equals(getSalary(), employee.getSalary()) && Objects.equals(getDepartment(), employee.getDepartment());
    }
    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFullName(), getSalary(), getDepartment());
    }
    @Override
    public String toString() {

        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
