//import BookstorePackage.Book;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Client {

    public static void main(String[] args) throws IOException, InvalidName, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound {

        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

        //usluga nazwowa
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContext ncRef = NamingContextHelper.narrow(objRef);
        NameComponent nc = new NameComponent("Arytmetyka", "");
        NameComponent path[] = {nc};

        org.omg.CORBA.Object objRef1 = orb.resolve_initial_references("NameService");
        NamingContext ncRef1 = NamingContextHelper.narrow(objRef1);
        NameComponent nc1 = new NameComponent("Bookstore", "");
        NameComponent path1[] = {nc1};

        Bookstore proxy1 = BookstoreHelper.narrow(ncRef1.resolve(path1));

        //sample data
        Book book1 = new Book("title1", "author1", "genre1", 10, 15.0);
        Book book2 = new Book("title2", "author2", "genre2", 15, 25.0);
        Book book3 = new Book("title3", "author3", "genre2", 22, 10.0);
        Book[] newBookList = new Book[]{book1, book2, book3};

        proxy1.bookList(newBookList);
//        System.out.println(proxy1.bookList());

        //sum prices of books
        proxy1.sumPrices();
        System.out.println("Sum of prices before discount: " + proxy1.sum());

        //discount prices of books
        proxy1.discount(0.8);
        proxy1.discountPrices();

        //again sum prices of books
        proxy1.sumPrices();
        System.out.println("Sum of prices after discount: " + proxy1.sum());

        //print titles of books from chosen genre
        proxy1.listTitlesFromGenre("genre2");
        System.out.println(Arrays.toString(proxy1.bookTitlesList()));

//        FileReader fr = new FileReader("ref.ior");
//        BufferedReader br = new BufferedReader(fr);
//        String ior = br.readLine();

//        org.omg.CORBA.Object obj = orb.string_to_object(ior);
//        Arytmetyka proxy = ArytmetykaHelper.narrow(obj);
//        Arytmetyka proxy = ArytmetykaHelper.narrow(ncRef.resolve(path));
//
//        proxy.s1(1);
//        proxy.s2(2);
//        proxy.suma();
//        System.out.println(proxy.wynik());
    }
}
