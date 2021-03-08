package com.codegym.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
File in a static block

*/

public class Solution {
    public static List<String> lines = new ArrayList<>();

    static
    {
        try {
            FileReader fr = new FileReader(Statics.FILE_NAME);
            Scanner scan = new Scanner(fr);
            while(scan.hasNextLine()){
                lines.add(scan.nextLine());
            }

            fr.close();
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
