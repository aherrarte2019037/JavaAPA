package com.javaapa.view;

import com.javaapa.controller.BaseController;
import com.javaapa.controller.LoginWindowController;
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

@Getter
@Setter
public class ViewFactory {

    private ArrayList<Stage> activeStages = new ArrayList<Stage>();

    // View options handling
    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;


    public ViewFactory(){

    }

    public void showLoginWindow(){
        System.out.println("Show window login.");

        BaseController controller = new LoginWindowController( this, "LoginWindow.fxml");
        Parent parent = FXMLload(controller);
        show(parent);
    }

    private void show(Parent parent){
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    public void updateStyles(){
        for (Stage stage: activeStages) {
            Scene scene = stage.getScene();
            // handle CSS
        }
    }

    public void closeStage(Stage stageToClose){
        stageToClose.close();
        activeStages.remove(stageToClose);
    }

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
