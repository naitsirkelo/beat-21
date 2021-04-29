import com.base.objects.Card;
import com.base.util.Calculations;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestHand {

    List<Card> testHand = new ArrayList<>();

    /**
     * Populating hand of cards to be tested against.
     */
    public TestHand() {

        int[] testValue = {2, 1, 13, 10};
        int[] testSuit = {1, 2, 3, 4};

        // C2, DA, HK, S10
        for (int i = 0; i < 4; i++) {
            testHand.add(new Card(testValue[i], testSuit[i]));
        }

    }

    /**
     * Checks that the correct total score is returned based on the already fille hand of cards.
     */
    @Test
    public void testTotalScoreOfHand() {
        assertEquals("Failed on getScore(),", Calculations.getScore(testHand), 33);
    }

    /**
     * Checks that the player can draw a new card based on the filled hand of cards.
     * Requires total score < 17.
     */
    @Test
    public void testHandCanDrawNewCard() {
        assertFalse("Failed on canDrawCard(),", Calculations.canDrawCard(testHand));
    }

}