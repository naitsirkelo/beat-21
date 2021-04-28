package com.base.objects;

import com.base.util.Const;

public class Card {

    private final int score;

    private final String shortName;

    public Card(int v, int s) {

        if (v == 1) {
            score = 11;
            shortName = Const.SUITS_SHORT[s-1] + Const.VALUE_NAMES[v-1];
        }
        else if (v > 10) {
            score = 10;
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
