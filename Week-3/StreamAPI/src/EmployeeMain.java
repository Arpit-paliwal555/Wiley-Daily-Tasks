import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101,"Harsh",40000, LocalDate.parse("2021-01-23"));
        Employee emp2 = new Employee(103,"Rajesh",45000, LocalDate.parse("2020-03-13"));
        Employee emp3 = new Employee(102,"Karan",50000, LocalDate.parse("2022-04-15"));
        Employee emp4 = new Employee(104,"Rituraj",55000, LocalDate.parse("2022-06-20"));
        Employee emp5 = new Employee(107,"John",55000, LocalDate.parse("2021-08-12"));

        List<Employee> list = new ArrayList<>(List.of(emp1,emp2,emp3,emp4,emp5));
        int giveniId = 101;

        Employee empWithGivenID = list.stream().filter(e->e.id==giveniId).findFirst().orElse(null);
        list.stream().forEach(employee -> {
            employee.salary += (employee.salary/100)*20;
        });
        System.out.println("Employee with id 101: "+empWithGivenID);
        System.out.println(list);

    }
}
