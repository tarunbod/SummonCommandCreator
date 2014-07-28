package me.FirstWorldAnarchy.scc.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author family
 */
public class SummonCommandCreator extends Application {

    public static final String VERSION = "V2.4";
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent scc = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(scc);
        scene.getStylesheets().add(getClass().getResource("scc.css").toExternalForm());

        stage.getIcons().add(new Image(getClass().getResource("/me/FirstWorldAnarchy/scc/application/img/zombieFace.jpg").toExternalForm()));
        stage.setTitle("Summon Command Creator " + VERSION);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
