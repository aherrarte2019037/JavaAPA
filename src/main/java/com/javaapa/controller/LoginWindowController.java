package com.javaapa.controller;

import com.javaapa.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Login window controller Class.
 */
public class LoginWindowController extends BaseController {

    /**
     * @param viewFactory Reference to the view factory which manages this window.
     * @param fxmlName FXML file path
     */
    public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField passwordField;

    /**
     * Handles the login Action button Logic.
     */
    @FXML
    void loginButtonAction() {
        System.out.println("Mob psycho...");
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
        viewFactory.showMainWindow();
    }

}
