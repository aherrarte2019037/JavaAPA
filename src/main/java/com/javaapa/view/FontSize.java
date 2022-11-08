package com.javaapa.view;

/**
 * Fontsize options for UI.
 */
public enum FontSize {
    SMALL("fontSmall.css"),
    MEDIUM("fontMedium.css"),
    BIG("fontBig.css");

    private final String cssFile;
    private String cssFolder = "css/";

    private FontSize(String cssFile){
        this.cssFile = cssFile;
    }

    public String getCssFile() {
        return this.cssFolder + this.cssFile;
    }
}
