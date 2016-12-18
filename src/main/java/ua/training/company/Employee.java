package ua.training.company;

import java.util.List;

/**
 * <p> The Employee class.
 * This class implements Worker, Manager, Other employee interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 16.12.2016.
 */
public class Employee implements Worker, Manager, Other{

    /**
     * A constant holding message for illegal employee position
     */
    private static final String ILLEGAL_ARGUMENT = "Wrong employee position type.";

    /**
     * This field contains employee personal data
     */
    private PersonalData personalData;

    /**
     * This field contains employee behaviour
     */
    private EmployeeScope scope;

    public Employee(PersonalData personalData, Position position) {
        this.personalData = personalData;
        this.setScope(position);
    }

    /**
     * This method sets employee behaviour according to the employee position
     *
     * @param position - employee position
     */
    void setScope (Position position) {
        switch (position) {
            case WORKER:
                scope = new WorkerScope();
                break;
            case MANAGER:
                scope = new ManagerScope();
                break;
            case OTHER:
                scope = new OtherScope();
                break;
            default:
                throw new IllegalArgumentException(ILLEGAL_ARGUMENT);
        }
    }

    @Override
    public List<Worker> getListOfWorkers() {
        return scope.getListOfWorkers();
    }

    @Override
    public int getAmountOfWorkers() {
        return scope.getAmountOfWorkers();
    }

    @Override
    public void setAmountOfWorkers(int amount) {
        scope.setAmountOfWorkers(amount);
    }

    @Override
    public boolean acceptWorker(Worker worker) {
        return scope.acceptWorker(worker);
    }

    @Override
    public boolean removeWorker(Worker worker) {
        return scope.removeWorker(worker);
    }

    @Override
    public void setDescription(String description) {
        scope.setDescription(description);
    }

    @Override
    public String getDescription() {
        return scope.getDescription();
    }

    @Override
    public boolean changePosition(Position toPosition, Employee... successors) {
        return scope.changePosition(this, toPosition, successors);
    }

    /**
     * This method returns employee position
     *
     * @return - employee position
     */
    public Position getPosition(){
        return scope.getPosition();
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "personalData=" + personalData +
                ", position=" + getPosition() +
                scope.toString(this) +
                '}';
    }
}
