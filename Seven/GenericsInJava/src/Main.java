import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Float [] decimals = new Float[] {9.0f,2.1f,4.22f,7.12f,5.0f};

        ArrayList<Float> getList_floats = convertToGeneric(decimals);
        System.out.println(getList_floats);
        System.out.println("decimals.toString() = " + decimals.toString());
        System.out.println("decimals.toString() = " + Arrays.toString(decimals));

    }

    //Arraylist Generic
    public static <T>ArrayList<T> convertToGeneric(T [] array){
        ArrayList<T> myList = new ArrayList<>();

        for( T number: array){
            myList.add(number);
        }

        return myList;
    }
}