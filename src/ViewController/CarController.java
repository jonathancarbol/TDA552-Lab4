package ViewController;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
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
    World world;

    //methods:----------------------------------------La inte till world som argument då vi inte startar main genom att skicka in saker osv....
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vessel car : world.getCars()) {

                int x = (int) Math.round(car.getPosition().x);
                int y = (int) Math.round(car.getPosition().y);

                world.move(car);

                frame.drawPanel.moveit(x, y, world.getCars());
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }


    }

    public void initButton(){
        frame.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(frame.getGasAmount());
            }
        });

        frame.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { startEngine();}
        });

        frame.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopEngine();
            }
        });

        frame.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(frame.getGasAmount());
            }
        });

        frame.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }
        });

        frame.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
            }
        });

        frame.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBed();
            }
        });

        frame.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });

        frame.getAddCarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar();
            }
        });

        frame.getRemoveCarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCar();

            }
        });
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

    void addCar() {
        if (world.getCars().size()<10) {
            Random rand = new Random();
            int n = rand.nextInt(3) + 1;

            switch (n) {
                case 1:
                    world.getCars().add(VesselFactory.createVolvo240());
                    DrawCar Volvo240 = new DrawCar(frame.drawPanel.getVolvoImage(), new Point(), "Model.Volvo240");
                    frame.drawPanel.getDrawCars().add(Volvo240);
                    break;

                case 2:
                    world.getCars().add(VesselFactory.createSaab95());
                    DrawCar Saab95 = new DrawCar(frame.drawPanel.getSaabImage(), new Point(), "Model.Saab95");
                    frame.drawPanel.getDrawCars().add(Saab95);
                    break;

                case 3:
                    world.getCars().add(VesselFactory.createScania());
                    DrawCar Scania = new DrawCar(frame.drawPanel.getScaniaImage(), new Point(), "ScaniaGSleeper");
                    frame.drawPanel.getDrawCars().add(Scania);
                    break;
            }
        }
    }

    void removeCar() {
        if (world.getCars().size() > 0) {
            world.getCars().remove(world.getCars().size() - 1);
            frame.drawPanel.getDrawCars().remove(frame.drawPanel.getDrawCars().size() - 1);
        }
        frame.drawPanel.repaint();
    }

}