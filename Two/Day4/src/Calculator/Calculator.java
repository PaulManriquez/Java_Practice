package Calculator;

import java.util.Scanner;

public class Calculator {

    Scanner input_user = new Scanner((System.in));
    int n1,n2;

    public int addition(){
        System.out.println("Number 1:");
        this.n1 = input_user.nextInt();
        System.out.println("Number 2:");
        this.n2 = input_user.nextInt();
        return  n1+n2;
    }

    public int subtrtaction(){
        System.out.println("Number 1:");
        this.n1 = input_user.nextInt();
        System.out.println("Number 2:");
        this.n2 = input_user.nextInt();
        return n1 - n2;
    }

    public int multiply(){
        System.out.println("Number 1:");
        this.n1 = input_user.nextInt();
        System.out.println("Number 2:");
        this.n2 = input_user.nextInt();
        return n1 * n2;
    }

    public int division(){
        System.out.println("Number 1:");
        this.n1 = input_user.nextInt();
        System.out.println("Number 2:");
        this.n2 = input_user.nextInt();
        return n1 / n2;
    }
}
