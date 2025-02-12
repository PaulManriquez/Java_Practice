public class FirstThread extends Thread {
    int sleepTime;
    static  int place = 1;//cannot be called as this, since it belong to all the instances

    //              CONSTRUCTOR
    public FirstThread(String id){

        super(id);//Parent constructor from Thread
        this.sleepTime = (int) (Math.random() * 3000); //Get a sleep time random
        System.out.println("Name: " + getName()
                        +"\nSleeping Time: " + this.sleepTime + "\n");//Get Thread name
    }

    //Run method contains the code that the thread will execute
    public void run(){
        try{
            sleep(this.sleepTime);//Sleep for a random period of time
        }catch(InterruptedException interruptedException){
            System.out.println("interruptedException :" +
                    interruptedException.toString());
        }
        System.out.println("Thread number " + getName() + " place : "+ place++);// Task ended

    }
}
