package main.java.ch.laeub.Lambdas;

import java.util.ArrayList;
import java.util.Comparator;

public class Exercises {

    public static ArrayList<String> names = new ArrayList<>();
    static {
        names.add("John"); names.add("Tom"); names.add("Jane"); names.add("Arnold");
        names.add("Ann"); names.add("Sue"); names.add("Aurelia"); names.add("Alfred");
    }
    public static void main(String[] args) {

        // Example 1: Comparator includes another method "naturalOrder" to sort objects using Comparable
        // – Sort the names in their natural order
        names.sort(Comparator.naturalOrder());

        // – Use a lambda expression to print the names to the console
        names.forEach(x -> System.out.println(x));
        System.out.println("-----------------");

        // – Print the strings again, this time using a method-reference
        names.forEach(System.out::println);
        System.out.println("-----------------");

        // Example 2: Use the Comparator.comparing method.
        // – Use a lambda to sort the names by only their first letter
        names.sort(Comparator.comparing(x -> x.charAt(0)));
        names.forEach(System.out::println);
        System.out.println("-----------------");

    }

}
