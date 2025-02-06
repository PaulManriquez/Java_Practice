import  Calculator.Calculator;
import java.util.Scanner;

public class Main {

    private static void displayMenu(){
        System.out.println("Select operation:");
        System.out.print(" + ");
        System.out.print(" - ");
        System.out.print(" * ");
        System.out.println(" / ");
        System.out.print(" : ");
    }
    private static String ask_user_continue(Scanner input_user){
        System.out.println("Continue? Y or N :");
        String response = input_user.nextLine().trim();
        return response;
    }

    private static void performOperation(Scanner input_user, Calculator mycalculator){
        int ans=0;
        String operation = input_user.nextLine();

        switch (operation){
            case "+":
                System.out.println("Adition:");
                System.out.println("Ans:" + mycalculator.addition());
                break;

            case "-":
                System.out.println("Subtraction:");
                ans = mycalculator.subtrtaction();
                System.out.println("Ans:"+ans);
                break;

            case "*":
                System.out.println("Multiply:");
                ans = mycalculator.multiply();
                System.out.println("Ans:"+ans);
                break;

            case "/":
                System.out.println("Division:");
                ans = mycalculator.division();
                System.out.println("Ans:"+ans);
                break;
            default:
                System.out.println("Operation not valid");
                break;
        }//SWITCH ENDS
    }

    //================ MAIN =========================
    public static void main(String[] args) {

        //====== Variables
        String user_continue_ans="";
        //======

        //=============== Objects ===================
        Scanner input_user = new Scanner((System.in));
        Calculator mycalculator = new Calculator();
        //===========================================

        do{
            //
            displayMenu();//Display a menu
            // reference to an object previously created
            // reference to a object instance created
            performOperation(input_user,mycalculator);
            //
            user_continue_ans = ask_user_continue(input_user);

        }while (user_continue_ans.equals("Y"));

        System.out.println("Calculating process has finished ");
        input_user.close();
    }
}



//      //1ST TEST
//        for (int i = 1; i <= 5; i++) {
//            if (i == 3) continue;
//            System.out.println("i = " + i);
//        }

//SECOND TEST
//        Persona p1 = new Persona(22,"Alfredo","Straight");
//        Persona p2 = new Persona(10,"Child","Male");
//
//        System.out.println("Name of p1 = " + p1.getName());
//        System.out.println("Age of p1 = " + p1.getAge());
//        System.out.println("Genre of p1 = " + p1.getGenre());
//
//        p1.setName("Paul");
//        System.out.println("New name of p1 = " + p1.getName());
//
//        //Is this person an adult?
//        System.out.println("Is this person an adult? : " + p1.isAdult(p2));