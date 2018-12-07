package Model;

import java.awt.*;

/** The Model.Volvo240 is a subclass to Model.Car and excluding the methods from car implements another method
 * for speedFactor which takes into account some Model.Volvo240 specific characteristics.
 */

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    //public Model.Volvo240() {super(4, 100, Color.black, "Model.Volvo240");}


    public Volvo240() {
        super(100, Color.black, "Model.Volvo240", 4,2500);
    }

    /**
     * Calculates the Model.Volvo240 specific speedFactor.
     * @return speedFactor
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
