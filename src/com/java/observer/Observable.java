package com.java.observer;

public interface Observable<T> {
    void registerObserver(Observer<T> observer);
    T getValue();
}
