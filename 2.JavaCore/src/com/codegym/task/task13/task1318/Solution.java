package com.codegym.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Reading a file

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream myFile = new FileInputStream(br.readLine());
        try
        {
            Scanner scanFile = new Scanner(myFile);
            while(myFile.available() > 0){
                int fileData = myFile.read();
                System.out.print((char)fileData);
            }
            scanFile.close();
        }
        catch (Exception e)
        {
            System.out.println("Empty file or something went wrong!");
        }
        finally {
            br.close();
            myFile.close();
        }
    }
}