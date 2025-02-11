package Creature2;

//              INTERFACE
interface CanFly{
    void fly();//Just declared / no body
}

//             ABSTRACT CLASS
abstract class Creature2 {
    //        Atributes
    protected String name;
    protected  int age;

    //Constructor
    public Creature2(String name,int age){
        this.name = name;
        this.age = age;
    }

    // Default constructor (needed for Bird() to work without super())
    public Creature2() {
        this.name = "Unknown";
        this.age = 0;
    }

    //           Abstract method
    //Must be implemented by subclasses
    public abstract void makeSound();

    //          Concreate Method
    //      Common to all creatures
    public void showInfo(){
        System.out.println("Name: "+ this.name + "\nAge: "+ this.age);
    }
}

//A public class must be in a file with the same name as the class.
//                      COMMON CLASS
//public class Bird extends Creature2 implements CanFly{
//
//    //Constructor
//    public Bird(String name, int age){
//        super(name,age);
//    }
//
//    //Abstract method from Creature2
//    @Override
//    public void makeSound(){
//        System.out.println(this.name + " tweet tweet!");
//    }
//
//    //Implement Interface method
//    @Override
//    public  void fly(){
//        System.out.println(this.name + " is flying");
//    }
//}
