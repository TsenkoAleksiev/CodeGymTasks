package com.codegym.task.task18.task1803;

import java.io.FileInputStream;
import java.util.*;

/* 
Most frequent bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        //"D:\\codegym_read_text.txt"
        FileInputStream fileInputStream = new FileInputStream(scan.nextLine());
        byte[] bytes = new byte[fileInputStream.available()]; //get the length of the file
        fileInputStream.read(bytes); //read the bytes

        int[] counts = new int[256];
        for(byte x : bytes){
            counts[x]++;
        }

        int max = Integer.MIN_VALUE;
        for(int x : counts){
            if(x > max) max = x;
        }

        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == max) System.out.print(i + " ");
        }

        scan.close();
        fileInputStream.close();
    }
}
