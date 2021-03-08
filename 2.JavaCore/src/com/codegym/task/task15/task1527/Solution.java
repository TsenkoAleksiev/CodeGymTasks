package com.codegym.task.task15.task1527;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Request parser

*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String url = scan.nextLine();
//        String url = "http://codegym.cc/alpha/index.html?lvl=15&view&name=Amigo";
        String subStr = url.substring(url.indexOf("?") + 1);

        Pattern p = Pattern.compile("(\\w+)");
        Pattern doublPatt = Pattern.compile("([0-9]+\\.[0-9]+)");
        Matcher doublMatch = doublPatt.matcher(subStr);

        Matcher m = p.matcher(subStr);
        double d = 0;
        String validToken = "";
        String doubleToken = "";
        List<Object> obj = new ArrayList<Object>();
        while(m.find()){
            validToken = m.group();
            if(doublMatch.find()){
                try{
                    doubleToken = doublMatch.group(1);
                    d = Double.parseDouble(doubleToken);
                    if(!((d % 1) == 0)){
                        obj.add(d);
                    }
                }catch(Exception e){

                }
            }
            char ch = validToken.toCharArray()[0];
            if(Character.isLowerCase(ch)) obj.add(validToken);
        }
        for(Object o : obj){
            if(!(o instanceof Double)) System.out.print(o + " ");
        }
        for(Object o : obj){
            if(o instanceof Double) {
                System.out.println();
                alert(d);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
