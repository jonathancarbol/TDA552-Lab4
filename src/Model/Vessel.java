package Model;

import java.awt.*;

/**
 * The Model.Vessel class implements methods for handling different vessel types
 * and vessel operations. It implements a Model.Movable interface.
 *
 * @author Jonathan Carbol
 * @version 1.0
 * @since 2018-11-08
 */


public abstract class Vessel implements Movable {

    private double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double currentSpeed; // The current speed of the car
    private double[] position2;
    private Point position; // The current position of the car
    private int[] direction; // The direction of the care (where index 0 is the x-direction and index 1 is the y direction)

    /**
     * Contructor for creating a vessel. It includes the engine power, color and model name. It also sets the current
     * speed to zero, as well as creates a starting point and direction of the vessel.
     */

    public Vessel(double enginePower, Color color, String modelName) {
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = new Point(0,0);
        this.position2 = new double[]{1,0};
        this.direction = new int[]{1,0};
        stopEngine();
    }

    /**
     * Checks to see the enginePower of the car.
     * @return enginePower
     */
    public double getEnginePower() {

        return enginePower;
    }

    /**
     * Checks to see the currentSpeed of the car.
     * @return currentSpeed
     */
    public double getCurrentSpeed() {

        return currentSpeed;
    }

    /**
     * Sets the currentSpeed to a specific value.
     * @param currentSpeed
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * Checks the color of the car.
     * @return color
     */
    public Color getColor() {

        return color;
    }

    /**
     * Sets the color of the car.
     * @param clr
     */
    public void setColor(Color clr) {

        color = clr;
    }

    /**
     * Starts the engine and sets the currentSpeed of the car to 0.1.
     */
    public void startEngine() {

        currentSpeed = 0.1;
    }

    /**
     * Stops the engine and sets the currentSpeed of the car to 0.
     */
    public void stopEngine() {

        currentSpeed = 0;
    }

    /**
     * Checks to see the modelName of the car.
     * @return modelName
     */
    public String getModelName() {

        return modelName;
    }

    /**
     * Checks to see the position of the car.
     * @return position
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Sets the position of the car
     */
    public void setPosition(Point p) {
        this.position = p;
    }

    /**
     * Checks to see the direction of the car.
     * @return direction
     */
    public int[] getDirection() {
        return direction;
    }

    /**
     * Sets the direction of the Model.Vessel.
     * @param direction
     */
    public void setDirection(int[] direction) {this.direction = direction;}


    /**
     * Generic speedFactor of 1 as standard.
     * @return 1.0
     */
    public double speedFactor() {
        //out.println("test");
        return 1.0;
    }

    public double[] getPosition2() {
        return position2;
    }

    public void setPosition2(double[] position2) {
        this.position2 = position2;
    }

    /**
     * Increases the currentSpeed of the car with an increment amount.
     * @param amount
     */
    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Decreases the currentSpeed of the car with an increment amount.
     * @param amount
     */
    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Changes the position of the car based on its current position and direction.
     */
    public void move() {

        position2[0] = getCurrentSpeed() * direction[0] + position2[0];
        position2[1] = getCurrentSpeed() * direction[1] + position2[1];

        position.x = (int) position2[0];
        position.y = (int) position2[1];
    }

    /**
     * Changes the direction of the car based on what direction it currently has, by turning left.
     */
    public void turnLeft() {
        if (direction[1] == -1 || direction[1] == 1) {
            direction[0] = -direction[1];
            direction[1] = 0;
        } else if (direction[0] == 1 || direction[1] == 0) {
            direction[1] = direction[0];
            direction[0] = 0;
        }
    }

    /**
     * Changes the direction of the car based on what direction it currently has, by turning right.
     */
    public void turnRight() {
        if (direction[1] == -1 || direction[1] == 1) {
            direction[0] = direction[1];
            direction[1] = 0;
        } else if (direction[0] == 1 || direction[1] == 0) {
            direction[1] = -direction[0];
            direction[0] = 0;
        }
    }

    /**
     * Executes the method increment based on certain conditions such as the current speed being limited
     * by the enginePower, and the gas not being able to decrease the speed.
     * @param amount
     */
    public void gas(double amount){
        if(currentSpeed > 0) {
            if (amount <= 1.0 && amount >= 0) {
                incrementSpeed(amount);
                if (currentSpeed > enginePower) {
                    currentSpeed = enginePower;
                }
            } else {
                incrementSpeed(0);
            }
        }
    }

    /**
     * Executes the method decrement based on certain conditions such as the current speed being limited
     * by no being negative, and the gas not being able to increase the speed.
     * @param amount
     */
    public void brake(double amount){
        if (amount <= 1.0 && amount >= 0) {
            decrementSpeed(amount);
            if (currentSpeed < 0.1){
                currentSpeed = 0.1;
            }
        }else{
            decrementSpeed(0);
        }
    }
}
