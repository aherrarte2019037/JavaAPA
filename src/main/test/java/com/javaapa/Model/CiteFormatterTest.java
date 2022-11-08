package com.javaapa.Model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CiteFormatterTest {

    @Test
    void dateFormatter() {
        CiteFormatter citeFormatter = new CiteFormatter();
        citeFormatter
                .authors("Reichiro Inakaki", "Boichi")
                .date(LocalDate.now())
                .title("Dr. Stone")
                .editorial("Ecasals")
                .url("yamete.com");
        System.out.println(citeFormatter.getCite());

        //System.out.println(citeFormatter.dateFormatter("MMMM, yyyy", LocalDate.now()));
    }
}