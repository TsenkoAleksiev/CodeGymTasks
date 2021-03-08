package com.codegym.task.task14.task1408;

public class EuropeanHen extends Hen implements Continent{

    public String continent = Continent.EUROPE;

    @Override
    public int getMonthlyEggCount() {
        return 40;
    }

    @Override
    public String getDescription() {
        return super.getDescription()
                + " I come from " + continent + ". I lay "
                + getMonthlyEggCount() + " eggs a month.";
    }
}
