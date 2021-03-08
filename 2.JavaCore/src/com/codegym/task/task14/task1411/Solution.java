package com.codegym.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, loser, coder and programmer

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = reader.readLine();

        // Here's the loop for reading the keys. Item 1
        while(key.equals("user")
                || key.equals("programmer") || key.equals("loser") || key.equals("coder")){
            // Create an object. Item 2
            switch (key){
                case "user":
                    Person user = new Person.User();
                    break;
                case "programmer":
                    Person programmer = new Person.Programmer();
                    break;
                case "loser":
                    Person loser = new Person.Loser();
                    break;
                case "coder":
                    Person coder = new Person.Coder();
                    break;
            }

            doWork(person); // Call doWork
            key = reader.readLine();
        }
        reader.close();
    }

    public static void doWork(Person person) {
        // Item 3
        if(person instanceof Person.User) ((Person.User) person).live();
        else if(person instanceof Person.Coder) ((Person.Coder) person).writeCode();
        else if(person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        else if(person instanceof Person.Programmer) ((Person.Programmer) person).enjoy();
    }
}
