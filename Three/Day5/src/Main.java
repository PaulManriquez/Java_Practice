
public class Main {

    public static void main(String[] args) {
        execution_time();
    }

    private  static void execution_time(){
        long startTime = System.nanoTime();

        for(int i=0; i <= 1_000_000;i++){
            int x = i * 2 ;
        }

        long endTime = System.nanoTime();
        System.out.println("Total execution time: " + (endTime - startTime) + "ns");

    }
}