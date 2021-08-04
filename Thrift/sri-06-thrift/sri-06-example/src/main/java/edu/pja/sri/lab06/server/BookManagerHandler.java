package edu.pja.sri.lab06.server;


import java.util.ArrayList;
import java.util.List;

import edu.pja.sri.lab06.BookManager;
import edu.pja.sri.lab06.Book;
import org.apache.thrift.TException;

public class BookManagerHandler implements BookManager.Iface {


    @Override
    public List<Book> getBooks() throws TException {
        List<Book> myList = new ArrayList();

        Book b1 = new Book("title1", "author1", "genre1", 10, 15.0);
        Book b2 = new Book("title2", "author2", "genre2", 15, 25.0);
        Book b3 = new Book("title3", "author3", "genre2", 22, 10.0);
        myList.add(b1);
        myList.add(b2);
        myList.add(b3);

        return myList;
    }

    @Override
    public List<Book> discountBooks(List<Book> books, double discount){
        List<Book> modifiedList = books;
//        modifiedList = books;
        for (Book book: books) {
            book.price = book.price * discount;
        }
        return modifiedList;
    }

    @Override
    public List<Book> listBooks(List<Book> books){
        return books;
    }

//    @Override
//    public List<String> listTitlesFromGenre(List<Book> books, String genre) throws TException {
//        List<String> myTitles = new ArrayList();
//
//        for (Book book: books) {
//            if(book.genre.equals(genre) ){
//                myTitles.add(book.title);
//            }
//        }
//        return myTitles;
//    }
//
//    @Override
//    public double sumPrices(List<Book> books){
//        double sum = 0.0;
//        for (Book book: books) {
//            sum += book.price;
//        }
//        return sum;
//    }

}
