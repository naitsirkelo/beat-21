package com.base.objects;

import com.base.util.Const;

public class Card {

    private final int score;

    private final String shortName;

    /**
     * Creating new unique card, given it's value and suit. Value = score, except Ace = 11 and face = 10.
     * @param v Value, 1-13
     * @param s Suit, 1-4
     */
    public Card(int v, int s) {

        if (v == Const.ACE) {
            score = Const.ACE_SCORE;
            shortName = Const.SUITS_SHORT[s-1] + Const.VALUE_NAMES[v-1];
        }
        else if (v > Const.FACE_SCORE) {
            score = Const.FACE_SCORE;
            shortName = Const.SUITS_SHORT[s-1] + Const.VALUE_NAMES[v-1];
        }
        else {
            score = v;
            shortName = Const.SUITS_SHORT[s-1] + v;
        }
    }

    public int getCardScore() {
        return score;
    }

    public String getName() {
        return shortName;
    }
}
