package com.codegym.task.task14.task1408;

public class NorthAmericanHen extends Hen implements Continent{

    public String continent = Continent.NORTHAMERICA;

    @Override
    public int getMonthlyEggCount() {
        return 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription()
                + " I come from " + continent + ". I lay "
                + getMonthlyEggCount() + " eggs a month.";
    }
}
