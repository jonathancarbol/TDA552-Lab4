package Model.Tests;

import Model.CarTransport;
import Model.Ferry;
import Model.Saab95;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Test methods for the Model.CarTransport class.
 */
public class CarTransportTest {

    CarTransport c = new Ferry();

    @Test
    public void loadCar() {
        Saab95 s = new Saab95();
        c.getRamp().setRampUp(false);
        c.loadCar(s);
        assertEquals(s,c.getCarsLoaded().get(0));
    }

    @Test
    public void move() {
        Saab95 s = new Saab95();
        c.getRamp().setRampUp(false);
        c.loadCar(s);

        c.getRamp().setRampUp(true);
        c.startEngine();
        c.gas(0.9);
        assertEquals(0,c.getPosition().y);
        assertEquals(0,c.getPosition().x);
        c.move();
        assertEquals(2,c.getPosition().x);
        assertEquals(0,c.getPosition().y);
    }

}