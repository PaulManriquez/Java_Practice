package UsingMathPackage;
import java.util.Random;

public class testingMathPackage {

    public static void main(String []args){

        long seed = System.currentTimeMillis(); // Get the current time in mills
        Random myRand = new Random(seed);

        System.out.println("Random: "+ myRand.nextInt(10));//0 to 9
        System.out.println("Random: "+ (myRand.nextInt(10) + 1) ); // 1 to 10
        System.out.println("Random: "+ myRand.nextFloat(10));//Float
        System.out.println("Random: "+ myRand.nextBoolean());//Boolean

        //===
        int myAbs = (int) Math.abs(myRand.nextFloat(918231.231F));
        System.out.println("Abs using math and random library: "+ myAbs );
        //
        System.err.println("Error!");
    }

}
