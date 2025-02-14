package liskov;

public class Main {

    public static void main(String[] args) {
        Penguin penguin1 = new Penguin();

        try {
            penguin1.move();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
