package com.javaapa.view;

import com.javaapa.controller.BaseController;
import com.javaapa.controller.MainWindowController;
import com.javaapa.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Class for managing the diffent UI stages (windows) of the program by showing or closing them.
 */
@Getter
@Setter
public class ViewFactory {

    /**Contains all active stages*/
    private ArrayList<Stage> activeStages = new ArrayList<Stage>();

    // View options handling

    /**Current stages colortheme*/
    private ColorTheme currentColorTheme = ColorTheme.DEFAULT;
    /**Current stages fontSize*/
    private FontSize currentFontSize = FontSize.MEDIUM;

    /**
     * Constructor
     */
    public ViewFactory(){

    }

    /**
     * Show a given Stage (window).
     * @param parent Window to be show.
     */
    private void show(Parent parent){
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    /**
     * Creates a Main Window.
     */
    public void showMainWindow(){
        System.out.println("Show main Window");

        BaseController controller = new MainWindowController(this, "MainWindow.fxml");
        Parent parent = FXMLload(controller);
        show(parent);
    }


    /**
     * Creates Options Window for changin UI Fontsize and colorTheme.
     */
    public void showOptionsWindow(){
        System.out.println("Show main Window");

        BaseController controller = new OptionsWindowController( this, "OptionsWindow.fxml");
        Parent parent = FXMLload(controller);
        show(parent);
    }

    /**
     * Changes CSS styles of all scenes within {@link #activeStages activeStages}.
     */
    public void updateActiveScenesStyles(){
        for (Stage stage: activeStages) {
            Scene scene = stage.getScene();
            updateStyle(scene);
        }
    }

    /**
     * Changes de color theme and font size of a given scene
     * acordding to the current fontsize and color theme
     * defined in the fields of this class.
     * @param scene
     */
    private void updateStyle(Scene scene){
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource(this.currentFontSize.getCssFile()).toExternalForm());
        scene.getStylesheets().add(getClass().getResource(this.currentColorTheme.getCssFile()).toExternalForm());
    }

    /**
     * Close a given Stage (Window).
     * @param stageToClose Window to be show.
     */
    public void closeStage(Stage stageToClose){
        stageToClose.close();
        activeStages.remove(stageToClose);
    }

    /**
     * Recives a Contoller and search for its FXML file.
     * @param controller Controller.
     * @return The parent for the given controller.
     */
    private Parent FXMLload(BaseController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try{
            parent = fxmlLoader.load();
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return parent;
    }

}
