package main.java.ch.laeub.translator;

import java.util.Locale;
import java.util.ResourceBundle;

public class Driver {

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("main/resources/languages.properties", locale);

    }

}
