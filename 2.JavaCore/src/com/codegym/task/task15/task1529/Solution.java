package com.codegym.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Mastering the static block

*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //write your code here
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //write your code here
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if(input.equals("helicopter")) result = new Helicopter();
        else if(input.equals("plane")){
            int passengers = Integer.parseInt(scan.nextLine());
            result = new Plane(passengers);
        }
        scan.close();
    }
}
