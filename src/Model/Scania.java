package Model;

import Model.Ramp.FlatBed;

import java.awt.*;

public class Scania extends Transport {

    //private int flatBedAngle;


    /**
     * Contructor for Model.Scania which sets the engine power to 80, the color to magenta and the model name.
     */
    public Scania() {
        super(80, Color.MAGENTA, "ScaniaGSleeper", new FlatBed());
        //this.flatBedAngle = 0;
    }


    /**
     * Sets the flat bed angle of the Model.Scania if the current speed is zero.
     * @param angle
     */
/*
    public void setFlatBedAngle(int angle){
        if(angle >= 0 && angle <= 70) {
            if (getCurrentSpeed() == 0) {
                flatBedAngle = angle;
                if(flatBedAngle == 0) {
                    getRamp().setRampUp(true);
                }else{
                    getRamp().setRampUp(false);
                }
            }
        }
    }*/

/*
    /**
     * Returns the current angle of the flat bed.
     * @return flatBedAngle

    public int getFlatBedAngle() {
        return getFlatBed().getFlatBedAngle();
    }*/
}
