package com.javaapa.controller;

import com.javaapa.App;
import com.javaapa.view.ViewFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Main Window Controller Class
 */
public class MainWindowController extends BaseController implements Initializable {
    @FXML
    private Label Bibliography;

    @FXML
    private TextField citeAuthorTextBox;

    @FXML
    private TextField citeTitleTextBox;

    @FXML
    private TextField citeURLTextBox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField editorialTextBox;

    @FXML
    private TextField websiteTextBox;

    @FXML
    private Button exportCiteBtn;

    @FXML
    private CheckBox openFolderCbx;

    @FXML
    private Label exportMessageLbl;

    /**
     * @param viewFactory Reference to the view factory which manages this window.
     * @param fxmlName    FXML file path
     */
    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exportCiteBtn.setVisible(false);
        openFolderCbx.setVisible(false);

        exportMessageLbl.setVisible(false);
        exportMessageLbl.setManaged(false);
    }

    /**
     * Handles the optionsAction button Logic.
     */
    @FXML
    void optionsAction(ActionEvent event) {
        System.out.println("Mob psycho...");
        viewFactory.showOptionsWindow();
    }

    @FXML
    void getDate(ActionEvent event) {
        LocalDate myDate = datePicker.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @FXML
    void ExportCiteButton(ActionEvent event) {
        Node source = (Node) event.getSource();
        Window window = source.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(window);
        if (file != null) {
            saveTextToFile(GenerateCite(), file);
            if (openFolderCbx.isSelected()) {
                App.Host.showDocument(file.getParent());
            }
        }

        exportCiteBtn.setVisible(false);
        openFolderCbx.setVisible(false);

        exportMessageLbl.setVisible(true);
        exportMessageLbl.setManaged(true);
    }

    @FXML
    void GenerateCiteButton(ActionEvent event) {
        String generatedCite = GenerateCite();
        Bibliography.setText(generatedCite);

        if (!generatedCite.isBlank()) {
            exportCiteBtn.setVisible(true);
            openFolderCbx.setVisible(true);

        }

        exportMessageLbl.setVisible(false);
        exportMessageLbl.setManaged(false);
    }

    String GenerateCite() {
        String articleTitle = citeTitleTextBox.getText();
        String articleAuthors = getAuthors(citeAuthorTextBox.getText().split(";"));
        String articleDate = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String articleEditorial = editorialTextBox.getText();
        String articleURL = citeURLTextBox.getText();
        return String.format(
                "%s.(%s).%s.%s.%s",
                articleAuthors, articleDate, articleTitle, articleEditorial, articleURL);
    }

    String getAuthors(String... authors) {
        if (authors.length == 1 && authors[0] == "")
            return "Anónimo";

        String message = "";

        for (String author : authors) {
            message += getAuthorFragment(author) + " ";
        }

        return message;
    }

    String getAuthorFragment(String author) {
        String[] names = author.split(" ");
        if (names.length == 1)
            return names[0];
        return names[1] + ", " + names[0].charAt(0);
    }

    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
        }
    }
}
