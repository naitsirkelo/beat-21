import static org.junit.Assert.*;

import com.base.objects.Card;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCards {

    List<Card> testHand = new ArrayList<>();

    /**
     * Populating hand of cards to be tested against.
     */
    public TestCards() {

        int[] testValue = {2, 1, 13, 10};
        int[] testSuit = {1, 2, 3, 4};

        // C2, DA, HK, S10
        for (int i = 0; i < 4; i++) {
            testHand.add(new Card(testValue[i], testSuit[i]));
        }
    }

    /**
     * Checks that all cards in the hand have correctly formatted names for printing.
     */
    @Test
    public void testGettingShortCardNames() {
        assertEquals("Failed on getName(),",  testHand.get(0).getName(), "C2");
        assertEquals("Failed on getName(),",  testHand.get(1).getName(), "DA");
        assertEquals("Failed on getName(),",  testHand.get(2).getName(), "HK");
        assertEquals("Failed on getName(),",  testHand.get(3).getName(), "S10");
    }

    /**
     * Checks that all cards are given correct scores given their value.
     */
    @Test
    public void testGettingCardScore() {
        assertEquals("Failed on getCardScore(),",  testHand.get(0).getCardScore(), 2);
        assertEquals("Failed on getCardScore(),",  testHand.get(1).getCardScore(), 11);
        assertEquals("Failed on getCardScore(),",  testHand.get(2).getCardScore(), 10);
        assertEquals("Failed on getCardScore(),",  testHand.get(3).getCardScore(), 10);
    }

}