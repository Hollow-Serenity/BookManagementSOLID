package com.java.observer;

public interface Observer<T> {
    void onNext(T value);
}
