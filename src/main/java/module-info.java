module com.javaapa.javaapa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires static lombok;

    opens com.javaapa to javafx.fxml;
    opens com.javaapa.view;
    opens com.javaapa.controller;
    exports com.javaapa;
}