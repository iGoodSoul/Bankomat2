package com.company.Card;


import com.company.Banks.Banks;

import java.math.BigDecimal;

public class CreditCard extends Card {
    private BigDecimal creditMoney;

    public CreditCard(BigDecimal moneyBalance, String ownerName, String pin, String number, Banks.Bank bank, BigDecimal creditMoney) {
        super(moneyBalance, ownerName, pin, number, bank);
        this.creditMoney = creditMoney;
    }

    public BigDecimal getCreditMoney() {
        return creditMoney;
    }

    public void setCreditMoney(BigDecimal creditMoney) {
        this.creditMoney = creditMoney;
    }
}

