package ua.training.company;

import java.util.ArrayList;
import java.util.List;

public class ManagerScope implements EmployeeScope {


//    private static final String CANNOT_CHANGE_POSITION = "To many workers in subjection. Add more successors.";


    List<Worker> workers = new ArrayList<>();
    int amount = 0;

    @Override
    public Position getPosition() {
        return Position.MANAGER;
    }

    @Override
    public int getAmountOfWorkers() {
        return amount;
    }

    @Override
    public List<Worker> getListOfWorkers() {
        return workers;
    }

    @Override
    public void setAmountOfWorkers(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean acceptWorker(Worker worker) {
        if (amount > workers.size()) {
            workers.add(worker);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeWorker(Worker worker) {
        return workers.remove(worker);
    }

    @Override
    public void setDescription(String description) {
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_OPERATION, getPosition()));
    }

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_OPERATION, getPosition()));
    }

    @Override
    public boolean changePosition(Employee employee, Position toPosition, Employee... successors) {
        if(employee.getPosition() != Position.MANAGER)
            throw new IllegalStateException(ILLEGAL_EMPLOYEE_STATE);
        for(Employee successor: successors)
            if (successor.getPosition() != Position.MANAGER) {
                throw new IllegalArgumentException(ILLEGAL_SUCCESSOR);
            }
        if(toPosition == Position.MANAGER || employee.getListOfWorkers().size() > this.freePlaces(successors)) {
            return false;
        }
        List<Worker> workers = employee.getListOfWorkers();
        for (int i = 0; i < workers.size(); i++) {
            successors[i%successors.length].acceptWorker(workers.get(i));
        }
        employee.getListOfWorkers().clear();
        employee.setScope(toPosition);
        return true;
    }

    private int freePlaces(Manager[] managers) {
        int count = 0;
        for(Manager manager: managers) {
            count += (manager.getAmountOfWorkers() - manager.getListOfWorkers().size());
        }
        return count;
    }

    @Override
    public String toString(Employee employee) {
        String result = "Workers [";
        for(Worker worker: workers)
            result += worker.toString() + ", ";
        return ", amount of workers = " + workers.size() +
                ", " + result.substring(0, result.length()-2) + "] ";
    }
}
