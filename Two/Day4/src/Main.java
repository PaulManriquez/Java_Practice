//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        for (int i = 1; i <= 5; i++) {
//            if (i == 3) continue;
//            System.out.println("i = " + i);
//        }

        Persona p1 = new Persona(22,"Alfredo","Straight");
        Persona p2 = new Persona(10,"Child","Male");

        System.out.println("Name of p1 = " + p1.getName());
        System.out.println("Age of p1 = " + p1.getAge());
        System.out.println("Genre of p1 = " + p1.getGenre());

        p1.setName("Paul");
        System.out.println("New name of p1 = " + p1.getName());

        //Is this person an adult?
        System.out.println("Is this person an adult? : " + p1.isAdult(p2));
    }
}