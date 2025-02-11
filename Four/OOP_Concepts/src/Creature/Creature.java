package Creature;

//INTERFACES (Defines a contract that classes must follow)
interface Animal{
    void makeSound();
}

//BASE CLASS
public class Creature {
    // Access Modifiers
    public String name = "Unknown";//Accessible from anywhere
    private int age = 0; // Only accessible within the class
    protected  String type = "Creature"; // Accessible in subclasses
    //                Protected
    //1) The class itself (where it's defined).
    //2) Subclasses (child classes) that extend the class
    //                          (even if they are in a different package).
    //3) Classes in the same package (even if they don’t extend the class)

    String environment = "Earth"; // Default (package-private):
                                 // Accessible within the same package

    // Constructor
    public Creature(String name,int age){
        this.name = name;
        this.age = age;
    }

    //********************************************************************
    //                          Overloaded Method
    //                         (Different parameters)
    //********************************************************************
    public void showInfo(){
        System.out.println("Name: " + this.name + "\n Age: " + this.age);
    }

    public void showInfo(String message){
        System.out.println(message + " \n" +
                           "Name: " + this.name + "\n Age: " + this.age );
    }
    //*********************************************************************

     //*********************************************************************
    //                          Getters and setters
   //***********************************************************************

    //Name
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Age
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Age
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Environment
    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    //***********************************************************************

    //***********************************************************************
    //                          Methods to be overriden
    //***********************************************************************
    public void move(){
        System.out.println("This creature moves");
    }

}
