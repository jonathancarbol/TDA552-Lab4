package Model;

import java.awt.*;

/**
 * The Model.Car class implements methods for handling different car types
 * and car operations. It implements a Model.Movable interface.
 *
 * @author Jonathan Carbol
 * @version 1.0
 * @since 2018-11-08
 */

public abstract class Car extends Vessel {

    private int nrDoors; // Number of doors on the car
    private final int weight;

    public Car(double enginePower, Color color, String modelName, int nrDoors, int weight) {
        super(enginePower, color, modelName);
        this.nrDoors = nrDoors;
        this.weight = weight;
    }


    /**
     * Checks to see how many doors the car has.
     * @return nrDoors
     */
    public int getNrDoors() {
        return nrDoors;
    }


    /**
     * Checks the weight of the car.
     * @return weight
     */
    public int getWeight(){ return weight; }
}
