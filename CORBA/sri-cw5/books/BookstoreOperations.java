
/**
* BookstoreOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Bookstore.idl
* Wednesday, 2 June 2021 14:19:51 o'clock CEST
*/

public interface BookstoreOperations 
{
  Book[] bookList ();
  void bookList (Book[] newBookList);
  String[] bookTitlesList ();
  void bookTitlesList (String[] newBookTitlesList);
  double sum ();
  void sum (double newSum);
  double discount ();
  void discount (double newDiscount);
  void discountPrices ();
  void sumPrices ();
  void listTitlesFromGenre (String genre);
} // interface BookstoreOperations
