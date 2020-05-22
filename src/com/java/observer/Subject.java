package com.java.observer;

// subject should implements observable. because we want ViewModel is the only
// object that can modify the Subject, and View shouldn't able to do that, only observe
// this is related to Interface Segregation Principle from SOLID
public class Subject<T> implements Observable<T>{
    private Observer<T> observer = null;
    private T currentValue;

    public Subject(T initial) {
        currentValue = initial;
    }

    @Override
    public void registerObserver(Observer<T> observer) {
        this.observer = observer;

        //publish current value for newly registered observer
        observer.onNext(currentValue);
    }

    @Override
    public T getValue() {
        return currentValue;
    }

    public void publish(T value) {
        final Observer<T> observer = this.observer;

        if (observer != null) {
            observer.onNext(value);
        }
    }
}
