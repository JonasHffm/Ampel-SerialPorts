package de.jhcomputing.ampel.window;

import de.jhcomputing.ampel.obj.Car;
import de.jhcomputing.ampel.utils.CarManager;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class MainWindow {

    private JFrame frame;

    private CarManager carManager;

    private JLabel background;


    public MainWindow() {
        this.frame = new JFrame("Ampel - SerialPorts");

        addElements();
        carManager = new CarManager(this.frame);
        carManager.spawn();

        this.frame.setSize(600, 600);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setVisible(true);

        carManager.movement();
    }

    public void addElements() {
        background = new JLabel();
        ImageIcon imageIconBG = new ImageIcon("img/BG.png");
        background.setIcon(imageIconBG);
        background.setSize(frame.getHeight(), frame.getWidth());
        background.setVisible(true);


        this.frame.add(background);
    }


}
