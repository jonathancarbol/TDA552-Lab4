package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * The Model.CarTransport class which extends the Model.Transport class, and adds methods for loading cars and moving them
 * along with the car transport.
 */
public abstract class CarTransport extends Transport {

    private int maxCars;
    private int maxWeightCar;
    private List<Car> carsLoaded;

    /**
     * Constructor for the Model.CarTransport.
     * @param enginePower
     * @param color
     * @param modelName
     * @param maxCars
     * @param maxWeightCar
     */
    public CarTransport(double enginePower, Color color, String modelName, int maxCars, int maxWeightCar) {
        super(enginePower, color, modelName, new Ramp());
        this.maxCars = maxCars;
        this.maxWeightCar = maxWeightCar;
        carsLoaded = new ArrayList<>();
    }

    /**
     * Loads a car on the car transport. The car needs to be close to the transport and the ramp must be down.
     * There is also a weight limit for each car as well as a maximum amount of cars.
     * @param c
     */
    public void loadCar(Car c) {
        if (abs(c.getPosition().x -getPosition().x) < 2 && abs(c.getPosition().y - getPosition().y) < 2 ){
            if(getCarsLoaded().size() < maxCars && c.getWeight() < maxWeightCar && !getRamp().isRampUp()) {
                carsLoaded.add(c);
            }
        }
    }

    /**
     * Returns the list of cars loaded unto the car transport.
     * @return carsLoaded
     */
    public List<Car> getCarsLoaded() {
        return carsLoaded;
    }

    @Override
    public void move() {
        //getPosition().x = (int) (getCurrentSpeed() * getDirection()[0] + 0.5) + getPosition().x;
        //getPosition().y = (int) (getCurrentSpeed() * getDirection()[1] + 0.5) + getPosition().y;
        super.move();
        for (int i = 0; i < getCarsLoaded().size(); i++){
            getCarsLoaded().get(i).setPosition(getPosition());
        }
    }
}
