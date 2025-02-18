public class HiloThread2Runnable implements Runnable {
    private String name;

    public HiloThread2Runnable(String name) {
        this.name = name; // Store the thread name manually
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Thread : " + Thread.currentThread().getId() + '|' +
                    i + '|' + name);

            try {
                Thread.sleep(2000); // Sleeping 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Error in thread : " + Thread.currentThread());
            }
        }
    }

    public static void main(String[] args) {
        // Create instances of HiloThread2Runnable
        HiloThread2Runnable task1 = new HiloThread2Runnable("FK 1R");
        HiloThread2Runnable task2 = new HiloThread2Runnable("FK 2R");

        // Create threads and start them
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
