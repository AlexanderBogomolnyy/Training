package ua.training.company;

import java.util.List;

/**
 * <p> The Manager interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 16.12.2016.
 */
public interface Manager {

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
     * This method changed manager position for some other one
     *
     * @param toPosition - new position
     * @param successors - some successors for subordinate, if necessary
     * @return true, if employee have been changed
     */
    boolean changePosition(Position toPosition, Employee... successors);

}
