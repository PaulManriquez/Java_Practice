public class SecondThread  implements Runnable{

    Thread th1,th2,th3;

    //When the method start, is called, create three instances of threads and runs
    public void start(){
        th1 = new Thread(this, "Thread 1 |m|");
        th2 = new Thread(this, "Thread 2 |m|");
        th3 = new Thread(this, "Thread 3 |m|");

        th1.start();
        th2.start();
        th3.start();
    }

    @Override
    public  void run(){
        String nameThread;

        nameThread = Thread.currentThread().getName();

        if(nameThread.equals("Thread 1 |m|")){
            System.out.println("Thread 1 |m|");
        }else if(nameThread.equals("Thread 2 |m|")){
            System.out.println("Thread 2 |m|");
        }else if (nameThread.equals("Thread 3 |m|")){
            System.out.println("Thread 3 |m|");
        }else{
            System.out.println("ERROR RUNNING");
        }

    }

}
