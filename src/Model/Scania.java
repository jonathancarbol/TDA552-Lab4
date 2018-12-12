package Model;

import Model.Ramp.FlatBed;

import java.awt.*;

public class Scania extends Transport {

    /**
     * Contructor for Model.Scania which sets the engine power to 80, the color to magenta and the model name.
     */
    public Scania() {
        super(80, Color.MAGENTA, "ScaniaGSleeper", new FlatBed());
    }
}
