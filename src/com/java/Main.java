package com.java;

import com.java.injection.DependencyInjector;
import com.java.template.Application;

/**
 * The type Main.
 * <p>
 * Author is a Person (inheritance)
 * Customer is a Person (inheritance)
 * Book has a BookDetails (composition)
 * Catalog has a list of books (aggregation)
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // benefit of using template pattern is we can have more than 1 implementation in single
        // java application, example: we can have commandline application and build other application
        // using template with GUI. so we can control we want use GUI or CommandLine
        Application application;

        SystemManager.initialize();
        // initialize dependency injector outside the application. since application is the consumer of injection,
        // it shouldn't be the initiator of injector
        DependencyInjector.initialize();
//        example
//        if (args[0].equals("gui")) {
//            application = new BookManagerGuiApplication();
//        } else
        application = new BookManagerApplication();
//        }
        application.start();


    }
}
