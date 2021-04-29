import com.base.objects.Card;
import com.base.objects.Deck;
import com.base.util.Const;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestDeck {

    /**
     * Creating a new deck with no input string for file name.
     */
    @Test
    public void testCreatingDeckWithNoFileChosen() {
        Deck randomDeck = new Deck();
        assertEquals("Failed on size of random deck(),",  randomDeck.getCards().size(), 52);
    }

    /**
     * Creates new deck based on text file, with name decided from input.
     * @throws IOException - Scanner with new File()
     */
    @Test
    public void testCreatingDeckWithFileChosen() throws IOException {
        Deck fileInputDeck = new Deck("cardFile_test.txt");
        assertEquals("Failed on size of input deck(),",  fileInputDeck.getCards().size(), 5);
    }

    /**
     * Checks that cards are read correctly from file into string array.
     * @throws IOException - Scanner with new File()
     */
    @Test
    public void testReadingCardsFromFile() throws IOException {
        Scanner inFile = new Scanner(new File(Const.RESOURCE_PATH + "cardFile_test.txt"));
        String[] testArray = Deck.readCardInputFromFile(inFile);

        String[] expectedArray = {"CA", "D5", "H9", "HQ", "S8"};

        assertArrayEquals("Failed on reading string[] from file,",  testArray, expectedArray);
    }

    /**
     * Tries to retrieve the top card in the deck built from input string.
     * @throws IOException - Scanner with new File()
     */
    @Test
    public void testRetrieveCardFromTopOfDeck() throws IOException {
        Deck fileInputDeck = new Deck("cardFile_test.txt");

        String expectedCardName = "CA";

        Card poppedCard = fileInputDeck.pop();

        assertEquals("Failed on pop(),",  poppedCard.getName(), expectedCardName);
    }

    /**
     * Counts deck size, removes one card and counts new size.
     */
    @Test
    public void testRemoveCardFromTopOfDeck() {
        Deck randomDeck = new Deck();
        List<Card> cards = randomDeck.getCards();

        assertEquals("Failed on counting deck size,", cards.size(), 52);

        randomDeck.pop();

        cards = randomDeck.getCards();

        assertEquals("Failed on counting deck size,", cards.size(), 51);
    }

}