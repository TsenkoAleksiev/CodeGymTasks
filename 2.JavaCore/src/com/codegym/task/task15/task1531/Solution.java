package com.codegym.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Factorial

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //write your code here
        BigDecimal factorial = new BigDecimal("1");
        if(n < 0) return "0";
        else if(n == 0) return "1";
        else{
            for(int i = 1; i <= n; i++){
                factorial = factorial.multiply(BigDecimal.valueOf(i));
            }
            return factorial.toString();
        }
    }
}
