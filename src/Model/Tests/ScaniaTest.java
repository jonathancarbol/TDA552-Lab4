package Model.Tests;

import Model.Scania;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test methods for the Model.Scania class.
 */
public class ScaniaTest {

    Scania s = new Scania();

    @Test
    public void startEngine() {
        s.startEngine();
        assertEquals(0.1, s.getCurrentSpeed(),0.01);
        s.stopEngine();
        s.setCurrentSpeed(2);
        s.startEngine();
        assertEquals(0.1, s.getCurrentSpeed(),0.01);
    }

    @Test
    public void setFlatBedAngle() {
        s.getFlatBed().setFlatBedAngle(0,0);
        assertEquals(0, s.getFlatBed().getFlatBedAngle());
        s.getFlatBed().setFlatBedAngle(50,0);
        assertEquals(50,s.getFlatBed().getFlatBedAngle());
        s.getFlatBed().setFlatBedAngle(100,0);
        assertEquals(50,s.getFlatBed().getFlatBedAngle());

        s.setCurrentSpeed(2);
        s.getFlatBed().setFlatBedAngle(0,s.getCurrentSpeed());
        assertEquals(50,s.getFlatBed().getFlatBedAngle());
    }

    @Test
    public void getFlatBedAngle() {
        s.getFlatBed().setFlatBedAngle(20,0);
        assertEquals(20, s.getFlatBed().getFlatBedAngle());
    }
}