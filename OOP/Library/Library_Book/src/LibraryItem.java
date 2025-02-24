public abstract class LibraryItem {
    //Protected means that is only allowed inside the package
    protected  String isbn;
    protected  String name;
    protected  static int itemNumber = 0;

    protected boolean borrowed;

    //============= Constructor
    public LibraryItem(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
        this.borrowed = false;
        itemNumber++;
    }
    //=============

    // Methods
    public String getIsbn(){return this.isbn;}
    public String getName(){return this.name;}
    public void getDescription(){}

}
