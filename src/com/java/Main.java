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

        //Large class. it held too much responsibility and also the static main function
        //held the responsibility for everything with its flow.

        /*
          * Duplicate code: almost every input other than String input (zie BookmanagerViewModel)
          * It may affect readability and ends with exception, application exit with exit codes rather than 0
          * Which indicator apps not run normally (Zie BookManagerViewModel)
         */

        /*
            Static methods: Statische methoden werken het beste als hulpprogramma's (denk aan System.Math) of andere zeer nauwgezette methoden.
            Als je je kunt voorstellen dat je ooit overerving van objecten of polymorfisme voor je methode nodig hebt,
            moet je de statische methode zeker overslaan en er een instantiemethode van maken.

            Zie: BookManagerApplication.java, BookManagerViewModel.java, InputManager.java voor details.
         */


    }
}
