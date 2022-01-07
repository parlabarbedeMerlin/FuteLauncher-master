package fr.merlin.futelauncher;

import fr.merlin.futelauncher.ui.PanelMananger;
import javafx.stage.Stage;

public class FuteLauncher {
    private PanelMananger panelMananger;
    public void  init(Stage stage){
        this.panelMananger = new PanelMananger(this,stage);
        panelMananger.init();
    }
}
