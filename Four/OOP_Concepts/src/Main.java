
import Creature.Creature;
import Creature.Dog;

public class Main {
    public static void main(String[] args) {

        Creature creature1 =  new Creature("CreatureTest",22);

        System.out.println("Age " + creature1.getAge());
        System.out.println("Environment " + creature1.getEnvironment());
        System.out.println("Name " + creature1.getName());
        System.out.println("Type " + creature1.getType());

        creature1.move();
        creature1.name = "Bob";
        System.out.println("Name " + creature1.getName());
    }
}