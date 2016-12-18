package ua.training.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> The Company class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 16.12.2016.
 */
public class Company {

    /**
     * Company name
     */
    private String name;

    /**
     * List of employee for company
     */
    private List<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method adds employee to the list of employee
     *
     * @param employee - some employee
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * This method removes employee from the list of employee
     *
     * @param employee - some employee
     */
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    /**
     * This method returns list of employee for the company
     *
     * @return - list of employee
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * This method returns the list of employee sorted according to the comparator
     *
     * @param comparator - Employee comparator
     * @return - list of employee sorted according to the comparator
     */
    public List<Employee> getSortedEmployees(Comparator<Employee> comparator) {
        return employees.stream().sorted(comparator).collect(Collectors.toList());
    }
}
