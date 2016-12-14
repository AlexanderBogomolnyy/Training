package ua.training.company;

public interface Other {

    void setDescription(String description);

    String getDescription();

    boolean changePosition(Position toPosition, Employee... successors);
}
