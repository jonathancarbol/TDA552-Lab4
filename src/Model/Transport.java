package Model;

import Model.Ramp.FlatBed;
import Model.Ramp.IRampables;

import java.awt.*;

/**
 * Methods for the Model.Transport class which extends the Model.Vessel class.
 */
public class Transport extends Vessel{

    private IRampables ramp;

    /**
     * Constructor for the Model.Transport class.
     * @param enginePower
     * @param color
     * @param modelName
     */
    public Transport(double enginePower, Color color, String modelName, IRampables ramp) {
        super(enginePower, color, modelName);
        this.ramp = ramp;
    }


    public IRampables getRamp() {
        return ramp;
    }

    public FlatBed getFlatBed() {
            return (FlatBed) ramp;
    }

    /**
     * Starts the engine, if the ramp/bed is up.
     */
    @Override
    public void startEngine(){
        if (ramp.isRampUp() && getCurrentSpeed() < 0.1){
            setCurrentSpeed(0.1);
        }
    }
}
