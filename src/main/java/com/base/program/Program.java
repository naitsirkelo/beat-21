package com.base.program;

import com.base.objects.Card;
import com.base.objects.Deck;
import com.base.util.Calculations;
import com.base.util.Const;
import com.base.util.Print;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.base.util.Const.FILE;
import static com.base.util.Const.PATH;

public class Program {

    /**
     * mvn compile
     * mvn exec:java -Dexec.mainClass=com.base.program.Program
     * mvn exec:java -Dexec.mainClass=com.base.program.Program -Dexec.args=""
     * mvn exec:java -Dexec.mainClass=com.base.program.Program -Dexec.args="file cardFile_test.txt"
     * mvn exec:java -Dexec.mainClass=com.base.program.Program -Dexec.args="path C:\Users\olarsen\Documents\Prog\beat-21\src\main\resources\cardFile_test.txt"
     *
     * mvn test
     */
    public static void main(String[] args) throws IOException {

        String winner;
        String fileName;
        String filePath;

        List<Card> handSam = new ArrayList<>();
        List<Card> handDealer = new ArrayList<>();

        Deck deck = null;

        if (args != null && args.length == 2) {

            if (args[0].equals(FILE)) {
                fileName = args[1];
                deck = new Deck(fileName, FILE);

            } else if (args[0].equals(PATH)) {
                filePath = args[1];
                deck = new Deck(filePath, PATH);

            }
        } else {
            deck = new Deck();
        }

        // Krever opprettet stokk og minst 4 kort for å begynne.
        if (deck != null && deck.getCards().size() >= 4) {

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

            } else {

                // Begge har Blackjack - Sam vinner.
                if (scoreSam == Const.BLACKJACK && scoreDealer == Const.BLACKJACK) {
                    winner = Const.SAM;

                } else if (scoreSam == Const.BLACKJACK) {
                    winner = Const.SAM;

                } else if (scoreDealer == Const.BLACKJACK) {
                    winner = Const.DEALER;

                } else {    // Ingen har Blackjack

                    // Sam kan trekke kort sålenge total verdi av kort er < 17.
                    while (Calculations.canDrawCard(handSam)) {
                        handSam.add(deck.pop());
                    }
                    scoreSam = Calculations.getScore(handSam);

                    if (scoreSam == Const.BLACKJACK) {    // Sam har nøyaktig 21 - vinner.
                        winner = Const.SAM;

                    } else if (scoreSam >= Const.BUSTED_SCORE) {  // Sam har over 21 - taper.
                        winner = Const.DEALER;

                    } else {

                        // Dealer kan trekke kort sålenge de har total kortverdi mindre enn Sam sin verdi.
                        while (Calculations.getScore(handDealer) < scoreSam) {
                            handDealer.add(deck.pop());
                        }
                        scoreDealer = Calculations.getScore(handDealer);

                        if (scoreDealer == Const.BLACKJACK) { // Dealer har nøyaktig 21 - vinner.
                            winner = Const.DEALER;

                        } else if (scoreDealer >= Const.BUSTED_SCORE) { // Dealer har over 21 - taper.
                            winner = Const.SAM;

                        } else {

                            // ANTAGELSE: Lik sum til slutt ender i uavgjort.
                            if (scoreSam == scoreDealer) {
                                winner = "draw";

                            } else {
                                // Når ingen kan trekke flere kort kåres vinner med høyeste sum < 21.
                                winner = scoreSam > scoreDealer ? Const.SAM : Const.DEALER;
                            }
                        }
                    }
                }
            }

            Print.printEndOfGame(winner, handSam, handDealer);

        } else {
            System.out.println("Deck error."); // Required: Debug logger.
        }
    }
}
