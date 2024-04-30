import java.time.LocalDate;
import java.util.*;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101,"Harsh",40000, LocalDate.parse("2021-01-23"));
        Employee emp2 = new Employee(103,"Rajesh",45000, LocalDate.parse("2020-03-13"));
        Employee emp3 = new Employee(102,"Karan",50000, LocalDate.parse("2022-04-15"));
        Employee emp4 = new Employee(104,"Rituraj",55000, LocalDate.parse("2022-06-20"));
        Employee emp5 = new Employee(107,"John",55000, LocalDate.parse("2021-08-12"));

        //List<Employee> list = new ArrayList<>(List.of(emp1,emp2,emp3,emp4,emp5));
        Map<Integer,Employee> map = new HashMap<>();
        int giveniId = 101;
        String name = "Karan";
        map.put(101,emp1);
        map.put(103,emp2);
        map.put(102,emp3);
        map.put(104,emp4);
        map.put(107,emp5);

        Employee empWithGivenName = map.values().stream().filter(e-> e.name.equalsIgnoreCase(name)).findFirst().orElse(null);
//        list.forEach(employee -> {
//            if(employee.equals(empWithGivenName))
//                employee.salary += (employee.salary/100)*20;
//        });
        //empWithGivenID.salary += (empWithGivenID.salary/100)*20;
        System.out.println("Employee with id 101: "+empWithGivenName);
        //System.out.println(list);

    }
}
