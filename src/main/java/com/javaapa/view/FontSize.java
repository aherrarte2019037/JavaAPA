package com.javaapa.view;

import lombok.Getter;

/**
 * Fontsize options for UI.
 */
public enum FontSize {
    SMALL("fontSmall.css", "Pequeño"),
    MEDIUM("fontMedium.css", "Mediano"),
    BIG("fontBig.css", "Grande");

    private final String cssFile;
    @Getter
    private String name;
    private String cssFolder = "css/";

    private FontSize(String cssFile, String name){
        this.cssFile = cssFile;
        this.name = name;
    }
    public String getCssFile() {
        return this.cssFolder + this.cssFile;
    }
}
