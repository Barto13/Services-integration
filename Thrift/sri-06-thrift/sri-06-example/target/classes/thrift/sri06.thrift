namespace java edu.pja.sri.lab06

struct Product {
    1: required i32 id;
    2: required string name;
    3: required double price;
    4: required i32 inStock;
}

exception ProductUnvailable {
    1: string message
}

service ProductManager {
    list<Product> getProducts()
}

