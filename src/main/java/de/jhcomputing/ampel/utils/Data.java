package de.jhcomputing.ampel.utils;

import de.jhcomputing.ampel.autonom.AutonomExmaple;
import de.jhcomputing.ampel.obj.Lane;
import de.jhcomputing.ampel.window.MainWindow;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Data {

    public static Map<String, Lane> laneMap = new HashMap<>();
    public static boolean automationActive = true;

    private MainWindow mainWindow;
    private AutonomExmaple autonomExmaple;

    public Data() {
        this.mainWindow = new MainWindow();
        this.autonomExmaple = new AutonomExmaple();
    }

}
