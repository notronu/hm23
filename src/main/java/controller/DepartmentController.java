package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/department") /* чтобы не писать для каждого метода в пути одно и то же */
public class DepartmentController {
    private final DepartmentService departmentService; /*  связь с  одним из сервисов */
    public DepartmentController(DepartmentService departmentService ) { /* генерим конструктор контроллера*/
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/{department}/employees") /*по этому адресу в сервисе будет найден метод  получить сотрудников департамента */
    public List<Employee> getEmployeesByDepartment(@PathVariable String department){
        return departmentService.getEmployeesByDepartment(department);
    }
    @GetMapping(path = "/{department}/salary/sum") /*по этому адресу в сервисе будет найден метод  вывести сумму зарплат */
    public int sumSalaryByDepartment(@PathVariable String department){
        return departmentService.sumSalaryByDepartment(department);
    }
    @GetMapping(path = "/{department}/salary/max") /*по этому адресу в сервисе будет найден метод  вывести максимальную зарплату */
    public int maxSalaryByDepartment(@PathVariable String department){
        return departmentService.maxSalaryByDepartment(department);
    }
    @GetMapping(path = "/{department}/salary/min") /*по этому адресу в сервисе будет найден метод  вывести минимальную зарплату */
    public int minSalaryByDepartment(@PathVariable String department){
        return departmentService.minSalaryByDepartment(department);
    }
    @GetMapping(path = "/employees") /*по этому адресу в сервисе будет найден метод  группировать сотрудников по отделам */
    public Map<String, List<Employee>> getEmployeesByDepartments(){
        return departmentService.getEmployeesByDepartments();
    }
}
