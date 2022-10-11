package com.javaapa.controller;

import com.javaapa.controller.BaseController;
import com.javaapa.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private TextField citeDatePublishedTextBox;

    @FXML
    private TextField citeEditorialTextBox;

    @FXML
    private TextField citeTitleTextBox;

    @FXML
    private TextField citeURLTextBox;

    @FXML
    private TextField citeWebPageTextBox;

    /**
     * Handles the optionsAction button Logic.
     */
    @FXML
    void optionsAction(ActionEvent event) {
        System.out.println("Mob psycho...");
        viewFactory.showOptionsWindow();
    }


}
