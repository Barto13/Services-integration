
/**
* Book.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Bookstore.idl
* Wednesday, 2 June 2021 14:19:51 o'clock CEST
*/

public final class Book implements org.omg.CORBA.portable.IDLEntity
{
  public String title = null;
  public String author = null;
  public String genre = null;
  public int publicationYear = (int)0;
  public double price = (double)0;

  public Book ()
  {
  } // ctor

  public Book (String _title, String _author, String _genre, int _publicationYear, double _price)
  {
    title = _title;
    author = _author;
    genre = _genre;
    publicationYear = _publicationYear;
    price = _price;
  } // ctor

} // class Book