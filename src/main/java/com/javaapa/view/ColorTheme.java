package com.javaapa.view;

/**
 * Color themes for UI.
 */
public enum ColorTheme {
    LIGHT("themeLight.css"),
    DEFAULT("themeDefault.css"),
    DARK("themeDark.css");

    private final String cssFile;
    private String cssFolder = "css/";

    private ColorTheme(String cssFile){
        this.cssFile = cssFile;
    }

    public String getCssFile() {
        return this.cssFolder + this.cssFile;
    }
}
