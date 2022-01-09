package com.company;

import com.company.Atm.Atm;
import com.company.Banks.Banks;
import com.company.Card.Card;
import com.company.Card.CreditCard;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Card card1 = new Card(new BigDecimal("30000.45"), "Alex", "0123", "123456789", Banks.Bank.ALPHA_BANK);


        CreditCard card2 = new CreditCard(new BigDecimal("48657.12"), "Ignat", "6789", "789456123", Banks.Bank.ALPHA_BANK, new BigDecimal("0"));
        Atm.atmMenu(card2);  //credit card (pin 6789)
        //  Atm.atmMenu(card1);    // casual card (pin 0123)
    }
}
