package ua.training.company;

import java.util.List;

/**
 * <p> The Employee behaviour interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 16.12.2016.
 */
public interface EmployeeScope {

    /**
     * A constant holding a message about unsupported operation.
     */
    final String UNSUPPORTED_OPERATION = "This method is not supported by %s.";

    /**
     * A constant holding a message about illegal successor type.
     */
    final String ILLEGAL_SUCCESSOR = "Illegal successor type.";

    /**
     * A constant holding a message about illegal employee state.
     */
    final String ILLEGAL_EMPLOYEE_STATE = "Illegal employee state.";

    /**
     * This method returns employee position
     *
     * @return - employee position
     */
    Position getPosition();

    /**
     * This method returns list of subordinates
     *
     * @return list of workers
     */
    List<Worker> getListOfWorkers();

    /**
     * This method returns the permissible amount of workers
     *
     * @return amount of workers
     */
    int getAmountOfWorkers();

    /**
     * This method sets the permissible amount of workers
     *
     * @param amount - amount of workers
     */
    void setAmountOfWorkers(int amount);

    /**
     * This method adds worker to the manager list of workers
     *
     * @param worker - worker
     * @return - true if worker have been added
     */
    boolean acceptWorker(Worker worker);

    /**
     * This method removes worker from the manager list of workers
     *
     * @param worker - worker for remove
     * @return - true if worker have been removed
     */
    boolean removeWorker(Worker worker);

    /**
     * This method sets employee description
     *
     * @param description - employee description
     */
    void setDescription(String description);

    /**
     * This method returns description of other employee
     *
     * @return - employee description
     */
    String getDescription();

    /**
     * This method changed employee position for some other one
     *
     * @param toPosition - new position
     * @param successors - some successors for subordinate, if necessary
     * @return true, if employee have been changed
     */
    boolean changePosition(Employee employee, Position toPosition, Employee... successors);

    /**
     * This method returns string interpretation of current employee
     *
     * @param employee - employee
     * @return string interpretation of current employee
     */
    String toString(Employee employee);
}
