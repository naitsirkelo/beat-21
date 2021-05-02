package com.base.util;

import com.base.objects.Card;

import java.util.List;

public class Calculations {

    /**
     * Counts total value of cards in given hand.
     * @param hand List of Cards objects
     * @return integer sum
     */
    public static int getScore(List<Card> hand) {

        int score = 0;

        for (Card c : hand) {
            score += c.getCardScore();
        }

        return score;
    }

    /**
     * Checks if player can draw new card given their card sum.
     * @param hand List of Cards objects to be totalled.
     * @return true/false
     */
    public static boolean canDrawCard(List<Card> hand) {

        return (getScore(hand) < Const.MAX_SCORE_NEW_CARD);
    }

    /**
     * Checks if string input can be converted to a valid integer.
     * @param str String to be checked.
     * @return true/false
     */
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}
