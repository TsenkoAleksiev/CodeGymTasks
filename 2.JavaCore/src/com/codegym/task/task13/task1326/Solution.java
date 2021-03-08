package com.codegym.task.task13.task1326;

/* 
Sorting even numbers from a file

*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanConsole = new Scanner(System.in);
        ArrayList<Integer> intNums = new ArrayList<Integer>();
        try {
            Scanner scanFile = new Scanner(new FileInputStream(scanConsole.nextLine()));
            while(scanFile.hasNext()){
                intNums.add(Integer.parseInt(scanFile.nextLine()));
            }
            scanFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanConsole.close();
        }

        Collections.sort(intNums);

        intNums.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
    }
}
