package Model.Tests;

import Model.Volvo240;
import org.junit.Test;

import static org.junit.Assert.*;

/** Different test methods with 100% coverage for Model.Volvo240 specific methods.
 * All other methods are tested in Model.Car.
 */

public class Volvo240Test {

    Volvo240 v = new Volvo240();

    @Test
    public void speedFactor() {
        assertEquals(1.25, v.speedFactor(), 0.01);
    }
}