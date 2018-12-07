package Model.Tests;

import Model.Vessel;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Test methods for the Model.Vessel class.
 */
public class VesselTest {

    Vessel v = new Vessel(100, Color.RED, "TestVessel") {
    };

    @org.junit.Test
    public void getEnginePower() {
        assertEquals(100, v.getEnginePower(),0.01);
    }

    @org.junit.Test
    public void getCurrentSpeed() {
        assertEquals(0, v.getCurrentSpeed(), 0.01);
    }

    @org.junit.Test
    public void getColor() {
        assertEquals(Color.RED, v.getColor());
    }

    @org.junit.Test
    public void setColor() {
        v.setColor(Color.BLUE);
        assertEquals(Color.BLUE, v.getColor());
    }

    @org.junit.Test
    public void startEngine() {
        v.startEngine();
        assertEquals(0.1, v.getCurrentSpeed(), 0.01);
    }

    @org.junit.Test
    public void stopEngine() {
        v.stopEngine();
        assertEquals(0, v.getCurrentSpeed(), 0.01);
    }

    @org.junit.Test
    public void getModelName() {
        assertEquals("TestVessel", v.getModelName());
    }

    @org.junit.Test
    public void getPosition() {
        assertEquals(0, v.getPosition().x);
        assertEquals(0, v.getPosition().y);
    }

    @org.junit.Test
    public void getDirection() {
        assertEquals(1, v.getDirection()[0]);
        assertEquals(0, v.getDirection()[1]);
    }

    @org.junit.Test
    public void setDirection() {
        int[] expected = new int[] {2,3};
        v.setDirection(expected);
        assertEquals(expected, v.getDirection() );
    }

    @org.junit.Test
    public void speedFactor() {
        assertEquals(1, v.speedFactor(), 0.01);
    }

    @org.junit.Test
    public void incrementSpeed() {
        v.incrementSpeed(2);
        assertEquals(2, v.getCurrentSpeed(),0.01);
    }

    @org.junit.Test
    public void decrementSpeed() {
        v.decrementSpeed(2);
        assertEquals(-2, v.getCurrentSpeed(),0.01);
    }

    @org.junit.Test
    public void move() {
        v.incrementSpeed(2);
        v.move();
        assertEquals(3, v.getPosition().x);
        assertEquals(0, v.getPosition().y);
    }


    @org.junit.Test
    public void turnLeft() {
        v.turnLeft();
        assertEquals(0, v.getDirection()[0]);
        assertEquals(1, v.getDirection()[1]);

        v.turnLeft();
        assertEquals(-1, v.getDirection()[0]);
        assertEquals(0, v.getDirection()[1]);
    }

    @org.junit.Test
    public void turnRight() {
        v.turnRight();
        assertEquals(0,v.getDirection()[0]);
        assertEquals(-1, v.getDirection()[1]);

        v.turnRight();
        assertEquals(-1, v.getDirection()[0]);
        assertEquals(0, v.getDirection()[1]);
    }

    @org.junit.Test
    public void gas() {
        v.gas(2.0);
        assertEquals(0, v.getCurrentSpeed(), 0.01);
        v.startEngine();
        v.gas(2.0);
        assertEquals(0.1,v.getCurrentSpeed(),0.01);
        v.gas(0.1);
        assertEquals(0.2, v.getCurrentSpeed(),0.01);

        v.setCurrentSpeed(100);
        v.gas(0.5);
        assertEquals(100, v.getCurrentSpeed(),0.01);
    }

    @org.junit.Test
    public void brake() {
        v.startEngine();
        v.brake(1);
        assertEquals(0.1, v.getCurrentSpeed(),0.01);

        v.brake(-1);
        assertEquals(0.1, v.getCurrentSpeed(),0.01);

        v.gas(1);
        v.brake(0.5);
        assertEquals(0.6, v.getCurrentSpeed(), 0.01);

    }
}