package ua.training.company;

import java.util.List;

public interface EmployeeScope {

    final String UNSUPPORTED_OPERATION = "This method is not supported by %s.";
    final String ILLEGAL_SUCCESSOR = "Illegal successor type.";
    final String ILLEGAL_EMPLOYEE_STATE = "Illegal employee state.";

    Position getPosition();
    List<Worker> getListOfWorkers();
    int getAmountOfWorkers();
    void setAmountOfWorkers(int amount);
    boolean acceptWorker(Worker worker);
    boolean removeWorker(Worker worker);
    void setDescription(String description);
    String getDescription();
    boolean changePosition(Employee employee, Position toPosition, Employee... successors);
    String toString(Employee employee);
}
