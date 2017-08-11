package rules;

import dices.Dice;
import exceptions.RuleNotAvailableException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static rules.Rule.YAHTZEE;
import static org.junit.Assert.*;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: test for class Yahtzee.java<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class YahtzeeTest {

    // diceListOne is not a FullHouse-Dice-List
    private ArrayList<Dice> diceListOne = new ArrayList<>();

    // diceListOne is not a FullHouse-Dice-List
    private ArrayList<Dice> diceListTwo = new ArrayList<>();

    private Yahtzee yahtzee = new Yahtzee(YAHTZEE);

    @Before
    public void setUp() throws Exception {
        // adds five Dice objects to diceList, which creates not a
        // Yahtzee-Dice-List
        diceListOne.add(new Dice(2));
        diceListOne.add(new Dice(3));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(4));

        // adds five Dice objects to diceListTwo, which creates a
        // Yahtzee-Dice-List
        diceListTwo.add(new Dice(6));
        diceListTwo.add(new Dice(6));
        diceListTwo.add(new Dice(6));
        diceListTwo.add(new Dice(6));
        diceListTwo.add(new Dice(6));

    }

    @Test
    public void testCalculateValue_isNotAYahtzee() throws RuleNotAvailableException {
        // Checks, if the value of the Yahtzee-Rule is 0,
        // because it is not a yahtzee
        yahtzee.calculateValue(diceListOne);
        assertEquals(yahtzee.getValue(), 0);
    }

    @Test
    public void testCalculateValue_isAYahtzee() throws RuleNotAvailableException {
        // Checks, if the value of the Yahtzee-Rule is 50,
        // because it is not a yahtzee
        yahtzee.calculateValue(diceListTwo);
        assertEquals(yahtzee.getValue(), 50);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableException() throws RuleNotAvailableException {
        // Checks, if Yahtzee-rule is supposed to be used more than once
        yahtzee.calculateValue(diceListTwo);
        yahtzee.calculateValue(diceListTwo);
    }

    @Test
    public void testGetValue() throws Exception {
        // Checks if getValue() returns the correct value of 25
        yahtzee.calculateValue(diceListTwo);
        assertEquals(yahtzee.getValue(), 50);
    }

    @Test
    public void testSetValue() throws Exception {
        // Checks if setValue() stores the integer 10 in value variable
        yahtzee.setValue(10);
        assertEquals(yahtzee.getValue(), 10);
    }

    @Test
    public void testGetRule() throws Exception {
        // Checks if getRule() returns the correct Rule-Enum for FULL_HOUSE
        assertEquals(yahtzee.getRule(), YAHTZEE);
    }

    @Test
    public void testToString() throws Exception {
        // Checks if toString() returns correct string-representation of a FullHouse
        // object which should look like this: "YAHTZEE: 50"
        yahtzee.calculateValue(diceListTwo);
        assertEquals(yahtzee.toString(), "YAHTZEE: 50");
    }
}
