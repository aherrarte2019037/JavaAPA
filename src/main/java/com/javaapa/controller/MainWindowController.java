package com.javaapa.controller;

import com.javaapa.controller.BaseController;
import com.javaapa.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Main Window Controller Class
 */
public class MainWindowController extends BaseController {

    /**
     * @param viewFactory Reference to the view factory which manages this window.
     * @param fxmlName FXML file path
     */
    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }


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

    }

    @FXML
    void GenerateCiteButton(ActionEvent event) {
        Bibliography.setText(GenerateCite());
    }

    String GenerateCite(){
        String articleTitle = citeTitleTextBox.getText();
        String  articleAuthors = getAuthors(citeAuthorTextBox.getText().split(";"));
        String articleDate = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String articleEditorial = editorialTextBox.getText();
        String articleURL = citeURLTextBox.getText();
        return String.format(
                "%s.(%s).%s.%s.%s",
                articleAuthors, articleDate, articleTitle, articleEditorial, articleURL);
    }


    String getAuthors(String... authors){
        if(authors.length == 1 && authors[0] == "")
            return "Anónimo";

        String message = "";

        for (String author: authors) {
            message += getAuthorFragment(author) + " ";
        }

        return message;
    }

    String getAuthorFragment(String author){
        String[] names = author.split(" ");
        if(names.length == 1)
            return names[0];
        return names[1] + ", " + names[0].charAt(0);
    }
}
