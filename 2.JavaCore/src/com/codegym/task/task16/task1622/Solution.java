package com.codegym.task.task16.task1622;

/* 
Consecutive threads

*/

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            Thread temp = new SleepingThread();
            //write your code here
            temp.join();
            System.out.println(temp);
        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countdownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public synchronized void run() {
            Thread current = Thread.currentThread();
            if(current.isInterrupted()) System.out.println("Thread interrupted");

            while (!current.isInterrupted()) {
                System.out.println(this);
                if (--countdownIndex == 1) return;
                //write your code here
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public String toString() {
            return "#" + getName() + ": " + countdownIndex;
        }
    }
}
