package main.java.ch.laeub;

public class Main {

    private record Employee(String name, int age, String department) {}

    public static void main(String[] args) {
        Employee employee = new Employee("Jack", 3, "IT"); // This works
        System.out.println(employee.department);    // This works
    }

}
