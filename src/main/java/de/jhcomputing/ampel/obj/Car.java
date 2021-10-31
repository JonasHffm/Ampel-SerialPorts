package de.jhcomputing.ampel.obj;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

@Getter
@Setter
public class Car {
    private JLabel carImage;
    private JFrame frame;
    private boolean moving;
    private java.util.Timer timer;
    private int default_X, default_Y;

    private final int speed = 6;

    public Car(JFrame frame, String dir, int xLoc, int yLoc) {
        this.carImage = new JLabel();
        this.frame = frame;

        this.default_X = xLoc;
        this.default_Y = yLoc;

        if(dir.equalsIgnoreCase("rl")) {
            this.carImage.setSize(140, 60);
            ImageIcon carImg = new ImageIcon("img/Car.png");
            this.carImage.setIcon(carImg);
        }else if(dir.equalsIgnoreCase("lr")) {
            this.carImage.setSize(140, 60);
            ImageIcon carImg = new ImageIcon("img/Car3.png");
            this.carImage.setIcon(carImg);
        }else if(dir.equalsIgnoreCase("tb")) {
            this.carImage.setSize(60, 140);
            ImageIcon carImg = new ImageIcon("img/Car4.png");
            this.carImage.setIcon(carImg);
        }else if(dir.equalsIgnoreCase("bt")){
            this.carImage.setSize(60, 140);
            ImageIcon carImg = new ImageIcon("img/Car2.png");
            this.carImage.setIcon(carImg);
        }

        this.carImage.setBounds(xLoc, yLoc, this.carImage.getWidth(), this.carImage.getHeight());
        this.carImage.setVisible(true);
    }

    public Consumer<Direction> move = direction -> {
        timer = new Timer();
        switch (direction) {
            case RIGHT -> {
                moving = true;
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if (moving) {
                            carImage.setBounds(carImage.getX() + 1, carImage.getY(), carImage.getWidth(), carImage.getHeight());
                            carImage.repaint();
                        }
                    }
                }, 0, speed);
            }
            case LEFT -> {
                moving = true;
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if (moving) {
                            carImage.setBounds(carImage.getX() - 1, carImage.getY(), carImage.getWidth(), carImage.getHeight());
                            carImage.repaint();
                        }
                    }
                }, 0, speed);
            }
            case TOP -> {
                moving = true;
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if (moving) {
                            carImage.setBounds(carImage.getX(), carImage.getY() - 1, carImage.getWidth(), carImage.getHeight());
                            carImage.repaint();
                        }
                    }
                }, 0, speed);
            }
            case BOTTOM -> {
                moving = true;
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if (moving) {
                            carImage.setBounds(carImage.getX(), carImage.getY() + 1, carImage.getWidth(), carImage.getHeight());
                            carImage.repaint();
                        }
                    }
                }, 0, speed);
            }
        }
    };

    public void respawn() {
        carImage.setBounds(this.default_X, this.default_Y, carImage.getWidth(), carImage.getHeight());
        carImage.repaint();
    }



    public void stop() {
        this.moving = false;
    }

    public enum Direction {
        TOP, BOTTOM, LEFT, RIGHT
    }
}
