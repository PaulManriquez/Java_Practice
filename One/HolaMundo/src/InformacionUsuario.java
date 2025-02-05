import java.util.Scanner;

public class InformacionUsuario {

    public static void main(String []args){
        String userName,surName;
        int age;

        Scanner Scan = new Scanner(System.in);

        System.out.println("Enter your name:");
        userName = Scan.nextLine();
        System.out.println("Enter your sourname:");
        surName = Scan.nextLine();
        System.out.println("Enter your age:");
        age = Scan.nextInt();

        System.out.println("Hello "+ userName + " " + surName + " your age is " +age);
    }
}
