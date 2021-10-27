package lesson.lesson08.observer;

public interface Observable {
    void addObserver(Observer observer);
    void notifyObserver();
}
