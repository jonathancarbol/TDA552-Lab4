package Model.Tests;

import Model.Ferry;
import Model.Transport;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Test methods for the Model.Transport class.
 */
public class TransportTest {

    Transport t = new Ferry(200, Color.BLACK,"TestTransport", 6, 3000);

    @Test
    public void startEngine() {
        t.startEngine();
        assertEquals(0.1,t.getCurrentSpeed(),0.01);
        t.stopEngine();
        t.getRamp().setRampUp(false);
        t.startEngine();
        assertEquals(0.0,t.getCurrentSpeed(),0.01);
    }

    @Test
    public void isRampUp() {
        assertTrue(t.getRamp().isRampUp());
        t.getRamp().setRampUp(false);
        assertFalse(t.getRamp().isRampUp());
    }

    @Test
    public void setRampUp() {
        t.getRamp().setRampUp(false);
        assertFalse(t.getRamp().isRampUp());
    }
}