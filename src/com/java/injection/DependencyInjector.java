package com.java.injection;

import com.java.BookManagerApplication;
import com.java.InputManager;
import com.java.template.Application;

public class DependencyInjector {
    public static DependencyInjector instance;

    public static void initialize() {
        instance = new DependencyInjector();
    }

    private BookManagerModule module = new BookManagerModule();

    // when we want to test the application, we need to replace DependencyInjector Instance with
    public void inject(Application application) {
        if (application instanceof BookManagerApplication) {
            inject((BookManagerApplication) application);
        } else {
            throw new IllegalArgumentException("Unknown application to be injected : " + application.getClass().getName());
        }
    }

    private void inject(BookManagerApplication application) {
        // in test, we need to change the stream for input and output into custom stream, since we cannot monitor the
        // output and input. in example. we won't input manually for testing. we should provide it before running the test
        application.err = System.err;
        application.out = System.out;
        application.userInput = new InputManager(System.in, System.out, System.err);
        application.workerThread = module.provideDirectExecutor();
        application.viewModel = module.provideViewModel();
    }
}
