package Model;

import java.awt.*;

import static java.lang.System.out;

/**
 * Methods for the Model.Truck4Cars class which extends the Model.CarTransport class.
 */
public class Truck4Cars extends CarTransport{

    /**
     * Constructor for the Model.Truck4Cars class.
     *
     */
    public Truck4Cars() {
        super(500, Color.CYAN, "Model X", 20, 3000);
    }

    /**
     * Unloads the cars for the truck if the ramp is down. There is a parameter for setting how many cars
     * to unload.
     * @param nCars2unload
     */
    public void unloadCars(int nCars2unload){
        if (!getRamp().isRampUp()) {
            int length = getCarsLoaded().size();
            if (nCars2unload > length || nCars2unload < 0) {
                nCars2unload = length;
            }
            for (int i = length - 1; i >= length - nCars2unload; i--) {
                getCarsLoaded().get(i).setPosition(new Point(getPosition().x + 1, getPosition().y));
                out.println(getCarsLoaded().get(i));
                getCarsLoaded().remove(i);
            }
        }
    }
}
