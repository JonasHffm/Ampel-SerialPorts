package de.jhcomputing.ampel.obj;

import de.jhcomputing.ampel.main.Ampel;
import de.jhcomputing.ampel.utils.LaneType;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class Lane {

    private LaneType laneType;
    private Car car;
    private Trafficlight trafficlight;

    public Lane(JFrame jFrame, LaneType laneType) {
        this.laneType = laneType;


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

    }

}
