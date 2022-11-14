package com.javaapa.controller;

import com.javaapa.view.ColorTheme;
import com.javaapa.view.FontSize;
import com.javaapa.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Options Window Controller Class.
 */
public class OptionsWindowController extends BaseController implements Initializable {

    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<ColorTheme> themePicker;


    /**
     * @param viewFactory Reference to the view factory which manages this window.
     * @param fxmlName FXML file path
     */
    public OptionsWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    /**
     * Executes everytime this controller is show on stage.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpThemePicker();
        setUpFontSizePicker();
    }

    /**
     * Set up the FontSizePicker characteristics.
     */
    private void setUpFontSizePicker() {
        fontSizePicker.setMin(0);
        fontSizePicker.setMax(FontSize.values().length - 1);
        fontSizePicker.setValue(viewFactory.getCurrentFontSize().ordinal());
        fontSizePicker.setMajorTickUnit(1);
        fontSizePicker.setMinorTickCount(0);
        fontSizePicker.setBlockIncrement(1);
        fontSizePicker.setSnapToTicks(true);
        fontSizePicker.setShowTickMarks(true);
        fontSizePicker.setShowTickLabels(true);
        fontSizePicker.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                int i = object.intValue();
                return FontSize.values()[i].getName();
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });
        fontSizePicker.valueProperty().addListener((obs, oldVal, newVal) -> {
            fontSizePicker.setValue((newVal.intValue()));
        });
    }

    /**
     * Set up the ThemePicker options values.
     */
    private void setUpThemePicker() {
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(viewFactory.getCurrentColorTheme());
    }

    /**
     * Handles the applyButton button Logic. By setting the ViewFactory
     * Fontsize and color picker.
     */
    @FXML
    void applyButtonAction() {
        viewFactory.setCurrentColorTheme(themePicker.getValue());
        viewFactory.setCurrentFontSize(FontSize.values()[(int)(fontSizePicker.getValue())]);
        viewFactory.updateActiveScenesStyles();
        System.out.println(viewFactory.getCurrentColorTheme());
        System.out.println(viewFactory.getCurrentFontSize());
    }

    /**
     * Handles the cancelAction button Logic.
     */
    @FXML
    void cancelButtonAction() {
        Stage stage = (Stage) fontSizePicker.getScene().getWindow();
        viewFactory.closeStage(stage);
    }
}