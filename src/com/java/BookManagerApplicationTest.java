package com.java;

import com.java.entity.Book;
import com.java.entity.Customer;
import com.java.injection.DependencyInjector;
import com.java.repository.Catalog;
import com.java.repository.CustomerRepository;
import com.java.template.Application;
import com.java.viewmodel.BookManagerViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.Executor;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookManagerApplicationTest {

    private BookManagerApplication application;
    private ByteArrayOutputStream output;
    private BookManagerViewModel viewModel;
    private ByteArrayOutputStream error;
    private String input;
    private Executor executor = Runnable::run;

    @BeforeEach
    public void setup() {
        output = new ByteArrayOutputStream();
        error = new ByteArrayOutputStream();
        viewModel = new BookManagerViewModel(executor, new TestCustomerRepository(), new TestCatalog());

        DependencyInjector.instance = new DependencyInjector() {
            @Override
            public void inject(Application application) {
                // we know that in this test, always using BookManagerApplication, so we don't need to check
                BookManagerApplication app = (BookManagerApplication) application;
                app.viewModel = viewModel;
                app.workerThread = executor;
                app.out = new PrintStream(output);
                app.err = new PrintStream(error);
                app.userInput = new InputManager(new ByteArrayInputStream(input.getBytes()), app.out, app.err);
            }
        };

        application = new BookManagerApplication();
    }

    // if we use system.in and system.out we cannot test the BookManagerApplication
    @Test
    public void test_whenUserInputQOnMenu_applicationShouldQuit() {
        input = "q\n";

        application.start();

        String expectedOutput = "*********Welkom bij de Bibliotheek van Dino Cosic*********\n" +
                "\n" +
                "1.  Add a Customer\n" +
                "2.  Add a Book\n" +
                "3.  Search a Book\n" +
                "4.  Loan a Book\n" +
                "5.  Return a Book\n" +
                "6.  Backup Data\n" +
                "7.  Retrieve Data\n" +
                "8.  Print All Customers\n" +
                "9.  Print All Books\n" +
                "10. Print Rented Books\n" +
                "Q.  Exit\n" +
                "\n" +
                "Please enter a number(1-10) : \n" +
                "Application closed\n";
        assertEquals(expectedOutput, output.toString());
    }

    static class TestCatalog implements Catalog {

        @Override
        public List<Book> getBookArrayList() {
            return null;
        }

        @Override
        public Book findBookByTitle(String title) {
            return null;
        }

        @Override
        public Book findBookByISBN(Long ISBN) {
            return null;
        }

        @Override
        public boolean loanBook(Customer customer, Long ISBN) {
            return false;
        }

        @Override
        public boolean returnBook(Customer customer, Long ISBN) {
            return false;
        }

        @Override
        public void addBook(Book book) {

        }

        @Override
        public void clear() {

        }
    }

    static class TestCustomerRepository implements CustomerRepository {
        @Override
        public void addCustomer(Customer customer) {

        }

        @Override
        public List<Customer> getCustomers() {
            return null;
        }

        @Override
        public void clear() {

        }
    }
}