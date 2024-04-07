package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeServiceImpl;

@RestController
@RequestMapping(path = "/department")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam ("fullName") String fullName,

                              @RequestParam ("salary") Integer salary,

                              @RequestParam ("department") String department){

        return employeeService.addEmployee(fullName,  salary, department);
    }
    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam ("fullName") String fullName){

        return employeeService.removeEmployee(fullName);
    }
    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam ("fullName") String fullName){

        return employeeService.findEmployee(fullName);
    }
}