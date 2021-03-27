package com.codegym.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Minimum byte

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scan.nextLine());
        int min = Integer.MAX_VALUE;
        int currentByte = 0;
        while(fileInputStream.available() > 0){
            currentByte = fileInputStream.read();
            if(currentByte < min) min = currentByte;
        }
        System.out.println(min);
        scan.close();
        fileInputStream.close();
    }
}
