package com.java.injection;

import com.java.repository.Catalog;
import com.java.repository.CustomerRepository;
import com.java.repository.LocalCatalog;
import com.java.repository.LocalCustomerRepository;
import com.java.viewmodel.BookManagerViewModel;

import java.util.concurrent.Executor;

// basicallly Module for Dependency Injection is collection of factory pattern
public class BookManagerModule {
    public BookManagerViewModel provideViewModel() {
        return new BookManagerViewModel(
                provideDirectExecutor(),
                provideCustomerRepository(),
                provideCatalog()
        );
    }

    public Executor provideDirectExecutor() {
        return new Executor() {
            @Override
            public void execute(Runnable command) {
                command.run();
            }
        };
    }

    // Singleton with injection
    private Catalog singleCatalog;

    public Catalog provideCatalog() {
        if (singleCatalog == null) {
            singleCatalog = new LocalCatalog();
        }
        return singleCatalog;
    }

    private CustomerRepository singleCustomerRepository;

    public CustomerRepository provideCustomerRepository() {
        if (singleCustomerRepository == null) {
            singleCustomerRepository = new LocalCustomerRepository();
        }
        return singleCustomerRepository;
    }
}
