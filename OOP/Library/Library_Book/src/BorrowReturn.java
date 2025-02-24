//The interface that is called 'borrowable' can implement methods allowing
// to borrow the object that extends this interface
public interface BorrowReturn {
    void borrowIt();//Borrow the object
    void returnIt();//Return the object
    boolean isBorrowed();//Get the state if was borrowed
}
