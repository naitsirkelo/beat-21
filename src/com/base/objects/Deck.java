package com.base.objects;

import com.base.util.Const;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck() {

        for (int i = 1; i <= Const.SUITS; i++) {

            for (int j = Const.MIN_VALUES; j <= Const.MAX_VALUES; j++) {

                cards.add(new Card(j, i));
            }
        }
        Collections.shuffle(cards);
    }

    public Deck(String fileName) {

        /**
         * Test input fra .txt: "CA, D5, H9, HQ, S8"
         *
         * Skal gi output:
         *
         * sam
         * sam: CA, H9
         * dealer: D5, HQ, S8
         *
         */
        //Collections.shuffle(cards);
    }

    public int deckSize() {
        return cards.size();
    }

    public Card pop() {

        if (cards.isEmpty()) {
            return null;
        }

        Card top = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);

        return top;
    }

}