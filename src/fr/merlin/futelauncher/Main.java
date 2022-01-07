package fr.merlin.futelauncher;

import fr.arinonia.arilibfx.utils.AriLogger;
import javafx.application.Application;

import javax.swing.*;

public class Main {

    public static AriLogger logger;

    public static void main(String[] args) {

        logger = new AriLogger("FuteLauncher");
        try {
            Class.forName("javafx.application.Application");
            Application.launch(FxApplication.class,args);
        }catch (ClassNotFoundException e){
            logger.warn("JavaFx not Found :cry");
            JOptionPane.showMessageDialog(null,"Une erreur a été détecté avec javafx.\n"+e.getMessage()+"\nNotFound");
        }
    }
}
