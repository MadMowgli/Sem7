package ch.laeub.Week_2.Lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Driver {

    public static void main(String[] args) {

        // Create some countries in a list
        ArrayList<Country> countries = new ArrayList<>(Arrays.asList(
                new Country("Switzerland", 41285, 8850000),
                new Country("Germany", 357021, 84550000),
                new Country("France", 675417, 65700000),
                new Country("Austria", 83858, 9200000)
        ));


        // Using lambda expressions to sort the countries by population
        Collections.sort(countries, (c1, c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation()));
        // Printing out the countries
        countries.forEach((c1) -> System.out.println(c1.getPopulation()));

        // Create some space on the console
        System.out.println("\n");

        // Or with less code
        countries.sort(Comparator.comparingInt(Country::getPopulation));
        // Printing out the countries
        countries.forEach( c -> System.out.println(c.getPopulation()));
    }

}
