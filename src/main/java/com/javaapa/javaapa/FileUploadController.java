package com.javaapa.javaapa;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class FileUploadController {
    @FXML
    private Button generateCiteButton;

    @FXML
    private TextField authorField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField websiteField;

    @FXML
    private TextField urlField;

    @FXML
    private DatePicker publicationDateField;

    @FXML
    protected void onGenerateCiteClick() {
        if (!validateForm()) {
            return;
        }

        final String author = authorField.getText();
        final String title = titleField.getText();
        final String website = websiteField.getText();
        final String url = urlField.getText();
        final LocalDate publicationDate = publicationDateField.getValue();
    }

    protected boolean validateForm() {
        if (authorField.getText().isBlank() || titleField.getText().isBlank() || websiteField.getText().isEmpty()
                || urlField.getText().isBlank() || publicationDateField.getValue() == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Generation failed");
            alert.setContentText("Missing information");
            alert.showAndWait();
            return false;
        }

        return true;
    }
}