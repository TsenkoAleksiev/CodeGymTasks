package com.codegym.task.task14.task1404;

/* 
Cats

*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //write your code here
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while(!input.equals("")){
            System.out.println(CatFactory.getCatByKey(input));
            input = scan.nextLine();
        }
        scan.close();

    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("feral".equals(key)) {
                cat = new MeanCat("Claws");
            } else if ("miss".equals(key)) {
                cat = new NiceCat("Missy");
            } else if ("smudge".equals(key)) {
                cat = new NiceCat("Smudgey");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "I'm " + getName() + ", an alley cat";
        }
    }

    static class MeanCat extends Cat {
        MeanCat(String name) {
            super(name);
        }

        public String toString() {
            return "I'm " + getName() + ", and I'm going to claw your eyes out";
        }
    }

    static class NiceCat extends Cat {
        NiceCat(String name) {
            super(name);
        }

        public String toString() {
            return "I'm a nice kitten named " + getName();
        }
    }
}
