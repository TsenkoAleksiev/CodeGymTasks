package com.codegym.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static{
        Thread one = new Thread(){
            @Override
            public void run(){
                while(true){}
            }
        };
        threads.add(one);

        Thread two = new Thread(){
            @Override
            public void run(){
                if(isInterrupted()) System.out.println("InterruptedException");
            }
        };
        threads.add(two);

        Thread three = new Thread(){
            @Override
            public void run(){
                try{
                    while(true){
                        System.out.println("Hurray");
                        Thread.sleep(500);
                    }
                }catch(Exception e){}
            }
        };
        threads.add(three);

        Thread four = new ThreadFour();

        threads.add(four);

        Thread five = new Thread(){
            @Override
            public void run(){
                Scanner scan = new Scanner(System.in);
                int sum = 0;
                String input = scan.nextLine();
                while(!input.equals("N")){
                    sum += Integer.parseInt(input);
                    input = scan.nextLine();
                }
                System.out.println(sum);
            }
        };
        threads.add(five);

    }

    public static void main(String[] args) {

    }

    public static class ThreadFour extends Thread implements Message{

        private volatile boolean isRunning = true;

        @Override
        public void showWarning() {
            isRunning = false;
        }

        @Override
        public void run(){
            while (isRunning);
        }
    }

}