package com.java.repository;

import com.java.entity.Book;
import com.java.entity.Customer;

import java.util.List;

public interface Catalog {
    List<Book> getBookArrayList();

    Book findBookByTitle(String title);

    Book findBookByISBN(Long ISBN);

    boolean loanBook(Customer customer, Long ISBN);

    boolean returnBook(Customer customer, Long ISBN);

    void addBook(Book book);

    void clear();
}
