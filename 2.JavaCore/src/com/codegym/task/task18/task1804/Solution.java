package com.codegym.task.task18.task1804;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/* 
Rarest bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        //"D:\\codegym_read_text.txt"
        FileInputStream fileInputStream = new FileInputStream(scan.nextLine());
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        int[] counts = new int[256];
        for(byte x : bytes){
            counts[x]++;
        }

        int min = Integer.MAX_VALUE;
        for(int i : counts){
            if(i != 0 && i < min) min = i;
        }

        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == min) System.out.print(i + " ");
        }
        scan.close();
        fileInputStream.close();
    }
}
