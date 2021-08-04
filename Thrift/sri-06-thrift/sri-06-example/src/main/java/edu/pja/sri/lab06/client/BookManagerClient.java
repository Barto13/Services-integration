package edu.pja.sri.lab06.client;

import edu.pja.sri.lab06.Book;
import edu.pja.sri.lab06.BookManager;
import edu.pja.sri.lab06.BookManager_2;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.List;

public class BookManagerClient {
    public static void main(String [] args) {
        try {
            TTransport transport;

            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new  TBinaryProtocol(transport);

            //

            TMultiplexedProtocol BM_1 = new TMultiplexedProtocol(protocol, "BookManagerService1");

            TMultiplexedProtocol BM_2 = new TMultiplexedProtocol(protocol, "BookManagerService2");
            //
            BookManager.Client bookManagerclient = new BookManager.Client(BM_1);

            BookManager_2.Client bookManagerclient_2 = new BookManager_2.Client(BM_2);

            perform(bookManagerclient, bookManagerclient_2);

            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    private static void perform(BookManager.Client bookManagerclient, BookManager_2.Client bookManagerclient_2) throws TException {

        List<Book> allBooks = bookManagerclient.getBooks();
        System.out.println("Books before discount: " + allBooks);
//        System.out.println("List: " + bookManagerclient.listBooks(allBooks));

        Double SumOfPrices = bookManagerclient_2.sumPrices(allBooks);
        System.out.println("Sum of prices before discount: " + SumOfPrices);

        List<Book> modifiedBooks = bookManagerclient.discountBooks(allBooks, 0.8);
        System.out.println("Books after discount: " + modifiedBooks);
//        System.out.println("List: " + bookManagerclient.listBooks(modifiedBooks));

        SumOfPrices = bookManagerclient_2.sumPrices(modifiedBooks);
        System.out.println("Sum of prices after discount: " + SumOfPrices);

        List<String> myTitles = bookManagerclient_2.listTitlesFromGenre(modifiedBooks, "genre2");
        System.out.println("Titles of books from genre = genre2: " + myTitles);
    }
}
