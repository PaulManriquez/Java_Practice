import java.util.Random;

public class BarberShop implements  Runnable {

    private final BarberShops barber_shops;
    private final String name;

    public BarberShop(BarberShops barbershops , String name){
        this.barber_shops = barbershops;
        this.name = name;
    }

    @Override
    public void run(){
        Random random = new Random();

        try{
            while(true){
                Customer customer = BarberShops.getCustomer();
                System.out.println();
            }
        }catch (InterruptedException e){throw new RuntimeException(e);}

    }

}
