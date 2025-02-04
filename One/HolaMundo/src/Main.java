public class Main {

    public static void main (String [] args){
//        System.out.println("Hello " + args[0] + args[1] + args[2]);

        char symbol;
        for (int i=1; i<100;i++){
            symbol = (char) i;
            System.out.print(" " + symbol);

            if (i % 5 == 0){
                System.out.println();
            }
        }

        //Auto fill with a variable  soutv

    }
}
