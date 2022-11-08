package com.javaapa.Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class CiteFormatter {

    private String title = "";
    private String authors = "";
    private String date = "";
    private String editorial = "";
    private String url = "";

    public static final Locale LOCALE_ES = new Locale("es", "ES");

    private String getAuthors(String... authors) {
        if (authors == null)
            return "Anónimo";
        if (authors.length == 1 && authors[0] == "")
            return "Anónimo";

        String message = "";

        for(int i=0; i < authors.length; i++){
            if(i == authors.length - 1)
                message += " & " + getAuthorFragment(authors[i]);
            else
                message += ", " + getAuthorFragment(authors[i]);
        }

        return message.substring(1);
    }

    private String getAuthorFragment(String author) {
        String[] names = author.strip().split(" ");
        if (names.length == 1)
            return names[0];
        return names[1] + ", " + names[0].charAt(0) + ".";
    }

    private String dateFormatter(String outputFormat, LocalDate date){
        String outputDate = "";
        //Defining output format.
        String output = outputFormat.isEmpty()? "MMMM , yyyy" : outputFormat;
        try {
            Date inputDate = Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            outputDate = new SimpleDateFormat(output, LOCALE_ES).format(inputDate);
        } catch (Exception e) {
            outputDate = "s/f";
        }
        return outputDate;
    }

    /* ====================
            PUBLIC API
       ====================*/

    public String getCite(){
        return String.format(
                "%s.(%s).%s.%s.%s",
                this.authors,
                this.date,
                this.title ,
                this.editorial,
                this.url);
    }

    public CiteFormatter title(String title){
        this.title = title;
        return this;
    }

    public CiteFormatter authors(String... authors){
        this.authors = getAuthors(authors);
        return this;
    }

    public CiteFormatter date(LocalDate date){
        if(date == null){
            this.date = "s/f";
        }
        this.date = dateFormatter("MMMM , yyyy", date);
        return this;
    }

    public CiteFormatter editorial(String editorial){
        this.editorial = editorial;
        return this;
    }

    public CiteFormatter url(String url){
        this.url = url;
        return this;
    }
}
