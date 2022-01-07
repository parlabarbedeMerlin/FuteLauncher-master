package fr.merlin.futelauncher.ui;

import fr.arinonia.arilibfx.AriLibFX;
import fr.arinonia.arilibfx.ui.utils.ResizeHelper;
import fr.merlin.futelauncher.FuteLauncher;
import fr.merlin.futelauncher.ui.panel.IPanel;
import fr.merlin.futelauncher.ui.panels.includes.TopPanel;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelMananger {
    private final FuteLauncher futeLauncher;
    private final Stage stage;
    private GridPane layout;
    private TopPanel topPanel = new TopPanel();
    private GridPane centerPanel = new GridPane();

    public PanelMananger(FuteLauncher futeLauncher, Stage stage) {
        this.futeLauncher = futeLauncher;
        this.stage = stage;
    }

    public void init(){
        this.stage.setTitle("Fute-Launcher");
        this.stage.setMinWidth(1280);
        this.stage.setWidth(1280);
        this.stage.setMinHeight(720);
        this.stage.setHeight(720);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.centerOnScreen();
        this.stage.show();

        this.layout = new GridPane();
        this.layout.setStyle(AriLibFX.setResponsiveBackground("https://png.pngtree.com/thumb_back/fh260/background/20190828/pngtree-dark-vector-abstract-background-image_302715.jpg"));
        this.stage.setScene(new Scene(this.layout));

        RowConstraints topPanelContrains = new RowConstraints();
        topPanelContrains.setValignment(VPos.TOP);
        topPanelContrains.setMinHeight(25);
        topPanelContrains.setMaxHeight(25);
        this.layout.getRowConstraints().addAll(topPanelContrains, new RowConstraints());
        this.layout.add(this.topPanel.getLayout(),0,0);
        this.topPanel.init(this);

        this.layout.add(this.centerPanel,0,0);
        GridPane.setVgrow(this.centerPanel, Priority.ALWAYS);
        GridPane.setHgrow(this.centerPanel, Priority.ALWAYS);
        ResizeHelper.addResizeListener(this.stage);
    }
    public void showPanel(IPanel panel){
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(panel.getLayout());
        panel.init(this);
        panel.onShow();
    }

    public Stage getStage() {return stage;}
    public FuteLauncher getFuteLauncher() {return futeLauncher;}
    public TopPanel getTopPanel() {return topPanel;}
}
