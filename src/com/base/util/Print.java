package com.base.util;

import com.base.objects.Card;

import java.util.List;

public class Print {

    public static void printHand(List<Card> hand) {

        for (int i = 0; i < hand.size() - 1; i++) {
            System.out.print(hand.get(i).getName() + ", ");
        }
        System.out.print(hand.get(hand.size() - 1).getName());
    }

    public static void printEndOfGame(String winner, List<Card> handSam, List<Card> handDealer) {
        System.out.print(winner);
        System.out.print("\n" + Const.SAM + ": ");     Print.printHand(handSam);
        System.out.print("\n" + Const.DEALER + ": ");  Print.printHand(handDealer);
    }
}
