package com.java.entity;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Book.
 */
public class Book {

    private Long ISBN;
    private BookDetails bookDetails; // book class 'has a' BookDetails. has a relationship here
    private Boolean isAvailable;

    /**
     * Instantiates a new Book.
     *
     * @param ISBN        the isbn
     * @param bookDetails the book details
     * @param isAvailable the is available
     */
    public Book(Long ISBN, BookDetails bookDetails, Boolean isAvailable) {
        this.ISBN = ISBN;
        this.bookDetails = bookDetails;
        this.isAvailable = isAvailable;
    }

    public Book() {
        ISBN = Book.generateISBN();
    }




    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public Long getISBN() {
        return ISBN;
    }

    /**
     * Sets isbn.
     *
     * @param ISBN the isbn
     */
    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Gets book details.
     *
     * @return the book details
     */
    public BookDetails getBookDetails() {
        return bookDetails;
    }

    /**
     * Sets book details.
     *
     * @param bookDetails the book details
     */
    public void setBookDetails(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
    }

    /**
     * Gets available.
     *
     * @return the available
     */
    public Boolean getAvailable() {
        return isAvailable;
    }

    /**
     * Sets available.
     *
     * @param available the available
     */
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    /**
     * Generate isbn long.
     *
     * @return the long
     */
    public static Long generateISBN() {
        return ThreadLocalRandom.current().nextLong(1000000, 9999999);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", bookDetails=" + bookDetails +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
