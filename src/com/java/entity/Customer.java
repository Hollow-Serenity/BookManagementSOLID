package com.java.entity;

import java.util.ArrayList;

/**
 * The type Customer. Customer is a person which means customer is a child class and person is a parent class.
 * Generalization
 */
public class Customer extends Person {

    private ArrayList<Book> rentedBooks;

    /**
     * Instantiates a new Customer.
     *
     * @param email         the email
     * @param name          the name
     * @param phoneNumber   the phone number
     * @param streetAddress the street address
     * @param zipCode       the zip code
     * @param gender        the gender
     * @param city          the city
     * @param rentedBooks   the books
     */
    public Customer(String email, String name, String phoneNumber, String streetAddress, String zipCode, String gender,
                    String city, ArrayList<Book> rentedBooks) {
        super(email, name, phoneNumber, streetAddress, zipCode, gender, city);
        this.rentedBooks = rentedBooks;
    }

    public Customer() {
        super();
        this.rentedBooks = new ArrayList<>();
    }

    /**
     * Gets books.
     *
     * @return the books
     */
    public ArrayList<Book> getRentedBooks() {
        return rentedBooks;
    }

    /**
     * Sets books.
     *
     * @param rentedBooks the books
     */
    public void setRentedBooks(ArrayList<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    /**
     * Display books.
     */
    public void displayBooks() {
        for (Book book : rentedBooks) {
            System.out.println(book);
        }
    }

    /**
     * Loan book.
     */
    public void loanBook() {

    }


    // This function may be considered as violation of Liskov Substitution Principles where it modifies
    // the original function and causing misbehavior of the class it self.
    // the output will displays as Person, not Customer
    @Override
    public String toString() {
        return "Customer{" +
                "email='" + getEmail() + "'" +
                ", name='" + getName() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", streetAddress='" + getStreetAddress() + "'" +
                ", zipCode='" + getZipCode() + "'" +
                ", gender='" + getGender() + "'" +
                ", city='" + getCity() + "'" +
                ", books=" + rentedBooks +
                '}';
    }
}
