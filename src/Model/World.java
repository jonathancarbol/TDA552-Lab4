package Model;

import java.util.ArrayList;
import java.util.Random;


public class World {
    private int sizeX;
    private int sizeY;
    private ArrayList<Vessel> cars;

    public World(int sizeX, int sizeY, ArrayList<Vessel> cars) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.cars = cars;
    }

    public void move(Vessel car){
        if (car.getPosition().x > 674){
            car.turnLeft();
            car.turnLeft();
        }else if (car.getPosition().x < 0){
            car.turnLeft();
            car.turnLeft();
        }
        car.move();
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public ArrayList<Vessel> getCars() {
        return cars;
    }

}
