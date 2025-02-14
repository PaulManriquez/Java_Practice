package Open_Close;

public class Square implements GeometricFigure{

    private final double base;

    //Constructor
    public Square(double base){
        this.base = base;
    }

    //GET
    public double getBase() {
        return base;
    }

    //Geometric figure
    @Override
    public double calculateArea(){
        return this.base * this.base;
    }
}
