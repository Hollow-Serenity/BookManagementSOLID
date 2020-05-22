package com.java;


//class CatalogTest { //catalog Testing class
//    static Customer customer1, customer2, customer3;    //all class 3 objects to store dummy data to test the methods
//    static Book book1, book2, book3;
//    static BookDetails bookDetails1, bookDetails2, bookDetails3;
//    static Author author1, author2, author3;
//    static ArrayList<Book> bookArrayList = new ArrayList<>();   //arrayList
//
//    @Test
//    void findBookByTitle() {   //testing method
//        String bookName = "JavaBook1";  //finding JavaBook1 in book list
//        Catalog.setBookArrayList(bookArrayList);    //set booklist in Catalog
//        Book result = Catalog.findBookByTitle(bookName);    //find bookList
//        if (result == null) {   //result null book not found
//            Assertions.assertNull(result);
//            System.out.println("Book not found!");
//        } else {
//            Assertions.assertEquals(bookName, result.getBookDetails().getTitle());  //book found
//            System.out.println("Book Found");
//        }
//    }
//
//    @Test
//    void findBookByISBN() { //testingMethod
//        long isbn = book1.getISBN();  //checking isbn
//        Catalog.setBookArrayList(bookArrayList);    //setting arrayList into Catalog
//        Book result = Catalog.findBookByISBN(isbn); //find book by isbn
//        if (result == null) {   //result null book not found
//            Assertions.assertNull(result);
//            System.out.println("Book not found!");
//        } else {    //else book found
//            Assertions.assertEquals(isbn, result.getISBN());
//            System.out.println("Book Found");
//        }
//    }
//
//    @Test
//    void loanBook() {   //loan books
//        long isbn = book1.getISBN();    //get isbn
//        long isbn2 = book2.getISBN();
//        Catalog.setBookArrayList(bookArrayList);    //set booklist
//        Assertions.assertTrue(Catalog.loanBook(customer1, isbn));   //loan book1 to customer
//        Assertions.assertTrue(Catalog.loanBook(customer1, isbn2));  //loan book 2 to customer
//        System.out.println("Total rented Books to customer 1  " + customer1.getRentedBooks().size());   //get size of loan books
//    }
//
//    @Test
//    void returnBook() {
//        long isbn = book1.getISBN();    //get isbn
//        long isbn2 = book2.getISBN();
//        Catalog.setBookArrayList(bookArrayList);    //set arrayList
//        Catalog.loanBook(customer1, isbn2); //first loan books
//        Catalog.loanBook(customer1, isbn);
//        Assertions.assertTrue(Catalog.returnBook(customer1, isbn)); //test if book return fucntion work
//        System.out.println("Book Returned");
//        System.out.println("Total rented Books to customer 1  " + customer1.getRentedBooks().size());   //get size of loan books
//    }
//
//    @BeforeAll
//    static void addDataForTest() {   //add Data for Test
//        customer1 = new Customer("javaprogrammer1@email.com", "Java1", "73929474", "Netherland St:1", "1234", "Male", "cityNetherLand1", new ArrayList<>());
//        customer2 = new Customer("javaprogrammer2@email.com", "Java2", "73929475", "Netherland St:2", "1235", "Male", "cityNetherLand2", new ArrayList<>());
//        customer3 = new Customer("javaprogrammer3@email.com", "Java3", "73929476", "Netherland St:3", "1236", "Male", "cityNetherLand3", new ArrayList<>());
//        author1 = new Author("author1@email.com", "Author1", "73926774", "Netherland1", "1237", "Male", "cityNetherLand1", 40);
//        author2 = new Author("author2@email.com", "Author2", "73926775", "Netherland2", "1238", "Male", "cityNetherLand2", 50);
//        author3 = new Author("author3@email.com", "Author3", "73926776", "Netherland3", "1239", "Male", "cityNetherLand3", 30);
//        bookDetails1 = new BookDetails("JavaBook1", author1, 2019, "www.java1.com", "English", 400, "Netherland");
//        bookDetails2 = new BookDetails("JavaBook2", author2, 2018, "www.java2.com", "English", 600, "Netherland");
//        bookDetails3 = new BookDetails("JavaBook3", author3, 2010, "www.java3.com", "English", 500, "Netherland");
//        book1 = new Book(Book.generateISBN(), bookDetails1, true);
//        book2 = new Book(Book.generateISBN(), bookDetails2, true);
//        book3 = new Book(Book.generateISBN(), bookDetails3, true);
//        bookArrayList.add(book1);
//        bookArrayList.add(book2);
//        bookArrayList.add(book3);   //this Method is used for adding demo data to test Catalog Class Methods..
//    }
//}