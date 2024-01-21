package main.java.ch.laeub.Lambdas;

import java.util.function.Predicate;

public class Driver {

    public static void main(String[] args) {
        FuncInterface funcInterface_1 = x -> String.valueOf(x); // Expression style
        System.out.println(funcInterface_1.toTheString(2));

        FuncInterface funcInterface_2 = x -> { return String.valueOf(x);};  // Function block style, return is required
        System.out.println(funcInterface_2.toTheString(3));

        FuncInterface funcInterface_3 = String::valueOf;    // Method reference style
        System.out.println(funcInterface_3.toTheString(4));

        // This is what java does under the hood for all the above
        System.out.println(new FuncInterface() {
                    @Override
                    public String toTheString(int i) {
                        return String.valueOf(i);
                    }
                }
        );


        Predicate<String> stringPredicate = x -> x.isEmpty();
        System.out.println(stringPredicate.test("a"));
    }

}
