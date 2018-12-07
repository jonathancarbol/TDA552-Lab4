package Model;

import java.awt.*;

/**
 * Methods for the Model.Transport class which extends the Model.Vessel class.
 */
public class Transport extends Vessel{

    private Ramp ramp;

    /**
     * Constructor for the Model.Transport class.
     * @param enginePower
     * @param color
     * @param modelName
     */
    public Transport(double enginePower, Color color, String modelName, Ramp ramp) {
        super(enginePower, color, modelName);
        this.ramp = ramp;
    }


    public Ramp getRamp() {
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
        if (ramp.isRampUp()){
            setCurrentSpeed(0.1);
        }
    }

   /* /**
     * Checks whether or not the ramp of the transport is up or down.
     * @return rampUp
     */
   /*
    public boolean isRampUp() {
        return rampUp;
    }

    /**
     * Sets the ramp/bed of transport to up or down.
     * @param rampUp
     */
    /*public void setRampUp(boolean rampUp) {
        this.rampUp = rampUp;
    }*/

}
