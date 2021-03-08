package com.codegym.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Static modifiers: part 1

*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();

    static
    {
        labels.put(2.5, "lol");
        labels.put(1.5, "Angel");
        labels.put(0.5, "Angel");
        labels.put(3.5, "Nune");
        labels.put(4.5, "Kotio");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
