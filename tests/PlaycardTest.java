import exceptions.RuleNotAvailableException;
import rules.Rule;
import dices.Dice;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 2. May 2017<br>
 * Purpose: solution to lab 02: Yahtzee game<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class PlaycardTest {

    private Playcard card1 = new Playcard("player1");
    private ArrayList<Dice> diceList = new ArrayList<>();

    private void rollDice(int d1, int d2, int d3, int d4, int d5) {
        diceList.clear();
        diceList.add(new Dice(d1));
        diceList.add(new Dice(d2));
        diceList.add(new Dice(d3));
        diceList.add(new Dice(d4));
        diceList.add(new Dice(d5));
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(card1.getName(), "player1");
    }

    @Test
    public void testCalculateTotalScore_MaxScore() throws Exception {
        //upper
        rollDice(1,1,1,1,1);
        card1.setRuleValue(Rule.ONE, diceList);
        rollDice(2,2,2,2,2);
        card1.setRuleValue(Rule.TWO, diceList);
        rollDice(3,3,3,3,3);
        card1.setRuleValue(Rule.THREE, diceList);
        rollDice(4,4,4,4,4);
        card1.setRuleValue(Rule.FOUR, diceList);
        rollDice(5,5,5,5,5);
        card1.setRuleValue(Rule.FIVE, diceList);
        rollDice(6,6,6,6,6);
        card1.setRuleValue(Rule.SIX, diceList);
        //lower
        rollDice(6,6,6,6,6);
        card1.setRuleValue(Rule.THREE_OF_A_KIND, diceList);
        rollDice(6,6,6,6,6);
        card1.setRuleValue(Rule.FOUR_OF_A_KIND, diceList);
        rollDice(3,3,3,2,2);
        card1.setRuleValue(Rule.FULL_HOUSE, diceList);
        rollDice(1,2,3,4,6);
        card1.setRuleValue(Rule.SMALL_STRAIGHT, diceList);
        rollDice(1,2,3,4,5);
        card1.setRuleValue(Rule.LARGE_STRAIGHT, diceList);
        rollDice(6,6,6,6,6);
        card1.setRuleValue(Rule.YAHTZEE, diceList);
        rollDice(6,6,6,6,6);
        card1.setRuleValue(Rule.CHANCE, diceList);

        assertEquals(card1.calculateTotalScore(), 375);
    }

    @Test
    public void testCalculateTotalScore_MinScore() throws Exception {
        //upper
        rollDice(2,2,2,2,2);
        card1.setRuleValue(Rule.ONE, diceList);
        rollDice(3,3,3,3,3);
        card1.setRuleValue(Rule.TWO, diceList);
        rollDice(4,4,4,4,4);
        card1.setRuleValue(Rule.THREE, diceList);
        rollDice(5,5,5,5,5);
        card1.setRuleValue(Rule.FOUR, diceList);
        rollDice(6,6,6,6,6);
        card1.setRuleValue(Rule.FIVE, diceList);
        rollDice(1,1,1,1,1);
        card1.setRuleValue(Rule.SIX, diceList);
        //lower
        rollDice(1,2,3,4,5);
        card1.setRuleValue(Rule.THREE_OF_A_KIND, diceList);
        rollDice(1,2,3,4,5);
        card1.setRuleValue(Rule.FOUR_OF_A_KIND, diceList);
        rollDice(1,2,3,4,5);
        card1.setRuleValue(Rule.FULL_HOUSE, diceList);
        rollDice(1,3,4,4,6);
        card1.setRuleValue(Rule.SMALL_STRAIGHT, diceList);
        rollDice(1,3,4,4,6);
        card1.setRuleValue(Rule.LARGE_STRAIGHT, diceList);
        rollDice(1,3,4,4,6);
        card1.setRuleValue(Rule.YAHTZEE, diceList);
        rollDice(1,1,1,1,1);
        card1.setRuleValue(Rule.CHANCE, diceList);

        assertEquals(card1.calculateTotalScore(), 5);
    }


    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateTotalScore_throwsRuleNotAvailableException() throws Exception {
        rollDice(2,2,2,2,2);
        card1.setRuleValue(Rule.ONE, diceList);
        rollDice(3,3,3,3,3);
        card1.setRuleValue(Rule.ONE, diceList);
    }
}
