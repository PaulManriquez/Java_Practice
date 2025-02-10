package Creature;

public class Dog extends Creature implements Animal{

    //********************************************
    //             Static Variables
    //      Belongs just to the class Dog
    // (others instances of this will be affected)
    static int dogCount = 0;
    //********************************************

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Private: Only accessible within the class
    //Final: Cannot be changed once initialize (CONSTANT)
    private final String species ="Canis Lupus";
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //******************************************
    //      Constructor of the dog class
    //  Implementing the parent constructor
    public Dog(String name, int age) {
        super(name, age);
    }
    //******************************************


    //*******************************************************
    //                      Implementing
    //             Override from the parent class
    //*******************************************************
    @Override
    public void move(){
        System.out.println(this.name + " runs in four legs");
    }

    //*******************************************************
    //                      Implementing
    //                    Interface Method
    //*******************************************************
    @Override
    public void makeSound() {
        System.out.println(this.name + " barks: woof woof!");
    }

    //*******************************************************
    //                      Implementing
    //       Static Method (belongs to class, NOT INSTANCES)
    //*******************************************************
    public static void showDogCount(){
        System.out.println("Total dogs created: "+ dogCount);
    }
    //NOTE: Since dogCount (IS STATIC), cannot be referred as "this."
    //      since this. : is being used to refer to this class instance
    //      and STATIC, is referring to all objects generates by this class
    //      belongs to the class

    //*******************************************************
    //                      Implementing
    //       Final Method (cannot be overriden)
    //*******************************************************
    public final void showSpecies(){
        System.out.println("Species: " + this.species);
    }

}
