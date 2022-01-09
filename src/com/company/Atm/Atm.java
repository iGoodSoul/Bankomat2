package com.company.Atm;

import com.company.Banks.Banks;
import com.company.Card.Card;
import com.company.Card.CreditCard;

import java.math.BigDecimal;
import java.util.Scanner;


public class Atm {
    public Atm(Banks.Bank bank) {
        this.bank = bank;
    }

    Banks.Bank bank;
    static Atm atm1 = new Atm(Banks.Bank.ALPHA_BANK); //Atm bank


    private static void pin(Card card) {
        Scanner sc1 = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Insert pin: ");
            String insertPin = sc1.nextLine();
            if (insertPin.equals(card.getPin())) {
                System.out.println("Your pin correct");
                i = 4;

            } else {
                System.out.println("Incorrect pin");
            }
        }
    }


    private static void loan(Card card) {
        if (card instanceof CreditCard) {         //Card type comparison
            Scanner sc4 = new Scanner(System.in);
            System.out.println("Do you want to take out a loan? y/n");
            String sc1 = sc4.nextLine();
            if (sc1.equals("y")) {
                System.out.println("How much money you want take?");
                String sc = sc4.nextLine();
                BigDecimal creditMoney = new BigDecimal(sc);
                ((CreditCard) card).setCreditMoney(creditMoney);
                System.out.println("You took out a loan " + ((CreditCard) card).getCreditMoney() + " and don't forget about loan payments");
                card.setMoneyBalance(card.getMoneyBalance().add(creditMoney));
            } else return;
        } else {
            System.out.println("You can't get a loan, you need a credit card");
        }
    }

    private static void loanBalance(Card card) {
        if (card instanceof CreditCard) {
            System.out.println("Your loan balance value: " + ((CreditCard) card).getCreditMoney());
        } else {
            System.out.println("Your card is not credit");
        }
        return;
    }

    private static void checkBalance(Card card) {                    //check balance method
        System.out.println("Your balance = " + card.getMoneyBalance());
    }

    private static void withdrawMoney(Card card) {
        Scanner sc3 = new Scanner(System.in);
        System.out.println("How many money you want withdraw? ");
        String sc = sc3.nextLine();
        BigDecimal withdraw = new BigDecimal(sc);
        if (withdraw.compareTo(card.getMoneyBalance()) >= 0) {
            if (card instanceof CreditCard) {
                loan(card);
            } else {
                System.out.println("You don't have that much money ");
            }
        } else {
            System.out.println("Take your " + sc);
            card.setMoneyBalance(card.getMoneyBalance().subtract(withdraw));
        }
    }

    public static void atmMenu(Card card) {     
        if (atm1.bank.equals(card.getBank())) {
            int a = 1;
            while (a > 0) {
                pin(card);
                for (int i = 0; i < 100; i++) {
                    System.out.println("1: Check balance");
                    System.out.println("2: Withdraw cash");
                    System.out.println("3: Get loan");
                    System.out.println("4: Check loan balance");
                    System.out.println("Any: exit");
                    Scanner sc2 = new Scanner(System.in);
                    switch (sc2.nextInt()) {

                        case (1):
                            checkBalance(card);
                            break;
                        case (2):
                            withdrawMoney(card);
                            break;
                        case (3):
                            loan(card);
                            break;
                        case (4):
                            loanBalance(card);
                            break;
                        default:
                            System.out.println("Take your card, have a nice day");
                            return;
                    }

                }

            }
        } else {
            System.out.println("You can't use this Atm, use your bank atm");
            return;
        }
    }
}




