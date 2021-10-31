package de.jhcomputing.ampel.utils;

import de.jhcomputing.ampel.obj.Car;

import javax.swing.*;
import java.util.ArrayList;

public class CarManager {

    private JFrame frame;
    private ArrayList<Car> carArrayList;

    public CarManager(JFrame frame) {
        this.frame = frame;
    }

    public void spawn() {
        Car carRL = new Car(this.frame, "rl", 0, 250);
        Car carLR = new Car(this.frame, "lf", 200, 200);
        Car carBT = new Car(this.frame, "bt", 200, 200);
        Car carTB = new Car(this.frame, "tb", 200, 200);
        this.carArrayList = new ArrayList<>(){{
            add(carRL);
            add(carLR);
            add(carBT);
            add(carTB);
        }};

        carRL.move(Car.Direction.RIGHT);
        carLR.move(Car.Direction.LEFT);
        carTB.move(Car.Direction.TOP);
        carBT.move(Car.Direction.BOTTOM);

        this.frame.add(carRL.getCarImage());
        this.frame.add(carLR.getCarImage());
        this.frame.add(carBT.getCarImage());
        this.frame.add(carTB.getCarImage());
    }

    public void movement() {

    }

}
