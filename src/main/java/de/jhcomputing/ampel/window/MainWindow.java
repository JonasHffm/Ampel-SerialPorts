package de.jhcomputing.ampel.window;

import de.jhcomputing.ampel.autonom.AutonomExmaple;
import de.jhcomputing.ampel.main.Ampel;
import de.jhcomputing.ampel.obj.Car;
import de.jhcomputing.ampel.obj.Lane;
import de.jhcomputing.ampel.utils.CarManager;
import de.jhcomputing.ampel.utils.Data;
import de.jhcomputing.ampel.utils.LaneType;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class MainWindow {

    private JFrame frame;
    private CarManager carManager;
    private JLabel background;


    public MainWindow() {
        this.frame = new JFrame("Ampel - SerialPorts");
        this.frame.setSize(600, 600);

        carManager = new CarManager(this.frame);
        carManager.spawn();
        carManager.movement();
        initLanes();
        addElements();

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);

        this.frame.setVisible(true);
    }

    public void addElements() {
        background = new JLabel();
        ImageIcon imageIconBG = new ImageIcon("img/BG.png");
        background.setIcon(imageIconBG);
        background.setSize(frame.getHeight(), frame.getWidth());
        background.setVisible(true);

        JButton activateAuto = new JButton();
        activateAuto.setBounds(4, 4, 100, 25);
        activateAuto.setText("Auto");
        activateAuto.addActionListener(e -> {
            if(!AutonomExmaple.autoActive) {
                Ampel.data.setAutonomExmaple(new AutonomExmaple());
                Data.automationActive = true;
                JOptionPane.showMessageDialog(frame, "Autonomer Modus aktiviert!");
            }else {
                JOptionPane.showMessageDialog(frame, "Autonomer Modus ist bereits aktiv!");
            }
        });

        JButton activateSerial = new JButton();
        activateSerial.setBounds(4, 35, 100, 25);
        activateSerial.setText("Serial");
        activateSerial.addActionListener(e -> {
            Data.automationActive = false;
            JOptionPane.showMessageDialog(frame, "Serial-Modus wird in Kürze aktiviert (max. 15 Sekunden)!");
        });

        this.frame.add(activateAuto);
        this.frame.add(activateSerial);
        this.frame.add(background);
    }

    public void initLanes() {
        Lane lane1 = new Lane(frame, LaneType.RIGHT_LEFT_LEFT,
                carManager.getCarArrayList().stream()
                .filter(car -> car.getMovingDir().equalsIgnoreCase("RL")).findFirst().get());
        Lane lane2 = new Lane(frame, LaneType.RIGH_LEFT_RIGHT,
                carManager.getCarArrayList().stream()
                .filter(car -> car.getMovingDir().equalsIgnoreCase("LR")).findFirst().get());
        Lane lane3 = new Lane(frame, LaneType.TOPBOTTOM_RIGHT,
                carManager.getCarArrayList().stream()
                .filter(car -> car.getMovingDir().equalsIgnoreCase("BT")).findFirst().get());
        Lane lane4 = new Lane(frame, LaneType.TOPBOTTOM_LEFT,
                carManager.getCarArrayList().stream()
                .filter(car -> car.getMovingDir().equalsIgnoreCase("TB")).findFirst().get());

        Data.laneMap.put("RL-L", lane1);
        Data.laneMap.put("RL-R", lane2);
        Data.laneMap.put("TB-R", lane3);
        Data.laneMap.put("TB-L", lane4);
    }
}
