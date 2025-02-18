import java.util.LinkedList;
import java.util.Queue;

public class BarberShops {

    public static final int NUM_BARBER_SHOPS = 3;

    public static final int NUM_CUSTOMERS = 10;

    //      Queue is just a (conventional behavioral name) but in deed is a linked list
    private Queue<Customer>  queueCustomers = new LinkedList<>();

    //common technique in multithreading to ensure
    //only one thread can execute a block of code at a time
    Object lock = new Object(); //Shared object
    //-------------------------

    private Thread [] barberShops_Thread;

    //========== Method =======================
    public void addCustomer(Customer customer){
        synchronized (lock){//Using synchronized(lock) ensures that only one thread
                            // can access the queue at a time | Ensures only one thread modifies queueCustomers at a time.
            queueCustomers.offer(customer);//Add a customer to the queue
            lock.notify();
        }
    }
    //==========================================

    public Customer getCustomer() throws InterruptedException{
        synchronized (lock){
            while (queueCustomers.isEmpty()){
                lock.wait();
            }
            return queueCustomers.poll();//pop
        }

    }

}
