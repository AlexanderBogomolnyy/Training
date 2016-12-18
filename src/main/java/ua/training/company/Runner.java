package ua.training.company;

import java.util.Date;
import java.util.List;

/**
 * <p> The Runner class with main executive method.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 16.12.2016.
 */
public class Runner {

    public static void main(String[] args) {
        Company company = new Company("Best company");

        Worker worker1 = new Employee(new PersonalData("John", "Dou", new Date()), Position.WORKER);
        Manager manager = new Employee(new PersonalData("Jane", "Brown", new Date()), Position.MANAGER);
        manager.setAmountOfWorkers(10);
        manager.acceptWorker(worker1);
        Other other = new Employee(new PersonalData("Alex", "Been", new Date()), Position.OTHER);
        other.setDescription("Secretary");
//        other.acceptWorker(worker1);

        company.addEmployee((Employee) worker1);
        company.addEmployee((Employee) manager);
        company.addEmployee((Employee) other);

        company.getEmployees().stream().forEach(System.out::println);

        Worker worker2 = new Employee(new PersonalData("Manny", "Mau", new Date()), Position.WORKER);
        Manager successor = new Employee(new PersonalData("Bill", "Gates", new Date()), Position.MANAGER);
        successor.setAmountOfWorkers(10);
        successor.acceptWorker(worker2);

        company.addEmployee((Employee) worker2);
        company.addEmployee((Employee) successor);

        System.out.println("--==--==--==--==--==--==--==--==--==--==--==--==--==--==-==--");
        company.getEmployees().stream().forEach(System.out::println);

        System.out.println("Position is changed: " + manager.changePosition(Position.OTHER, (Employee) successor));

        System.out.println("--==--==--==--==--==--==--==--==--==--==--==--==--==--==-==--");

        company.getEmployees().stream().forEach(System.out::println);

        System.out.println("--==--==--==--==--==--==--==--==--==--==--==--==--==--==-==--");

        List<Employee> employeeList = company.getSortedEmployees((x, y) -> x.getPersonalData().getName().compareToIgnoreCase(y.getPersonalData().getName()));

        employeeList.stream().forEach(System.out::println);
    }

}
