
public class HiloThread1 extends Thread {

    public  HiloThread1(String name){
        super(name);//Call the parent extended by the parent Thread
    }

    @Override
    public void run(){

        for(int i=0; i<= 5; i++){
            System.out.println("Thread : " + Thread.currentThread().getId() + '|' +
                    i + '|' + getName());

            try{
                Thread.sleep(2000);//Sleeping 2seconds
            }catch(InterruptedException e){
                System.out.println("Error in thread : " + Thread.currentThread());
            }

        }//END FOR
    }//END RUN METHOD


    public static void main(String[] args){
        //Objects declarations
        HiloThread1 thread1 = new HiloThread1("FK 1");
        HiloThread1 thread2 = new HiloThread1("FK 2");

        thread1.start();
        thread2.start();

    }

}
