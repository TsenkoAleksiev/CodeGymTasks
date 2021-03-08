package com.codegym.task.task14.task1420;

/* 
GCD

*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        int gcd = 0;
        if(a > 0 && b > 0){
            for(int i = 1; i < Math.max(a, b); i++){
                if(a % i == 0 && b % i == 0) gcd = i;
            }
        } else {
            throw new Exception("Exception");
        }
        System.out.println(gcd);
    }
}
