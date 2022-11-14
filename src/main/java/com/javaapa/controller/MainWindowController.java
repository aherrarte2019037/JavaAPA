package com.javaapa.controller;

import com.javaapa.App;
import com.javaapa.Model.CiteFormatter;
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
        viewFactory.showOptionsWindow();
    }

    @FXML
    void getDate(ActionEvent event) {
    }

    /**
     * Handles logic for exporting generated cites to
     * an external txt file.
     * @param event Event
     */
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

    /**
     * Hangles logic for generate cites with the data
     * enter by the user.
     * @param event
     */
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

    /**
     * Retrieve values input by the user and return the
     * bibliography cite as String.
     * @return APA cite.
     */
    private String GenerateCite() {
        CiteFormatter citeFormatter = new CiteFormatter()
                .authors(citeAuthorTextBox.getText().split(";"))
                .date(datePicker.getValue())
                .title(citeTitleTextBox.getText())
                .editorial(editorialTextBox.getText())
                .url(citeURLTextBox.getText());
        return citeFormatter.getCite();
    }

    /**
     * Saves the cite within CiteLabel to a .txt file.
     * @param content
     * @param file
     */
    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
        }
    }

    @FXML
    protected void onRulesClick() {
        App.Host.showDocument("https://normasapa.in/");
    }

    @FXML
    protected void onAboutClick() {
        App.Host.showDocument("https://normas-apa.org/introduccion/que-son-las-normas-apa/");
    }
}
