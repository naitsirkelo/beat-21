package com.base.objects;

import com.base.util.Calculations;
import com.base.util.Const;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import static com.base.util.Const.FILE;
import static com.base.util.Const.PATH;

public class Deck {

    private final List<Card> cards = new ArrayList<>();

    /**
     * Default Deck constructor, populating List of Card objects and shuffling order.
     */
    public Deck() {

        for (int i = 1; i <= Const.SUITS; i++) {

            for (int j = Const.MIN_VALUES; j <= Const.MAX_VALUES; j++) {

                cards.add(new Card(j, i));
            }
        }
        Collections.shuffle(cards);
    }

    /**
     * Deck constructor with file name/path, populating List of Card objects.
     * @param fileInput file name or absolute path.
     * @param type String determining whether to check for file name or absolute path.
     * @throws IOException to be caught on file read.
     */
    public Deck(String fileInput, String type) throws IOException {

        Scanner inFile = null;
        switch (type) {
            case FILE:
                File inputFile = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(fileInput)).getFile());
                inFile = new Scanner(inputFile);
                break;
            case PATH:
                inFile = new Scanner(new File(fileInput));
                break;
            default:
                break;
        }

        if (inFile != null) {
            String[] input = readCardInputFromFile(inFile);

            // Legger til kort bakfra for å få riktig rekkefølge.
            for (int i = input.length - 1; i >= 0; i--) {

                String cardInput = input[i];

                String suit = cardInput.substring(0, 1);
                String value = cardInput.substring(1);

                if (Calculations.isInteger(value)) {
                    cards.add(new Card(Integer.parseInt(value), Const.SUIT_VALUES.get(suit)));
                } else {
                    cards.add(new Card(Const.CARD_VALUES.get(value), Const.SUIT_VALUES.get(suit)));
                }
            }

        } else {
            System.out.println("File read error."); // Required: Debug logger.
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

    public static String[] readCardInputFromFile(Scanner inFile) {
        String cardString = "";

        while (inFile.hasNextLine()) {      // ANTAGELSE: Input skrives på én linje i tekstfil.
            cardString = inFile.nextLine();
        }
        inFile.close();

        cardString = cardString.replaceAll("\\s", "");
        return cardString.split(",");
    }

    public List<Card> getCards() {
        return cards;
    }

}