package com.codegym.task.task14.task1414;

/* 
MovieFactory

*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Read several keys (strings) from the console. Item 7
        Scanner scan = new Scanner(System.in);
        /*
            8. Create a variable movie in the Movie class, and for each entered string (key):
            8.1. Get an object using MovieFactory.getMovie and assign it to the variable movie.
            8.2. Display the result of calling movie.getClass().getSimpleName().
        */
        String input = scan.nextLine();

        while (input.equals("soapOpera") || input.equals("cartoon") || input.equals("thriller")){
            Movie movie =  MovieFactory.getMovie(input);
            System.out.println(movie.getClass().getSimpleName());
            input = scan.nextLine();
        }

        Movie movie =  MovieFactory.getMovie(input);

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            // Create a SoapOpera object for the key "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if("cartoon".equals(key)){
                movie = new Cartoon();
            } else if("thriller".equals(key)){
                movie = new Thriller();
            }
            //write your code here. Items 5, 6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    // Write your classes here. Item 3
    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }
}
