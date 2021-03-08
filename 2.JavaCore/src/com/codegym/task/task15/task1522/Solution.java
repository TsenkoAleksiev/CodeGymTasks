package com.codegym.task.task15.task1522;

import java.util.Scanner;

/* 
Reinforce the singleton pattern

*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static
    {
        readKeyFromConsoleAndInitPlanet();

    }
    // Add static block here

    public static void readKeyFromConsoleAndInitPlanet() {
        // Implement step #5 here
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        thePlanet = null;
        switch (input){
            case Planet.EARTH:
                thePlanet = Earth.getInstance();
                break;
            case Planet.MOON:
                thePlanet = Moon.getInstance();
                break;
            case Planet.SUN:
                thePlanet = Sun.getInstance();
                break;
        }
    }
}
