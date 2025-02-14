package Open_Close;

public class Rectangle implements GeometricFigure{

    private final double base;

    private final double height;

    //Constructor
    public  Rectangle(double base,double height){
        this.base = base;
        this.height = height;
    }

    //             GET
    public double getBase(){
        return this.base;
    }

    public double getHeight(){
        return this.height;
    }
    //=================================

    // Extends GeometricFigure
    @Override
    public double calculateArea(){
        return  this.base * this.height;
    }

}
