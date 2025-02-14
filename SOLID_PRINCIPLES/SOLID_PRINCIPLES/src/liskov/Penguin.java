package liskov;

public class Penguin extends  Bird{

    public void move() throws Exception{
        //this.volar() //The pinguins do not fly
        throw new Exception("Penguin do not fly");
    }
}
