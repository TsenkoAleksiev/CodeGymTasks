package com.codegym.task.task15.task1519;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Different methods for different types

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //write your code here
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayList<Object> diffObjects = new ArrayList<Object>();

        while(!input.equals("exit")){

            //try to parse to Double if '.' is met
            if(input.contains(".")) {
                Double val = 0.0;
                try {
                    val = Double.parseDouble(input);
                    diffObjects.add(val);
                } catch (Exception e){
                    diffObjects.add(input);
                }

            }else {
                Integer intVal = 0;
                Short shortVal = 0;

                try{
                    intVal = Integer.parseInt(input);
                    if(intVal > 0 && intVal < 128) {
                        shortVal = intVal.shortValue();
                        diffObjects.add(shortVal);
                    }else{
                        diffObjects.add(intVal);
                    }
                } catch (Exception e){
                    diffObjects.add(input);
                }
            }

            input = scan.nextLine();
        }

        diffObjects.stream().forEach(o -> {
            if(o instanceof Double) print((Double)o);
            else if(o instanceof Short) print((short) o);
            else if(o instanceof Integer) print((Integer) o);
            else {

                print(o.toString());
            }
        });
    }

    public static void print(Double value) {
        System.out.println("This is a Double. Value: " + value);
    }

    public static void print(String value) {
        System.out.println("This is a String. Value: " + value);
    }

    public static void print(short value) {
        System.out.println("This is a short. Value: " + value);
    }

    public static void print(Integer value) {
        System.out.println("This is an Integer. Value: " + value);
    }

}
