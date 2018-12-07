package Model.Tests;

import Model.Car;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Testing methods for the Model.Car class.
 */
public class CarTest {

    Car c = new Car(100, Color.RED, "TestCar", 2, 2500){};

    @org.junit.Test
    public void getNrDoors() {
        assertEquals(2, c.getNrDoors());
    }

    @org.junit.Test
    public void getWeight() {assertEquals(2500, c.getWeight());}

}