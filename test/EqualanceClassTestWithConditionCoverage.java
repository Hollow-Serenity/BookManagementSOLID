import com.java.entity.Book;
import com.java.entity.BookDetails;
import com.java.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EqualanceClassTestWithConditionCoverage {

   static List<Book> books = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();

    static boolean conditions() {

        boolean validZipCode = false;
        boolean validLanguage = false;
        boolean validYear = false;

        for (Customer c : customers) {
            if (Integer.parseInt(c.getZipCode()) < 3000) {
                validZipCode = true;
            }
        }

        for (Book b : books) {
            if (b.getBookDetails().getLanguage().equalsIgnoreCase("English")) {
                validLanguage = true;
            }
            if (b.getBookDetails().getYear() < 2000) {
                validYear = true;
            }

        }
        if (validZipCode == true || validLanguage == true && validYear==true) {
            return true;
        } else {
            return false;
        }

    }

    @Test
    public void TestCase1() {
        Customer customer = new Customer();
        customer.setName("Jason");
        customer.setZipCode("3001");
        BookDetails bookDetail = new BookDetails();
        bookDetail.setLanguage("Dutch");

        bookDetail.setYear(2000);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

        boolean result = conditions();
        if(result==true){

            System.out.println("Test Case1 Record  Condition True");
        }else{

            System.out.println("Test Case1 Record Condition False");
        }

        customers.clear();
        books.clear();

    }
    @Test
    public void TestCase2() {
        Customer customer = new Customer();
        customer.setName("Jason");
        customer.setZipCode("3002");
        BookDetails bookDetail = new BookDetails();
        bookDetail.setLanguage("Dutch");

        bookDetail.setYear(1999);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

        boolean result = conditions();
        if(result==true){

            System.out.println("Test Case2 Record  Condition True");
        }else{

            System.out.println("Test Case2 Record Condition False");
        }

        customers.clear();
        books.clear();

    }
    @Test
    public void TestCase3() {
        Customer customer = new Customer();
        customer.setName("Jason");
        customer.setZipCode("3003");
        BookDetails bookDetail = new BookDetails();
        bookDetail.setLanguage("English");

        bookDetail.setYear(2002);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

        boolean result = conditions();
        if(result==true){

            System.out.println("Test Case3 Record  Condition True");
        }else{

            System.out.println("Test Case3 Record Condition False");
        }

        customers.clear();
        books.clear();

    }
    @Test
    public void TestCase4() {
        Customer customer = new Customer();
        customer.setName("Jason");
        customer.setZipCode("3004");
        BookDetails bookDetail = new BookDetails();
        bookDetail.setLanguage("English");

        bookDetail.setYear(1999);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

        boolean result = conditions();
        if(result==true){

            System.out.println("Test Case4 Record  Condition True");
        }else{

            System.out.println("Test Case4 Record Condition False");
        }

        customers.clear();
        books.clear();

    }
    @Test
    public void TestCase5() {
        Customer customer = new Customer();
        customer.setName("Jason");
        customer.setZipCode("2012");
        BookDetails bookDetail = new BookDetails();
        bookDetail.setLanguage("Dutch");

        bookDetail.setYear(2007);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

        boolean result = conditions();
        if(result==true){

            System.out.println("Test Case5 Record  Condition True");
        }else{

            System.out.println("Test Case5 Record Condition False");
        }

        customers.clear();
        books.clear();

    }
    @Test
    public void TestCase6() {
        Customer customer = new Customer();
        customer.setName("Jason");
        customer.setZipCode("2093");
        BookDetails bookDetail = new BookDetails();
        bookDetail.setLanguage("Dutch");

        bookDetail.setYear(1992);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

        boolean result = new EqualanceClassTestWithConditionCoverage().conditions();
        if(result==true){

            System.out.println("Test Case6 Record  Condition True");
        }else{

            System.out.println("Test Case6 Record Condition False");
        }

        customers.clear();
        books.clear();

    }
    @Test
    public void TestCase7() {
        Customer customer = new Customer();
        customer.setName("Jason");
        customer.setZipCode("2032");
        BookDetails bookDetail = new BookDetails();
        bookDetail.setLanguage("English");

        bookDetail.setYear(2012);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

        boolean result = conditions();
        if(result==true){

            System.out.println("Test Case7 Record  Condition True");
        }else{

            System.out.println("Test Case7 Record Condition False");
        }

        customers.clear();
        books.clear();

    }
    @Test
    public void TestCase8() {
        Customer customer = new Customer();
        customer.setName("Jason");
        customer.setZipCode("1192");
        BookDetails bookDetail = new BookDetails();
        bookDetail.setLanguage("English");

        bookDetail.setYear(1972);

        Book book = new Book();
        book.setBookDetails(bookDetail);
        customers.add(customer);
        books.add(book);

        boolean result = conditions();
        if(result==true){

            System.out.println("Test Case8 Record  Condition True");
        }else{

            System.out.println("Test Case8 Record Condition False");
        }

        customers.clear();
        books.clear();

    }


}
