package fr.merlin.futelauncher.ui.panel;

import fr.merlin.futelauncher.ui.PanelMananger;
import javafx.animation.FadeTransition;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.Duration;

public class Panel implements IPanel{
    protected GridPane layout = new GridPane();
    protected PanelMananger panelManager;

    @Override
    public void init(PanelMananger panelMananger) {
        this.panelManager = panelMananger;
        GridPane.setHgrow(layout, Priority.ALWAYS);
        GridPane.setVgrow(layout,Priority.ALWAYS);

    }

    @Override
    public GridPane getLayout() {
        return this.layout;
    }

    @Override
    public void onShow() {
        FadeTransition transition = new FadeTransition(Duration.seconds(1),this.layout);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.setAutoReverse(true);
        transition.play();
    }
}
