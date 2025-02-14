package Open_Close;

//Open to extentions
//Closed to modifications
//The class implements a method that receives the corresponding Geometric Figure and
//go to the corresponding (" calculate area ") for the corresponding geometric figure.
public class CalculateArea {

    //Method for the ("Corresponding geometric figure")
    public double calculateArea(GeometricFigure myGeometricFigure){
        return myGeometricFigure.calculateArea();//Implement the corresponding interface
    }

}


// DO NOT ENABLE TO RECEIVE ANOTHER GEOMETRICS FIGURES
//public class CalculateArea {
//
//    //Method
//    public double calculateArea(Rectangle myRectangle){
//        return myRectangle.getBase() * myRectangle.getHeight();
//    }
//
//}
