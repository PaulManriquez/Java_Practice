public class Main {
    public static void main(String[] args) {

        //         THREAD OBJECTS
        FirstThread Th1,Th2,Th3,Th4,Th5;

        Th1 = new FirstThread("1");
        Th2 = new FirstThread("2");
        Th3 = new FirstThread("3");
        Th4 = new FirstThread("4");
        Th5 = new FirstThread("5");

        //start method (prepares the track "thread")
        Th1.start(); // -> RUN(); // Execute (run in the track "execute the thread")
        Th2.start();
        Th3.start();
        Th4.start();
        Th5.start();

        //RUNNABLE
        System.out.println("\n===RUNNAMBLE====\n");
        SecondThread threads2 = new SecondThread();
        threads2.start();
    }
}