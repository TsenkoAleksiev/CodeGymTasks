package com.codegym.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Maximum byte

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String fileName = scan.nextLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int max = 0;
        int currentByte = fileInputStream.read();
        while(currentByte > 0){
            if(currentByte > max) max = currentByte;
            currentByte = fileInputStream.read();
        }
        System.out.println(max);
        fileInputStream.close();
    }
}
