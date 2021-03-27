package com.codegym.task.task17.task1721;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Transactionality

*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, CorruptedDataException {
        Scanner scanConsole = new Scanner(System.in);
        String fileNameOne = scanConsole.nextLine();
        String fileNameTwo = scanConsole.nextLine();
        Scanner scanFile = new Scanner(new File(fileNameOne));
        while(scanFile.hasNextLine()){
            allLines.add(scanFile.nextLine());
        }
        scanFile = new Scanner(new File(fileNameTwo));
        while(scanFile.hasNextLine()){
            linesForRemoval.add(scanFile.nextLine());
        }
        scanConsole.close();
        scanFile.close();

        Solution sl = new Solution();
        sl.joinData();
    }

    public void joinData() throws CorruptedDataException {

        int counter = 0;

        for(String line : linesForRemoval){
            if(allLines.contains(line)) counter++;
        }

        if(counter == linesForRemoval.size()){
            for(String line : linesForRemoval){
                allLines.remove(line);
            }
        }else{
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
