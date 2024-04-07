package constants_final;
import employee.Employee;


import java.util.HashMap;
import java.util.Map;

public class ConstantsClass {

    public final static Map<String, Employee> employee_mock = new  HashMap<>(Map.of(

            "Иванов Иван Иванович",

            new Employee("Иванов Иван Иванович", 95_000, "1"),
            "Петров Петр Петрович" ,

            new Employee("Петров Петр Петрович", 197_000, "1" )
    ));
}
