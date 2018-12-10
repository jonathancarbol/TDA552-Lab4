import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    //ArrayList<Vessel> cars = new ArrayList<>();
    World world;

    //methods:
    /*
    
    
    
    
    
    ----------------------------------------La inte till world som argument då vi inte startar main genom att skicka in saker osv....
     */
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        ArrayList<Vessel> cars = new ArrayList<>();
        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());

        // Add a world
        cc.world = new World(800, 560, cars);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc, cc.world.getSizeX(), cc.world.getSizeY());


        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vessel car : world.getCars()) {

                int x = (int) Math.round(car.getPosition().x);
                int y = (int) Math.round(car.getPosition().y);

                world.move(car);

                frame.drawPanel.moveit(x, y, car.getModelName());
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vessel car : world.getCars()) {
            car.gas(gas);
        }
    }

    void startEngine(){
        for (Vessel car : world.getCars()){
            car.startEngine();
        }
    }

    void stopEngine(){
        for (Vessel car : world.getCars()) {
            car.stopEngine();
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vessel car : world.getCars()){
            car.brake(brake);
        }
    }

    void turboOn(){
        for (Vessel car : world.getCars()){
            if (car.getModelName().equals("Model.Saab95")){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vessel car : world.getCars()){
            if (car.getModelName().equals("Model.Saab95")){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Vessel car : world.getCars()){
            if (car.getModelName().equals("ScaniaGSleeper")){
                ((Scania) car).getFlatBed().setFlatBedAngle(70,car.getCurrentSpeed());
            }
        }
    }

    void lowerBed() {
        for (Vessel car : world.getCars()){
            if (car.getModelName().equals("ScaniaGSleeper")){
                ((Scania) car).getFlatBed().setFlatBedAngle(0,car.getCurrentSpeed());
            }
        }
    }

    void startTimer(){
        timer.start();
    }

}