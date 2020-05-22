package com.java.repository;

import com.java.entity.Book;
import com.java.entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Catalog.
 */
public class LocalCatalog implements Catalog {

    private ArrayList<Book> bookArrayList;

    /**
     * Instantiates a new Catalog.
     */
    public LocalCatalog() {
        bookArrayList = new ArrayList<>();
    }

    /**
     * Gets book array list.
     *
     * @return the book array list
     */
    @Override
    public List<Book> getBookArrayList() {
        // avoid static function to enables class to be tested
        return bookArrayList;
    }

    /**
     * Sets book array list.
     *
     * @param bookArrayList the book array list
     */
    // this is not a best practice, because if we set arraylist from external e.g. from viewModel, then
    // then we edit the arraylist in viewModel, it will change booklist that already set into catalog.
    // which is causing invalid data
//    public void setBookArrayList(ArrayList<Book> bookArrayList) {
//        this.bookArrayList = bookArrayList;
//    }

    /**
     * Find book by title book.
     *
     * @param title the title
     * @return the book
     */
    @Override
    public Book findBookByTitle(String title) {
        for (Book book : bookArrayList) {
            if (book.getBookDetails().getTitle().equalsIgnoreCase(title))
                return book;
        }
        return null;
    }

    /**
     * Find book by isbn book.
     *
     * @param ISBN the isbn
     * @return the book
     */
    @Override
    public Book findBookByISBN(Long ISBN) {
        for (Book book : bookArrayList) {
            if (book.getISBN().equals(ISBN))
                return book;
        }
        return null;
    }

    /**
     * Loan book boolean.
     *
     * @param customer the customer
     * @param ISBN     the isbn
     * @return the boolean
     */
    @Override
    public boolean loanBook(Customer customer, Long ISBN) {
        for (Book book : bookArrayList) {
            if (book.getISBN().equals(ISBN)) {
                if (book.getAvailable()) {
                    book.setAvailable(false);
                    ArrayList<Book> b = customer.getRentedBooks();
                    b.add(book);
                    customer.setRentedBooks(b);
                    return true;
                } else return false;
            }
        }
        return false;
    }

    /**
     * Return book boolean.
     *
     * @param customer the customer
     * @param ISBN     the isbn
     * @return the boolean
     */
    @Override
    public boolean returnBook(Customer customer, Long ISBN) {
        for (Book book : bookArrayList) {
            if (book.getISBN().equals(ISBN)) {
                if (!book.getAvailable()) {
                    book.setAvailable(true);
                    ArrayList<Book> b = customer.getRentedBooks();
                    b.remove(book);
                    customer.setRentedBooks(b);
                    return true;
                } else return false;
            }
        }
        return false;
    }

    @Override
    public void addBook(Book book) {
        bookArrayList.add(book);
    }

    @Override
    public void clear() {
        bookArrayList.clear();
    }
}
