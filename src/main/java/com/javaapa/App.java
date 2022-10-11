package com.javaapa;

import com.javaapa.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Launcher class
 */
public class App extends Application {

    /**
     * Initialize graphics UI.
     * @param stage
     */
    @Override
    public void start(Stage stage) {

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