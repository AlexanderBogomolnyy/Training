package ua.training.company;

public interface Worker {

    boolean changePosition(Position toPosition, Employee... successors);

}
