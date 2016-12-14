package ua.training.company;

import java.util.List;

public class WorkerScope implements EmployeeScope {

    @Override
    public Position getPosition() {
        return Position.WORKER;
    }

    @Override
    public List<Worker> getListOfWorkers() {
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_OPERATION, getPosition()));
    }

    @Override
    public int getAmountOfWorkers() {
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_OPERATION, getPosition()));
    }

    @Override
    public void setAmountOfWorkers(int amount) {
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_OPERATION, getPosition()));
    }

    @Override
    public boolean acceptWorker(Worker worker) {
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_OPERATION, getPosition()));
    }

    @Override
    public boolean removeWorker(Worker worker) {
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_OPERATION, getPosition()));
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
        if(employee.getPosition() != Position.WORKER)
            throw new IllegalStateException(ILLEGAL_EMPLOYEE_STATE);
        employee.setScope(toPosition);
        return true;
    }

    @Override
    public String toString(Employee employee) {
        return "";
    }
}
