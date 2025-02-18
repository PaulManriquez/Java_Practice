import java.util.LinkedList;
import java.util.Queue;

public class BarberShop {

    public static final int NUM_BARBER_SHOPS = 3;

    public static final int NUM_CUSTOMERS = 10;

    private Queue<Customer>  queueCustomers = new LinkedList<>();

    Object lock = new Object();

    private Thread [] barberShops_Thread;

    //========== Method =======================
    public void addCustomer(Customer customer){
        synchronized (lock){
            queueCustomers.offer(customer);
            lock.notify();
        }
    }
    //==========================================

}
