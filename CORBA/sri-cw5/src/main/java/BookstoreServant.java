import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookstoreServant extends _BookstoreImplBase{

    private Book[] bookList;
    private double sum;
    private double discount;
    private String[] bookTitlesList;
    private List<String> bookTitlesListHelp = new ArrayList<>();

    @Override
    public Book[] bookList (){
        return bookList;
    }

    @Override
    public void bookList(Book[] newBookList){
        bookList = newBookList;
    }

    @Override
    public double sum(){
        return sum;
    }

    @Override
    public void sum(double newSum){
        sum = newSum;
    }

    @Override
    public double discount (){
        return discount;
    }

    @Override
    public void discount (double newDiscount){
        discount = newDiscount;
    }

    @Override
    public String[] bookTitlesList (){
//        bookTitlesList = bookTitlesListHelp.toArray(new String[0]);
        return bookTitlesList;
    }

    @Override
    public void bookTitlesList (String[] newBookTitlesList){
        bookTitlesListHelp = Arrays.asList(newBookTitlesList);
    }

    @Override
    public void sumPrices (){
        sum = 0;
        for (Book book: bookList) {
            sum += book.price;
        }
    }

    @Override
    public void discountPrices (){
        for (Book book: bookList) {
            book.price = book.price * discount;
        }
    }

    public void listTitlesFromGenre (String genre){
        for (Book book: bookList) {
            if(book.genre.equals(genre) ){
                bookTitlesListHelp.add(book.title);
            }
        }
        bookTitlesList = bookTitlesListHelp.toArray(new String[0]);
    }

}
