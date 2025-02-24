
public class Book extends LibraryItem implements BorrowReturn{
    // Counter for all book objects created
    private static int bookNumber = 0;
    private int nBook;
    //
    private String title;
    private int noPages;
    private String author;
    //

    // CONSTRUCTOR
    //            Overload
    public Book(String title,String author){
        super(bookNumber+"BOOKISBN"," Im a book"); //Parent class from Library item
        bookNumber++;
        this.nBook = bookNumber;
        this.title = title;
        this.noPages = 0;
        this.author = author;
    }

    public Book(String isbn){
        super(isbn,"Im a book"); //Parent class from Library item
        bookNumber++;
        this.nBook = bookNumber;
        this.title = "Unknown Title number " + bookNumber;
        this.noPages = 0;
        this.author = "Unknown Author number " + bookNumber;
    }

    public Book(String isbn,String title,String author){
        super(isbn,"Im a book"); //Parent class from Library item
        bookNumber++;
        this.nBook = bookNumber;
        this.title = title;
        this.noPages = 0;
        this.author = author;
    }

    // Methods ABSTRACT LibraryItem
    @Override
    public String getIsbn(){
        return this.isbn;
    }
    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void getDescription(){
        System.out.println("This is a description for a "+ this.title + this.name);
    }

    // BorrowReturn INTERFACE OVERWRITE
    @Override
    public void borrowIt(){
        if(!this.borrowed){
            System.out.println("The " + this.name + this.title +" has been borrowed");
            this.borrowed = true;
        }else{
            System.out.println("The " + this.name + this.title +" was already borrowed");
        }
    }

    @Override
    public void returnIt(){
        if(this.borrowed){
            System.out.println("The " + this.name + this.title +" has been returned");
            this.borrowed = false;
        }else{
            System.out.println("The " + this.name + this.title +" was already returned");
        }
    }
    @Override
    public  boolean isBorrowed(){
        return this.borrowed;
    }

    public String isBorrowed(String message){
        return message + this.title;
    }

}
