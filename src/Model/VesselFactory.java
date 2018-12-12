package Model;

public class VesselFactory {

    public static Vessel createSaab95(){
        return new Saab95();
    }

    public static Vessel createVolvo240(){
        return new Volvo240();
    }

    public static Vessel createFerry(){
        return new Ferry();
    }

    public static Vessel createScania(){
        return new Scania();
    }

    public static Vessel createTruck4Cars(){
        return new Truck4Cars();
    }


}


/*public class PolygonFactory {

    public static IPolygon createTriangle(int x, int y) {
        return new Triangle(x, y);
    }

    public static IPolygon createRectangle(int x, int y) {
        return new Rectangle(x, y);
    }

    public static IPolygon createSquare(int x, int y) {
        return new Square(x, y);
    }

}*/
