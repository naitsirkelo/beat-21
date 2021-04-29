package com.base.objects;

import com.base.util.Calculations;
import com.base.util.Const;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

    public Deck(String fileName) throws IOException {

        Scanner inFile = new Scanner(new File(Const.RESOURCE_PATH + fileName));
        String cardString = "";

        while (inFile.hasNextLine()) {      // ANTAGELSE: Input skrives på én linje i tekstfil.
            cardString = inFile.nextLine();
        }
        inFile.close();

        cardString = cardString.replaceAll("\\s", "");
        String[] input = cardString.split(",");

        // Legger til kort bakfra for å få riktig rekkefølge.
        for (int i = input.length-1; i >= 0; i--) {

            String cardInput = input[i];

            String suit = cardInput.substring(0, 1);
            String value = cardInput.substring(1);

            if (Calculations.isInteger(value)) {
                cards.add(new Card(Integer.parseInt(value), Const.SUIT_VALUES.get(suit)));
            } else {
                cards.add(new Card(Const.CARD_VALUES.get(value), Const.SUIT_VALUES.get(suit)));
            }
        }
    }

    /**
     * Removes the Card at the top of the list of cards.
     *
     * @return Card object popped from list.
     */
    public Card pop() {

        if (cards.isEmpty()) {
            return null;
        }

        Card top = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);

        return top;
    }

}