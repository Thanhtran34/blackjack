package model;

import java.util.LinkedList;
import java.util.List;

/** A class to work with observer. */
public class Subject {
  private List<Observer> observers = new LinkedList<>();

  /** Method to add observer. */
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  /** Method to remove observer. */
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  /** Method to notify observer. */
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update();
    }
  }
}
