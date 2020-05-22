package com.java;

import com.java.entity.Author;
import com.java.entity.Book;
import com.java.entity.BookDetails;
import com.java.entity.Customer;
import com.java.injection.DependencyInjector;
import com.java.template.Application;
import com.java.viewmodel.BookManagerViewModel;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class BookManagerApplication extends Application {
    //set to public to be injectable from dependency injector
    // this is also very useful for make the class testable
    public Executor workerThread;
    public BookManagerViewModel viewModel;
    public PrintStream out;
    public PrintStream err;
    public InputManager userInput;

    //repeat is only used in single method, it should be put inside the method.
//    private boolean repeat = true;

    //Violation : Single Responsibility Principles, this class handles too much responsibility, including data source and business logic
//    private ArrayList<Customer> customerArrayList;
//    private Catalog catalog;

    @Override
    protected void initialize() {
        // this is for dependency injection, since we cannot set executor and viewmodel from constructor
        // we use this approach
        DependencyInjector.instance.inject(this);
        out.println("*********Welkom bij de Bibliotheek van Dino Cosic*********");
    }

    @Override
    protected void run() {
        viewModel.messageSubject.registerObserver(message -> {
            workerThread.execute(() -> {
                if (message != null) {
                    out.println(message);
                }
            });
        });

        viewModel.pageSubject.registerObserver(page -> {
            workerThread.execute(() -> {
                switch (page) {
                    case MAIN:
                        mainMenu();
                        break;
                    case ADD_CUSTOMER:
                        addCustomer();
                        break;
                    case ADD_BOOK:
                        addBook();
                        break;
                    case PRINT_CUSTOMER:
                        printCustomer();
                        break;
                    case PRINT_BOOK:
                        printBooks();
                        break;
                    case PRINT_RENTED:
                        printRentedBooks();
                        break;
                    case LOAN_BOOK:
                        loanBook();
                        break;
                    case RETURN_BOOK:
                        returnBook();
                        break;
                    case SEARCH_BOOK:
                        searchBook();
                        break;
                    case BACKUP_DATA:
                        backupData();
                        break;
                    case RETRIEVE_DATA:
                        retrieveData();
                        break;
                    case PRINT_RENTED_BY_CUSTOMER:
                        printRentedBooksByCustomers();
                        break;
                    case QUIT:
                        break;
                }
            });
        });
    }

    private void mainMenu() {
        String menu = "\n1.  Add a Customer" +
                "\n2.  Add a Book" +
                "\n3.  Search a Book" +
                "\n4.  Loan a Book" +
                "\n5.  Return a Book" +
                "\n6.  Backup Data" +
                "\n7.  Retrieve Data" +
                "\n8.  Print All Customers" +
                "\n9.  Print All Books" +
                "\n10. Print Rented Books" +
                "\nQ.  Exit" +
                "\n\nPlease enter a number(1-10) : ";
        String input = userInput.getInputString(menu);
        int select = 0;
        try {
            select = Integer.parseInt(input);
        } catch (Exception e) {
            if (input.equalsIgnoreCase("q")) {
                select = -1;
            }
        }
        viewModel.navigate(select);
    }

    private void addCustomer() {
        Customer customer = new Customer();
        customer.setEmail(userInput.getInputString("Enter email address:"));
        customer.setName(userInput.getInputString("Enter name"));
        customer.setPhoneNumber(userInput.getInputString("Enter phone number"));
        customer.setStreetAddress(userInput.getInputString("Enter street address"));
        customer.setZipCode(userInput.getInputString("Enter zip code"));
        customer.setGender(userInput.getInputString("Enter gender"));
        customer.setCity(userInput.getInputString("Enter city"));
        viewModel.addCustomer(customer);
    }

    private void addBook() {

        Book book = new Book();

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle(userInput.getInputString("Enter book title: "));

        Author author = new Author();
        author.setEmail(userInput.getInputString("Enter author email: "));
        author.setName(userInput.getInputString("Enter author name:"));
        author.setPhoneNumber(userInput.getInputString("Enter author phone number:"));
        author.setStreetAddress(userInput.getInputString("Enter author address:"));
        author.setZipCode(userInput.getInputString("Enter author zip code:"));
        author.setGender(userInput.getInputString("Enter author gender:"));
        author.setCity(userInput.getInputString("Author city:"));
        author.setNoOfPublications(userInput.getInputInt("Enter number of publications by author:"));

        bookDetail.setYear(userInput.getInputInt("Enter year of publication of book"));
        bookDetail.setImageLink(userInput.getInputString("Enter image link"));
        bookDetail.setLanguage(userInput.getInputString("Enter language of book"));
        bookDetail.setPages(userInput.getInputInt("Enter number of pages of book"));
        bookDetail.setCountry(userInput.getInputString("Enter country name where book was published"));

        bookDetail.setAuthor(author);
        book.setBookDetails(bookDetail);
        viewModel.addBook(book);
    }

    private void searchBook() {
        String searchMenu = "1. Title\n2. ISBN\nSearch by : ";
        int in = userInput.getInputInt(searchMenu);
        switch (in) {
            case 1:
                String t = userInput.getInputString("Enter Title: ");
                viewModel.searchBookByTitle(t);
                break;
            case 2:
                Long isbn = userInput.getInputLong("Enter ISBN: ");
                viewModel.searchBookByISBN(isbn);
                break;
            default:
                out.println("Wrong input");
                mainMenu();
        }
    }

    private void loanBook() {
        String email = userInput.getInputString("Enter user email who wants to rent book : ");
        Customer customer = viewModel.searchCustomerByEmail(email);

        if (customer != null) {
            long isbn = userInput.getInputLong("Enter ISBN for which book you want to loan : ");
            viewModel.loadBook(customer, isbn);
        } else {
            out.println("No customer found with this email.");
            mainMenu();
        }
    }

    private void returnBook() {
        String email = userInput.getInputString("Enter user email who wants to return book : ");
        Customer customer = viewModel.searchCustomerByEmail(email);

        if (customer != null) {
            long isbn = userInput.getInputLong("Enter ISBN for which book you want to return : ");
            viewModel.returnBook(customer, isbn);
        } else {
            out.println("No user found with this email");
            mainMenu();
        }
    }

    private void backupData() {
        viewModel.backupData();
    }

    private void retrieveData() {
        viewModel.retrieveBackup();
    }

    private void printCustomer() {
        viewModel.printCustomers();
    }

    private void printBooks() {
        viewModel.printBooks();
    }

    private void printRentedBooks() {
        viewModel.printRentedBooks();
    }

    private void printRentedBooksByCustomers() {
        viewModel.printRentedBooksByCustomer();
    }

    @Override
    protected void destroy() {
        out.println("Application closed");
    }
}
