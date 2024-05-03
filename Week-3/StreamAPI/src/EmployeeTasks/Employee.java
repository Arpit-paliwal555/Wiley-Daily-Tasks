package EmployeeTasks;

import java.time.LocalDate;

public class Employee {
    int id;
    String name;
    int salary;
    LocalDate date;

    public Employee(int id, String name, int salary,LocalDate date) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", date=" + date +
                '}';
    }
}
