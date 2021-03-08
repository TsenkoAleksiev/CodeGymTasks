package com.codegym.task.task14.task1419;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.*;

/* 
Exception invasion

*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   // The first exception
        try { //1
            float i = 1 / 0;

        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        //write your code here
        try{ //2
            int a = Integer.parseInt(null);
        } catch (NumberFormatException e){
            exceptions.add(e);
        }

        try { //3
            int[] arr = {1, 2, 3, 4};
            System.out.println(arr[5]);
        } catch (IndexOutOfBoundsException e){
            exceptions.add(e);
        }

        try { //4
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e){
            exceptions.add(e);
        }

        try { //5
            Object x = new Integer(5);
            System.out.println((String) x);
        } catch (ClassCastException e){
            exceptions.add(e);
        }

        try { //6
            Object x[] = new String[3];
            x[0] = new Integer(3);
        } catch (ArrayStoreException e){
            exceptions.add(e);
        }

        try { //7
            int[] x = new int[-1];
        } catch (NegativeArraySizeException e){
            exceptions.add(e);
        }

        try { //8
            Set exampleleSet = new HashSet();
            Hashtable exampleTable = new Hashtable();
            exampleleSet.iterator().next();
            exampleTable.elements().nextElement();
        } catch (NoSuchElementException e){
            exceptions.add(e);
        }

        try { //9
            FileReader fl = new FileReader("test.txt");
        } catch (FileNotFoundException e){
            exceptions.add(e);
        }

        try { //10
            String s = "Tsenko";
            System.out.println(s.charAt(8));
        } catch (StringIndexOutOfBoundsException e){
            exceptions.add(e);
        }
    }
}
