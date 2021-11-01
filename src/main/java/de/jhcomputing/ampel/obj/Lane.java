package de.jhcomputing.ampel.obj;

import de.jhcomputing.ampel.main.Ampel;
import de.jhcomputing.ampel.utils.LaneType;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

import static de.jhcomputing.ampel.obj.Trafficlight.Mode.*;

@Getter
@Setter
public class Lane {

    private LaneType laneType;
    private Car car;
    private Trafficlight trafficlight;

    public Lane(JFrame jFrame, LaneType laneType, Car car) {
        this.laneType = laneType;
        this.car = car;

        switch (laneType) {
            case RIGHT_LEFT_LEFT -> {
                this.trafficlight = new Trafficlight(jFrame, 430, 50);
                trafficlight.spawn(Trafficlight.Place.RIGHT);
            }
            case RIGH_LEFT_RIGHT -> {
                this.trafficlight = new Trafficlight(jFrame, 100, 280);
                trafficlight.spawn(Trafficlight.Place.LEFT);
            }
            case TOPBOTTOM_RIGHT -> {
                this.trafficlight = new Trafficlight(jFrame, 410, 300);
                trafficlight.spawn(Trafficlight.Place.BOTTOM);
            }
            case TOPBOTTOM_LEFT -> {
                this.trafficlight = new Trafficlight(jFrame, 180, 20);
                trafficlight.spawn(Trafficlight.Place.TOP);
            }
        }

        checkTrafficlightMode();
    }

    public void checkTrafficlightMode() {
        Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (trafficlight.getMode().equals(RED) || trafficlight.getMode().equals(RED_YELLOW)) {
                    car.stopAtLine();
                }else {
                    car.driveAgain();
                }
            }
        }, 0, 1);
    }

}
