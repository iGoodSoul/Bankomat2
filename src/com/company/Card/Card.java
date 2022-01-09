package com.company.Card;

import com.company.Banks.Banks;

import java.math.BigDecimal;

public class Card {
    private BigDecimal moneyBalance;
    private String ownerName;
    private String pin; // private just pin, because previously you be angry when I use many getters and setter :)
    private String number;
    private Banks.Bank bank;


    public Card(BigDecimal moneyBalance, String ownerName, String pin, String number, Banks.Bank bank) {
        this.moneyBalance = moneyBalance;
        this.ownerName = ownerName;
        this.pin = pin;
        this.number = number;
        this.bank = bank;
    }

    public String getPin() {
        return pin;
    }

    public BigDecimal getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(BigDecimal moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public Banks.Bank getBank() {
        return bank;
    }
}