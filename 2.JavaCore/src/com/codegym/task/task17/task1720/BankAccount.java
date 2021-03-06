package com.codegym.task.task17.task1720;

import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal balance;
    private String owner;

    public BankAccount(String owner) {
        this(BigDecimal.ZERO, owner);
    }

    public BankAccount(BigDecimal balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public synchronized void deposit(BigDecimal money) {
        BigDecimal newBalance = this.balance.add(money);
        System.out.println("Deposit " + money + ", account balance " + newBalance);
        balance = newBalance;
    }

    public synchronized void withdraw(BigDecimal money) throws NotEnoughMoneyException {
        BigDecimal newBalance = this.balance.subtract(money);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new NotEnoughMoneyException();

        this.balance = newBalance;
        System.out.println("Spend " + money + ", account balance " + this.balance);
    }

    public void deposit(String money) {
        deposit(new BigDecimal(money));
    }

    public void withdraw(String money) throws NotEnoughMoneyException {
        withdraw(new BigDecimal(money));
    }
}
