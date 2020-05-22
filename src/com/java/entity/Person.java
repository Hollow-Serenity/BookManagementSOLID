package com.java.entity;

/**
 * The type Person. This is an abstract class, its object cannot be created
 */
public abstract class Person {

    private String email;
    private String name;
    private String phoneNumber;
    private String streetAddress;
    private String zipCode;
    private String gender;
    private String city;

    /**
     * Instantiates a new Person.
     *
     * @param email         the email
     * @param name          the name
     * @param phoneNumber   the phone number
     * @param streetAddress the street address
     * @param zipCode       the zip code
     * @param gender        the gender
     * @param city          the city
     */
    public Person(String email, String name, String phoneNumber, String streetAddress, String zipCode,
                  String gender, String city) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.gender = gender;
        this.city = city;
    }

    public Person() {

    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets street address.
     *
     * @return the street address
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets street address.
     *
     * @param streetAddress the street address
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + "'" +
                ", name='" + name + "'" +
                ", phoneNumber='" + phoneNumber + "'" +
                ", streetAddress='" + streetAddress + "'" +
                ", zipCode='" + zipCode + "'" +
                ", gender='" + gender + "'" +
                ", city='" + city + "'}";
    }
}
