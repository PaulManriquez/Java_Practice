package Open_Close;

public class Main {

    //Main
    public static void main(String[] args) {
        //Generic calculator of areas
        CalculateArea calculatorAreas_Geometic_Figures = new CalculateArea();

        //Calculating Area for a rectangle
        Rectangle rectangle1 = new Rectangle(8.2,5.5);
        System.out.println("rectangle1 area = " + rectangle1.calculateArea());

        //Calculating area for a square
        Square square1 = new Square(2);
        System.out.println("square1 area = " + square1.calculateArea());

    }

}
