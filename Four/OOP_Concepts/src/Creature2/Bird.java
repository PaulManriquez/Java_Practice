package Creature2;

//                      COMMON CLASS
public class Bird extends Creature2 implements CanFly{

    //Constructor
    public Bird(String name, int age){
        super(name,age);
    }

//    public Bird(){
//        super("defaultBird",0);
//    }

    // Constructor without super()
    public Bird() {
        this.name = "Bird without super";  // Now works because of default constructor
        this.age  = 1;
    }


    //Abstract method from Creature2
    @Override
    public void makeSound(){
        System.out.println(this.name + " tweet tweet!");
    }

    //Implement Interface method
    @Override
    public  void fly(){
        System.out.println(this.name + " is flying");
    }
}
