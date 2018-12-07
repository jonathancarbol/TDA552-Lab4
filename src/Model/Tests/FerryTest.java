package Model.Tests;

import Model.Ferry;
import Model.Saab95;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Test methods for the Model.Ferry class.
 */
public class FerryTest {

    Ferry f = new Ferry(1000, Color.BLACK, "Model.Tests.FerryTest", 20, 3000);

    @Test
    public void unloadCars() {

        Saab95 s1 = new Saab95();
        Saab95 s2 = new Saab95();
        Saab95 s3 = new Saab95();
        f.getRamp().setRampUp(false);
        f.loadCar(s1);
        f.loadCar(s2);
        f.loadCar(s3);

        f.unloadCars(2);
        assertEquals(s3,f.getCarsLoaded().get(f.getCarsLoaded().size()-1));

        f.unloadCars(3);
        assertTrue( f.getCarsLoaded().isEmpty());
    }
}