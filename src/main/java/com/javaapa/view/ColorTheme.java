package com.javaapa.view;

import lombok.Getter;

/**
 * Color themes for UI.
 */
public enum ColorTheme {
    LIGHT("themeLight.css", "Claro"),
    DEFAULT("themeDefault.css", "Clásico"),
    DARK("themeDark.css", "Oscuro");

    private final String cssFile;
    private String name;
    private String cssFolder = "css/";

    private ColorTheme(String cssFile, String name){
        this.cssFile = cssFile;
        this.name = name;
    }

    public String getCssFile() {
        return this.cssFolder + this.cssFile;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
