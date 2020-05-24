import com.java.entity.Author;
import com.java.entity.Book;
import com.java.entity.BookDetails;
import com.java.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PairwiseTest {

    List<Book> books = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    @Test
    public void TestCaseOne(){

        Customer customer = new Customer();
        customer.setName("Dino");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("IT");
        bookDetail.setImageLink("Google.com");
        bookDetail.setLanguage("English");

        Author author = new Author();
        author.setName("Agatha Christie");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("England");
        bookDetail.setYear(0);
        bookDetail.setPages(301);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseTwo(){

        Customer customer = new Customer();
        customer.setName("Dino");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("Murder she wrote");
        bookDetail.setImageLink("Google.com");
        bookDetail.setLanguage("English");

        Author author = new Author();
        author.setName("Agatha Christie");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("England");
        bookDetail.setYear(0);
        bookDetail.setPages(301);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseThree(){

        Customer customer = new Customer();
        customer.setName("Jason");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("cSharp");
        bookDetail.setImageLink("Test.com");
        bookDetail.setLanguage("Dutch");

        Author author = new Author();
        author.setName("John Doe");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("Netherlands");
        bookDetail.setYear(0);
        bookDetail.setPages(400);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseFour(){

        Customer customer = new Customer();
        customer.setName("Jason");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("Cplusplus");
        bookDetail.setImageLink("Test.com");
        bookDetail.setLanguage("Dutch");

        Author author = new Author();
        author.setName("John Doe");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("Netherland");
        bookDetail.setYear(10);
        bookDetail.setPages(400);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseFive(){

        Customer customer = new Customer();
        customer.setName("2");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("4");
        bookDetail.setImageLink("2");
        bookDetail.setLanguage("2");

        Author author = new Author();
        author.setName("2");

        bookDetail.setAuthor(author);
        bookDetail.setCountry("2");
        bookDetail.setYear(2);
        bookDetail.setPages(2);

        Book book = new Book();
        book.setBookDetails(bookDetail);

        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseSix(){

        Customer customer = new Customer();
        customer.setName("Dino");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("IT");
        bookDetail.setImageLink("Google.com");
        bookDetail.setLanguage("English");

        Author author = new Author();
        author.setName("Agatha Christie");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("England");
        bookDetail.setYear(2002);
        bookDetail.setPages(301);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseSeven(){

        Customer customer = new Customer();
        customer.setName("Jason");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("IT");
        bookDetail.setImageLink("Google.com");
        bookDetail.setLanguage("English");

        Author author = new Author();
        author.setName("Agatha Christie");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("England");
        bookDetail.setYear(2002);
        bookDetail.setPages(301);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseEight(){

        Customer customer = new Customer();
        customer.setName("Jason");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("Murder She Wrote");
        bookDetail.setImageLink("Google.com");
        bookDetail.setLanguage("English");

        Author author = new Author();
        author.setName("Agatha Christie");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("England");
        bookDetail.setYear(2002);
        bookDetail.setPages(301);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseNine(){

        Customer customer = new Customer();
        customer.setName("Dino");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("Murder She Wrote");
        bookDetail.setImageLink("Google.com");
        bookDetail.setLanguage("English");

        Author author = new Author();
        author.setName("Agatha Christie");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("England");
        bookDetail.setYear(2000);
        bookDetail.setPages(301);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseTen(){

        Customer customer = new Customer();
        customer.setName("Jason");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("Murder She Wrot");
        bookDetail.setImageLink("Google.com");
        bookDetail.setLanguage("English");

        Author author = new Author();
        author.setName("Agatha Christie");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("England");
        bookDetail.setYear(2002);
        bookDetail.setPages(301);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseSEleven(){

        Customer customer = new Customer();
        customer.setName("Jason");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("cSharp");
        bookDetail.setImageLink("Test.com");
        bookDetail.setLanguage("Dutch");

        Author author = new Author();
        author.setName("John Doe");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("Netherlands");
        bookDetail.setYear(2002);
        bookDetail.setPages(400);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseTwelve(){

        Customer customer = new Customer();
        customer.setName("Dino");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("cSharp");
        bookDetail.setImageLink("Test.com");
        bookDetail.setLanguage("Dutch");

        Author author = new Author();
        author.setName("John Doe");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("Netherlands");
        bookDetail.setYear(2002);
        bookDetail.setPages(400);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseThirteen(){

        Customer customer = new Customer();
        customer.setName("Jason");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("cSharp");
        bookDetail.setImageLink("Test.com");
        bookDetail.setLanguage("Dutch");

        Author author = new Author();
        author.setName("John Doe");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("Netherlands");
        bookDetail.setYear(2002);
        bookDetail.setPages(400);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);
    }

    @Test
    public void TestCaseFourteen(){

        Customer customer = new Customer();
        customer.setName("Dino");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("cSharp");
        bookDetail.setImageLink("Test.com");
        bookDetail.setLanguage("Dutch");

        Author author = new Author();
        author.setName("John Doe");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("Netherlands");
        bookDetail.setYear(2002);
        bookDetail.setPages(400);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseFifteen(){

        Customer customer = new Customer();
        customer.setName("Dino");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("Cplusplus");
        bookDetail.setImageLink("Test.com");
        bookDetail.setLanguage("English");

        Author author = new Author();
        author.setName("Dutch");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("Netherlands");
        bookDetail.setYear(1999);
        bookDetail.setPages(400);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }

    @Test
    public void TestCaseSixteen(){

        Customer customer = new Customer();
        customer.setName("Jason");

        BookDetails bookDetail = new BookDetails();
        bookDetail.setTitle("Cplusplus");
        bookDetail.setImageLink("Test.com");
        bookDetail.setLanguage("English");

        Author author = new Author();
        author.setName("John Doe");
        bookDetail.setAuthor(author);
        bookDetail.setCountry("Netherlands");
        bookDetail.setYear(1999);
        bookDetail.setPages(400);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

    }



}
