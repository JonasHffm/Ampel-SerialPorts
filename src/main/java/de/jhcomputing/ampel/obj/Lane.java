package de.jhcomputing.ampel.obj;

import de.jhcomputing.ampel.utils.LaneType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lane {

    private LaneType laneType;
    private Car car;
    private Trafficlight trafficlight;


    public Lane(LaneType laneType) {
        this.laneType = laneType;
    }

}
