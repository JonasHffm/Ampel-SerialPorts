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
        this.frame.setSize(600, 600);

        carManager = new CarManager(this.frame);
        carManager.spawn();
        carManager.movement();
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


        this.frame.add(background);
    }

    public void repaintWindow() {
        frame.repaint();
        addElements();
        this.frame.setVisible(true);
    }

}
