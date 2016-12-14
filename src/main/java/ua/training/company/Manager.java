package ua.training.company;

import java.util.List;

public interface Manager {

    List<Worker> getListOfWorkers();

    int getAmountOfWorkers();

    void setAmountOfWorkers(int amount);

    boolean acceptWorker(Worker worker);

    boolean removeWorker(Worker worker);

    boolean changePosition(Position toPosition, Employee... successors);

}
