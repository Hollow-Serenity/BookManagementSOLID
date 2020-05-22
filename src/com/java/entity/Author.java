package com.java.entity;

/**
 * The type Author.  Author is a person which means author is a child class and person is a parent class.
 */
public class Author extends Person {

    private Integer noOfPublications;

    /**
     * Instantiates a new Author.
     *
     * @param email            the email
     * @param name             the name
     * @param phoneNumber      the phone number
     * @param streetAddress    the street address
     * @param zipCode          the zip code
     * @param gender           the gender
     * @param city             the city
     * @param noOfPublications the no of publications
     */
    public Author(String email, String name, String phoneNumber, String streetAddress, String zipCode, String gender,
                  String city, Integer noOfPublications) {
        super(email, name, phoneNumber, streetAddress, zipCode, gender, city);
        this.noOfPublications = noOfPublications;
    }

    public Author() {
        super();
    }


    /**
     * Gets no of publications.
     *
     * @return the no of publications
     */
    public Integer getNoOfPublications() {
        return noOfPublications;
    }

    /**
     * Sets no of publications.
     *
     * @param noOfPublications the no of publications
     */
    public void setNoOfPublications(Integer noOfPublications) {
        this.noOfPublications = noOfPublications;
    }

    // This function may be considered as violation of Liskov Substitution Principles where it modifies
    // the original function and causing misbehavior of the class it self.
    // the output will displays as Person, not Author
    @Override
    public String toString() {
        return "Author{" +
                "email='" + getEmail() + "'" +
                ", name='" + getName() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", streetAddress='" + getStreetAddress() + "'" +
                ", zipCode='" + getZipCode() + "'" +
                ", gender='" + getGender() + "'" +
                ", city='" + getCity() + "'" +
                ", noOfPublications=" + noOfPublications +
                '}';
    }
}
