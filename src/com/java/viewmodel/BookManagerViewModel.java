package com.java.viewmodel;

import com.java.SystemManager;
import com.java.entity.Book;
import com.java.entity.Customer;
import com.java.observer.Observable;
import com.java.observer.Subject;
import com.java.repository.Catalog;
import com.java.repository.CustomerRepository;

import javax.imageio.stream.ImageInputStream;
import java.util.*;
import java.util.concurrent.Executor;

public class BookManagerViewModel {
    private Executor workerThread;
    private CustomerRepository customerRepository;
    private Catalog catalog;

    public Subject<Page> pageSubject = new Subject<>(Page.MAIN);
    public Subject<String> messageSubject = new Subject<>(null);

    public BookManagerViewModel(Executor workerThread, CustomerRepository customerRepository, Catalog catalog) {
        this.workerThread = workerThread;
        this.customerRepository = customerRepository;
        this.catalog = catalog;
    }

    public Observable<Page> getPageObservable() {
        return pageSubject;
    }

    public void navigate(int index) {
        workerThread.execute(() -> {
            Page goTo = Page.parse(index);

            pageSubject.publish(goTo);
        });
    }

    public void addCustomer(Customer customer) {
        workerThread.execute(() -> {
            customerRepository.addCustomer(customer);

            pageSubject.publish(Page.MAIN);
        });
    }

    public void printCustomers() {
        workerThread.execute(() -> {
            List<Customer> customers = customerRepository.getCustomers();

            // sort is an implementation of Strategy Pattern, the actual sort is already implemented
            // but it require sorting strategy as parameter
            customers.sort(new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            messageSubject.publish("--- Customers List ---");
            for (Customer customer : customers) {
                messageSubject.publish(customer.toString());
            }
            messageSubject.publish("---------------------");
            pageSubject.publish(Page.MAIN);
        });
    }

    public void addBook(Book book) {
        workerThread.execute(() -> {
            catalog.addBook(book);
            pageSubject.publish(Page.MAIN);
        });
    }

    public void searchBookByTitle(String title) {
        workerThread.execute(() -> {
            Book book = catalog.findBookByTitle(title);
            printBook(book);
            pageSubject.publish(Page.MAIN);
        });
    }

    public void searchBookByISBN(Long isbn) {
        workerThread.execute(() -> {
            Book book = catalog.findBookByISBN(isbn);
            printBook(book);
            pageSubject.publish(Page.MAIN);
        });
    }

    public void printBooks() {
        workerThread.execute(() -> {
            messageSubject.publish("--- Books List ---");
            printBookList(book -> true);
            pageSubject.publish(Page.MAIN);
        });
    }

    public void printRentedBooks() {
        workerThread.execute(() -> {
            messageSubject.publish("--- Rented Books List ---");
            printBookList(book -> !book.getAvailable());
            messageSubject.publish("---------------------");
        });
    }

    private void printBook(Book book) {
        if (book != null) {
            messageSubject.publish(book.toString());
        } else {
            messageSubject.publish("No book found");
        }
    }

    // this is another example of strategy pattern
    private void printBookList(BookCriteria criteria) {
        for (Book book : catalog.getBookArrayList()) {
            if (criteria.shouldPrint(book)) {
                messageSubject.publish(book.toString());
            }
        }
    }

    public Customer searchCustomerByEmail(String email) {
        for (Customer customer : customerRepository.getCustomers()) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                return customer;
            }
        }
        return null;
    }

    public void loadBook(Customer customer, long isbn) {
        workerThread.execute(() -> {
            boolean success = catalog.loanBook(customer, isbn);
            if (success) {
                messageSubject.publish("Book rented successfully");
            } else {
                messageSubject.publish("Book not availbale");
            }
            pageSubject.publish(Page.MAIN);
        });
    }

    public void returnBook(Customer customer, long isbn) {
        workerThread.execute(() -> {
            boolean success = catalog.returnBook(customer, isbn);
            if (success) {
                messageSubject.publish("Book returned successfully");
            } else {
                messageSubject.publish("Book not available");
            }
            pageSubject.publish(Page.MAIN);
        });
    }

    public void backupData() {
        workerThread.execute(() -> {
            SystemManager.makeBackup(
                    customerRepository.getCustomers(),
                    catalog.getBookArrayList());

            messageSubject.publish("Data backed-up successfully");
            pageSubject.publish(Page.MAIN);
        });
    }

    public void retrieveBackup() {
        workerThread.execute(() -> {
            customerRepository.clear();
            for (Customer customer : SystemManager.retrieveCustomers()) {
                customerRepository.addCustomer(customer);
            }

            catalog.clear();
            for (Book book : SystemManager.retrieveBooks()) {
                catalog.addBook(book);
            }

            messageSubject.publish("Data retrieved successfully");
            pageSubject.publish(Page.MAIN);
        });
    }

    public void printRentedBooksByCustomer() {
        workerThread.execute(() -> {
            messageSubject.publish("--- Rented Books by Customers List ---");
            for (Customer customer : customerRepository.getCustomers()) {
                if (customer.getRentedBooks().size() > 0) {
                    messageSubject.publish("Customer: " + customer.getEmail());
                    messageSubject.publish("Rented Books: ");
                    for (int j = 0; j < customer.getRentedBooks().size(); j++) {
                        messageSubject.publish(customer.getRentedBooks().get(j).toString());
                    }
                }
            }
            messageSubject.publish("---------------------");

            pageSubject.publish(Page.MAIN);
        });
    }

    interface BookCriteria {
        boolean shouldPrint(Book book);
    }

    public enum Page {
        MAIN(0),
        ADD_CUSTOMER(1),
        ADD_BOOK(2),
        SEARCH_BOOK(3),
        LOAN_BOOK(4),
        RETURN_BOOK(5),
        BACKUP_DATA(6),
        RETRIEVE_DATA(7),
        PRINT_CUSTOMER(8),
        PRINT_BOOK(9),
        PRINT_RENTED(10),
        PRINT_RENTED_BY_CUSTOMER(11),
        QUIT(-1);

        private static Page[] pages = {
                MAIN, ADD_CUSTOMER, ADD_BOOK, SEARCH_BOOK, LOAN_BOOK, RETURN_BOOK, BACKUP_DATA, RETRIEVE_DATA, PRINT_CUSTOMER, PRINT_BOOK, PRINT_RENTED, QUIT
        };

        public static Page parse(int index) {
            for (Page page : pages) {
                if (page.index == index) {
                    return page;
                }
            }
            // if the page not found, by default will go to MAIN
            return MAIN;
        }

        Page(int index) {
            this.index = index;
        }

        public final int index;

    }
}
