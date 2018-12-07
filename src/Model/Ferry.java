package Model;

import java.awt.*;

import static java.lang.Math.abs;

/**
 * Methods for the Model.Ferry class that extends the Model.CarTransport class.
 */
public class Ferry extends CarTransport {
    /**
     * Constructor for the Model.Ferry Class.
     * @param enginePower
     * @param color
     * @param modelName
     * @param maxCars
     * @param maxWeightCar
     */

    public Ferry(double enginePower, Color color, String modelName, int maxCars, int maxWeightCar) {
        super(enginePower, color, modelName, maxCars, maxWeightCar);
    }

    /**
     * Unloads the cars from the car transport. You can set how many cars you want to unload.
     * @param nCars2unload
     */
    public void unloadCars(int nCars2unload){
        int count = 0;
        while (getCarsLoaded().size() > 0 && count < abs(nCars2unload)) {
            getCarsLoaded().get(0).setPosition(new Point (getPosition().x+1,getPosition().y));
            getCarsLoaded().remove(0);
            count++;
        }
    }
}
