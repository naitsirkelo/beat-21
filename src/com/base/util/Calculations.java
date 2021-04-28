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

}
