namespace java edu.pja.sri.lab06

struct Book {
    1: required string title;
    2: required string author;
    3: required string genre;
    4: required i32 publicationYear;
    5: required double price;
}

exception BookUnvailable {
    1: string message
}

service BookManager {
    list<Book> getBooks()
    list<Book> discountBooks(list<Book> books, double discount)
    list<Book> listBooks(list<Book> books)

}

service BookManager_2 {
    list<string> listTitlesFromGenre(list<Book> books, string genre)
    double sumPrices(list<Book> books)
}

