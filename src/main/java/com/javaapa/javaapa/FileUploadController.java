package com.javaapa.javaapa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;

public class FileUploadController {
    @FXML
    private Label fileLabel;

    @FXML
    private Button uploadButton;

    private File file;

    @FXML
    protected void onFileUploadClick() {
        fileLabel.setText("Uploading file...");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Docx files", "*.docx");

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(filter);

        file = fileChooser.showOpenDialog(uploadButton.getScene().getWindow());

        fileLabel.setText(file != null ? file.getName() : "No file selected");
    }
}