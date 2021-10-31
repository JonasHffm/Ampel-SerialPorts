package de.jhcomputing.ampel.utils;

import de.jhcomputing.ampel.window.MainWindow;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {

    private MainWindow mainWindow;

    public Data() {
        this.mainWindow = new MainWindow();
        this.initLanes();
    }

    public void initLanes() {

    }

}
