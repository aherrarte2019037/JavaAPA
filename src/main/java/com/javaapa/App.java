// DANIEL RAYO ROLDAN 22933
// ANGEL HERRARTE 22873
// IRVING MORALES 22781
// BRANDON JOSEPH JUAREZ 22815
// PROGRAM: Citehelper
// PURPOSE: Is a desktop program made for construct cites based on APA guidelines.


package com.javaapa;

import com.javaapa.view.ViewFactory;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;

/**
 * Launcher class
 */
public class App extends Application {

    public static HostServices Host;

    /**
     * Initialize graphics UI.
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        Host = getHostServices();
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();
    }

    /**
     * Main function
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}