package edu.pja.sri.lab06.server;


import java.util.ArrayList;
import java.util.List;

import edu.pja.sri.lab06.BookManager;
import edu.pja.sri.lab06.Book;
import edu.pja.sri.lab06.BookManager_2;
import org.apache.thrift.TException;

public class BookManagerHandler_2 implements BookManager_2.Iface {



    @Override
    public List<String> listTitlesFromGenre(List<Book> books, String genre) throws TException {
        List<String> myTitles = new ArrayList();

        for (Book book: books) {
            if(book.genre.equals(genre) ){
                myTitles.add(book.title);
            }
        }
        return myTitles;
    }

    @Override
    public double sumPrices(List<Book> books){
        double sum = 0.0;
        for (Book book: books) {
            sum += book.price;
        }
        return sum;
    }

}
