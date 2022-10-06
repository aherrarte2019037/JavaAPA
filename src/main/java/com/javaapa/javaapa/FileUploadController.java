package com.javaapa.javaapa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FileUploadController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Uploading file...");
    }
}