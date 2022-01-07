package fr.merlin.futelauncher.ui.panel;

import fr.merlin.futelauncher.ui.PanelMananger;
import javafx.scene.layout.GridPane;

public interface IPanel {
    void init(PanelMananger panelMananger);
    GridPane getLayout();
    void onShow();
}
