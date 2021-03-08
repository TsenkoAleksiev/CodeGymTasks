package com.codegym.task.task14.task1408;

public class AfricanHen extends Hen implements Continent{

    private String continent = Continent.AFRICA;

    @Override
    public int getMonthlyEggCount() {
        return 20;
    }

    @Override
    public String getDescription() {
        return super.getDescription()
                + " I come from " + continent + ". I lay "
                + getMonthlyEggCount() + " eggs a month.";
    }
}
