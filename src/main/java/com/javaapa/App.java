package com.javaapa;

import com.javaapa.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}