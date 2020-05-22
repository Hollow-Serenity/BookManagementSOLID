package com.java;

import com.java.entity.Book;
import com.java.entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * The type System manager.
 */
public class SystemManager {

    private static ArrayList<Customer> customersBackup;
    private static ArrayList<Book> booksBackup;

    /**
     * Instantiates a new System manager.
     */
    public static void initialize() {
        // this should not be a constructor because it only contains static data
        customersBackup = new ArrayList<>();
        booksBackup = new ArrayList<>();
    }

    /**
     * Make backup.
     *
     * @param customers the customers
     * @param books     the books
     */
    // should not accept actual implementation of List, because actual object will be passed, which is make
    // the back up is irrelevant, accept the interface and make a copy for backup
    public static void makeBackup(List<Customer> customers, List<Book> books) {
        customersBackup = new ArrayList<>(customers);
        booksBackup = new ArrayList<>(books);
    }

    /**
     * Retrieve customers array list.
     *
     * @return the array list
     */
    // should not pass the arraylist, we should pass the List, related to Interface Segregation Principle
    public static List<Customer> retrieveCustomers() {
        return customersBackup;
    }

    /**
     * Retrieve books array list.
     *
     * @return the array list
     */
    public static List<Book> retrieveBooks() {
        return booksBackup;
    }
}
