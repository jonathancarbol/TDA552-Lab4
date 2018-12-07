package Model.Tests;

import Model.Saab95;
import org.junit.Test;

import static org.junit.Assert.*;

/** Different test methods with 100% coverage for Model.Saab95 specific methods.
 * All other methods are tested in Model.Car.
 */

public class Saab95Test {


    Saab95 s = new Saab95();

    @Test
    public void setTurboOn() {
        s.setTurboOn();
        assertEquals(true, s.isTurboOn());
    }

    @Test
    public void setTurboOff() {
        s.setTurboOff();
        assertEquals(false, s.isTurboOn());
    }

    @Test
    public void speedFactor() {
        s.setTurboOff();
        double t = s.speedFactor();
        assertEquals(1.25, t,0.01);

        s.setTurboOn();
        double p = s.speedFactor();
        assertEquals(1.625, p, 0.01);
    }

    @Test
    public void isTurboOn() {
        assertEquals(false, s.isTurboOn());
    }
}