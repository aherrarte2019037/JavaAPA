package com.javaapa.controller;

import com.javaapa.view.ViewFactory;

/**
 * Base class for every window controller.
 * Provides basic guidelines.
 */
public abstract class BaseController {

    /**Reference to the view factory which manages this window.*/
    protected ViewFactory viewFactory;
    /**FXML file path this controller will work with.*/
    private String fxmlName;

    /**
     * @param viewFactory Reference to the view factory which manages this window.
     * @param fxmlName FXML file path
     */
    public BaseController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    /**
     * @return FXML file path this controller is working with.
     */
    public String getFxmlName(){
        return fxmlName;
    };
}
