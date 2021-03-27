package com.codegym.task.task18.task1805;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* 
Sorting bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        //"D:\\codegym_read_text.txt"
        FileInputStream fileInputStream = new FileInputStream(scan.nextLine());
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        Arrays.sort(bytes);

        Set<Byte> byteSet = new HashSet<Byte>();

        for(byte b : bytes){
            byteSet.add(b);
        }
        byteSet.stream().sorted().forEach(i -> System.out.print(i + " "));
        scan.close();
        fileInputStream.close();
    }
}
