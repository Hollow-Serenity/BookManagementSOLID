package com.java.entity;

/**
 * The type Book details.
 */
public class BookDetails {

    private String title;
    private Author author; // has a relationship
    private Integer year;
    private String imageLink;
    private String language;
    private Integer pages;
    private String country;

    /**
     * Instantiates a new Book details.
     *
     * @param title     the title
     * @param author    the author
     * @param year      the year
     * @param imageLink the image link
     * @param language  the language
     * @param pages     the pages
     * @param country   the country
     */
    public BookDetails(String title, Author author, Integer year, String imageLink, String language,
                       Integer pages, String country) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.imageLink = imageLink;
        this.language = language;
        this.pages = pages;
        this.country = country;
    }

    public BookDetails(){

    }
    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Gets image link.
     *
     * @return the image link
     */
    public String getImageLink() {
        return imageLink;
    }

    /**
     * Sets image link.
     *
     * @param imageLink the image link
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets language.
     *
     * @param language the language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets pages.
     *
     * @return the pages
     */
    public Integer getPages() {
        return pages;
    }

    /**
     * Sets pages.
     *
     * @param pages the pages
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", year=" + year +
                ", imageLink='" + imageLink + '\'' +
                ", language='" + language + '\'' +
                ", pages=" + pages +
                ", country='" + country + '\'' +
                '}';
    }
}
