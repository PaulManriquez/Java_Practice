
//1) Make a class that represents a book defined by:
//   ISBN / Title / No_pages / Author / given

public class Main {
    public static void main(String[] args) {

        Book myBook1 = new Book("Kutulu","HP LoveCraft");

        System.out.println(myBook1.getIsbn());
        System.out.println(myBook1.getName());
        myBook1.getDescription();
        myBook1.borrowIt();
        myBook1.borrowIt();
        myBook1.returnIt();
        myBook1.returnIt();
        myBook1.borrowIt();
        System.out.println(myBook1.isBorrowed());
        System.out.println(myBook1.isBorrowed("This was borrowed "));

    }
}