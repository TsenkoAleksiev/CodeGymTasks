package com.codegym.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Writing to a file from the console

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner scanConsole = new Scanner(System.in);
        FileWriter fileWriter = new FileWriter(scanConsole.nextLine());

        try {
            BufferedWriter bfr = new BufferedWriter(fileWriter);
            String input = scanConsole.nextLine();
            while(!input.equals("exit")){
                bfr.write(input);
                bfr.newLine();
                input = scanConsole.nextLine();
            }
            bfr.write("exit");
            bfr.close();
        }
        catch (Exception e){
            System.out.println("Can't write, something went wrong");
        }
        finally {
            scanConsole.close();
        }
    }
}
