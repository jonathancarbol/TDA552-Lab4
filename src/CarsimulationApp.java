import Model.*;

import java.util.ArrayList;

public class CarsimulationApp {
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        ArrayList<Vessel> cars = new ArrayList<>();
        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());

        // Add a world
        cc.world = new World(800, 560, cars);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc, cc.world.getSizeX(), cc.world.getSizeY());


        // Start the timer
        cc.startTimer();
    }
}
