package de.jhcomputing.ampel.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trafficlight {

    private int locX, locY;
    private Mode mode;

    public Trafficlight(int locX, int locY) {
        this.locX = locX;
        this.locY = locY;

        this.mode = Mode.RED;
    }

    public enum Mode {
        GREEN, YELLOW, RED, RED_YELLOW
    }

}
