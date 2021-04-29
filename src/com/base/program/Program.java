package com.base.program;

import com.base.objects.Card;
import com.base.objects.Deck;
import com.base.util.Calculations;
import com.base.util.Const;
import com.base.util.Print;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) throws IOException {

        String winner = "";

        List<Card> handSam = new ArrayList<>();
        List<Card> handDealer = new ArrayList<>();

        /**
         * TODO: CLI navn på fil.
         *
         * TODO: JavaDoc
         */

        System.out.println(args[0]);

        // ANTAGELSE: "taking the reference to the file" = referanse til navn på fil i resources og ikke path
        String fileName = "cardFile_test.txt";

        Deck deck;
        if (fileName.length() > 0) {
            deck = new Deck(fileName);
        } else {
            deck = new Deck();
        }

        // 4 kort gis ut til å begynne med, annenhvert kort, 2 til Sam og 2 til dealer.

        for (int i = 1; i < Const.INITIAL_CARDS; i++) {
            if (i % 2 != 0) {
                handSam.add(deck.pop());

            } else {
                handDealer.add(deck.pop());

            }
        }

        int scoreSam = Calculations.getScore(handSam);
        int scoreDealer = Calculations.getScore(handDealer);

        // Sjekker om begge har 22 (A + A) - Dealer vinner.
        if (scoreSam == Const.BUSTED_SCORE && scoreDealer == Const.BUSTED_SCORE) {
            winner = Const.DEALER;
        }

        // Begge har Blackjack - Sam vinner.
        if (scoreSam == Const.BLACKJACK && scoreDealer == Const.BLACKJACK) {
            winner = Const.SAM;

        } else if (scoreSam == Const.BLACKJACK) {
            winner = Const.SAM;

        } else if (scoreDealer == Const.BLACKJACK) {
            winner = Const.DEALER;
        }

        // Sam kan trekke kort sålenge total verdi av kort er < 17.
        while (Calculations.canDrawCard(handSam)) {
            handSam.add(deck.pop());
        }

        if (Calculations.getScore(handSam) == Const.BLACKJACK) {    // Sam har nøyaktig 21 - vinner.

            winner = Const.SAM;

        } else if (Calculations.getScore(handSam) >= Const.BUSTED_SCORE) {  // Sam har over 21 - taper.

            winner = Const.DEALER;

        } else {

            // Dealer kan trekke kort sålenge de har total verdi av kort mindre enn Sam sin totale verdi.
            while (Calculations.getScore(handDealer) < Calculations.getScore(handSam)) {
                handDealer.add(deck.pop());
            }

            if (Calculations.getScore(handDealer) == Const.BLACKJACK) { // Dealer har nøyaktig 21 - vinner.

                winner = Const.DEALER;

            } else if (Calculations.getScore(handDealer) >= Const.BUSTED_SCORE) { // Dealer har over 21 - taper.

                winner = Const.SAM;

            }

            scoreSam = Calculations.getScore(handSam);
            scoreDealer = Calculations.getScore(handDealer);

            // ANTAGELSE: Lik sum til slutt ender i uavgjort.
            if (scoreSam == scoreDealer) {
                winner = "draw";

            } else if (scoreSam < Const.BLACKJACK && scoreDealer < Const.BLACKJACK) {
                // Når ingen kan trekke flere kort kåres vinner med høyeste sum <= 21.
                winner = Calculations.getScore((handSam)) > Calculations.getScore(handDealer) ? Const.SAM : Const.DEALER;
            }

        }

        Print.printEndOfGame(winner, handSam, handDealer);

        System.out.println("\n"+Calculations.getScore(handSam));
        System.out.println(Calculations.getScore(handDealer));

        /**
         * Start
         *
         * Q: hva heter fil?    ANTAGELSE: READ FILE BY TAKING REFERENCE = NAMED REFERENCE, NOT PATH
         *
         *      Navn: hent fil i resources/navn med 52 kort, bestemt deck
         *      Blank: Opprett shuffled deck med 52 unike kort
         *
         * Standard:    Opprett spiller sam
         *              Opprett dealer dealer
         *

         */

    }

}
