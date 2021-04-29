package com.base.util;

import com.base.objects.Card;

import java.util.List;

public class Calculations {

    public static int getScore(List<Card> hand) {

        int score = 0;

        for (Card c : hand) {
            score += c.getCardScore();
        }

        return score;
    }

    public static boolean canDrawCard(List<Card> hand) {

        return (getScore(hand) < Const.MAX_SCORE_NEW_CARD);
    }

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
