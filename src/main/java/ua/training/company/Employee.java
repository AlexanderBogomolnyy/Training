package ua.training.company;

import java.util.List;

public class Employee implements Worker, Manager, Other{

    private static final String ILLEGAL_ARGUMENT = "Wrong employee position type.";

    private PersonalData personalData;
    private EmployeeScope scope;

    public Employee(PersonalData personalData, Position position) {
        this.personalData = personalData;
        this.setScope(position);
    }

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

    public boolean changePosition(Position toPosition, Employee... successors) {
        return scope.changePosition(this, toPosition, successors);
    }

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
