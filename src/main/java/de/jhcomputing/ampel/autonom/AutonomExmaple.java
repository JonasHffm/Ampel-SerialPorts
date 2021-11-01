package de.jhcomputing.ampel.autonom;

import de.jhcomputing.ampel.obj.Lane;
import de.jhcomputing.ampel.obj.Trafficlight;
import de.jhcomputing.ampel.utils.Data;

import java.util.Timer;
import java.util.TimerTask;

public class AutonomExmaple {

    public AutonomExmaple() {
        Lane tb_l = Data.laneMap.get("TB-L");
        Lane tb_r = Data.laneMap.get("TB-R");
        Lane rl_l = Data.laneMap.get("RL-L");
        Lane rl_r = Data.laneMap.get("RL-R");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean ampelSwap = false;
            @Override
            public void run() {
                if(ampelSwap) {
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            tb_l.getTrafficlight().setMode(Trafficlight.Mode.RED_YELLOW);
                            tb_r.getTrafficlight().setMode(Trafficlight.Mode.RED_YELLOW);

                            rl_l.getTrafficlight().setMode(Trafficlight.Mode.YELLOW);
                            rl_r.getTrafficlight().setMode(Trafficlight.Mode.YELLOW);
                        }
                    }, 1000);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            rl_l.getTrafficlight().setMode(Trafficlight.Mode.RED);
                            rl_r.getTrafficlight().setMode(Trafficlight.Mode.RED);

                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    tb_l.getTrafficlight().setMode(Trafficlight.Mode.GREEN);
                                    tb_r.getTrafficlight().setMode(Trafficlight.Mode.GREEN);
                                }
                            }, 1000*2);
                        }
                    }, 1000*3);
                    ampelSwap = false;
                }else {
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            rl_l.getTrafficlight().setMode(Trafficlight.Mode.RED_YELLOW);
                            rl_r.getTrafficlight().setMode(Trafficlight.Mode.RED_YELLOW);

                            tb_l.getTrafficlight().setMode(Trafficlight.Mode.YELLOW);
                            tb_r.getTrafficlight().setMode(Trafficlight.Mode.YELLOW);
                        }
                    }, 1000);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            tb_l.getTrafficlight().setMode(Trafficlight.Mode.RED);
                            tb_r.getTrafficlight().setMode(Trafficlight.Mode.RED);

                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    rl_l.getTrafficlight().setMode(Trafficlight.Mode.GREEN);
                                    rl_r.getTrafficlight().setMode(Trafficlight.Mode.GREEN);
                                }
                            }, 1000*2);
                        }
                    }, 1000*3);
                    ampelSwap = true;
                }
            }
        }, 1000*4, 1000*15);
    }

}
