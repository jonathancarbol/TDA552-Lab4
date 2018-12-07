package Model.Tests;

import Model.Saab95;
import Model.Truck4Cars;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Test methods for the Model.Truck4Cars class.
 */
public class Truck4CarsTest {

    Truck4Cars t = new Truck4Cars(100, Color.BLACK,"TestTruck4Cars",6,3000);

    @Test
    public void unloadCars() {
        Saab95 s1 = new Saab95();
        Saab95 s2 = new Saab95();
        Saab95 s3 = new Saab95();
        t.getRamp().setRampUp(false);
        t.loadCar(s1);
        t.loadCar(s2);
        t.loadCar(s3);
        t.getRamp().setRampUp(true);
        t.unloadCars(2);
        assertEquals(s3,t.getCarsLoaded().get(t.getCarsLoaded().size()-1));

        t.getRamp().setRampUp(false);
        t.unloadCars(2);
        assertEquals(s1,t.getCarsLoaded().get(t.getCarsLoaded().size()-1));
        assertEquals(new Point(1,0),s2.getPosition());

        t.unloadCars(5);
        assertTrue( t.getCarsLoaded().isEmpty());
    }
}