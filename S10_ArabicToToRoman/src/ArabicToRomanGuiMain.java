import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.util.Callback;


/**
 * Main class for the roman to arabic conversion which launches the GUI
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class ArabicToRomanGuiMain extends Application {

    /**
     * launches the GUI
     * @param args  an array of strings that can be passed in when starting the main program
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Uses the fxml to create and show the GUI
     * @param stage the panel for which GUI objects will be placed on
     * @throws IOException exception that occurs if there is an I/O error
     */
    @Override
    public void start(Stage stage) throws IOException {
        Parent root =
                FXMLLoader.load(getClass().getResource("Gui.fxml"));

        Scene scene = new Scene(root); // attach scene graph to scene
        stage.setTitle("Roman To Arabic"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        stage.show(); // display the stage

    }
}