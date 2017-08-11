package rules;

import dices.Dice;
import exceptions.RuleNotAvailableException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static rules.Rule.LARGE_STRAIGHT;
import static org.junit.Assert.*;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: test for class LargeStraight.java<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class LargeStraightTest {

    // diceListOne is not a LargeStraight-Dice-List
    private ArrayList<Dice> diceListOne = new ArrayList<>();

    // diceListOne is a LargeStraight-Dice-List from 1 to 5
    private ArrayList<Dice> diceListTwo = new ArrayList<>();

    // diceListOne is a LargeStraight-Dice-List from 2 to 6
    private ArrayList<Dice> diceListThree = new ArrayList<>();

    private LargeStraight largeStraight = new LargeStraight(LARGE_STRAIGHT);

    @Before
    public void setUp() throws Exception {
        // adds five Dice objects to diceList, which creates not a
        // Large-Straight-Dice-List
        diceListOne.add(new Dice(2));
        diceListOne.add(new Dice(2));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(1));

        // adds five Dice objects to diceListTwo, which creates a
        // Large-Straight-Dice-List from 1 to 5
        diceListTwo.add(new Dice(1));
        diceListTwo.add(new Dice(4));
        diceListTwo.add(new Dice(3));
        diceListTwo.add(new Dice(5));
        diceListTwo.add(new Dice(2));

        // adds five Dice objects to diceListTwo, which creates a
        // Large-Straight-Dice-List from 2 to 6
        diceListThree.add(new Dice(2));
        diceListThree.add(new Dice(6));
        diceListThree.add(new Dice(3));
        diceListThree.add(new Dice(5));
        diceListThree.add(new Dice(4));
    }

    @Test
    public void testCalculateValue_isNotALargeStraight() throws RuleNotAvailableException {
        // Checks, if the value of the Large-Straight-Rule is 0,
        // because it is not a large straight
        largeStraight.calculateValue(diceListOne);
        assertEquals(largeStraight.getValue(), 0);
    }

    @Test
    public void testCalculateValue_isALargeStraightOneToFive() throws RuleNotAvailableException {
        // Checks, if the value of the Small-Straight-Rule is 40,
        // because it is a large straight from 1 to 5
        largeStraight.calculateValue(diceListTwo);
        assertEquals(largeStraight.getValue(), 40);
    }

    @Test
    public void testCalculateValue_isALargeStraightTwoToSix() throws RuleNotAvailableException {
        // Checks, if the value of the Small-Straight-Rule is 40,
        // because it is a large straight from 2 to 6
        largeStraight.calculateValue(diceListThree);
        assertEquals(largeStraight.getValue(), 40);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableException() throws RuleNotAvailableException {
        // Checks, if Large-Straight-Rule is supposed to be used more than once
        largeStraight.calculateValue(diceListTwo);
        largeStraight.calculateValue(diceListTwo);
    }

    @Test
    public void testGetValue() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 40
        largeStraight.calculateValue(diceListTwo);
        assertEquals(largeStraight.getValue(), 40);
    }

    @Test
    public void testSetValue() {
        // Checks if setValue() stores the integer 10 in value variable
        largeStraight.setValue(10);
        assertEquals(largeStraight.getValue(), 10);
    }

    @Test
    public void testGetRule() {
        // Checks if getRule() returns the correct Rule-Enum for LARGE_STRAIGHT
        assertEquals(largeStraight.getRule(), LARGE_STRAIGHT);
    }

    @Test
    public void testToString() throws RuleNotAvailableException {
        // Checks if toString() returns correct string-representation of a FullHouse
        // object which should look like this: "LARGE_STRAIGHT: 40"
        largeStraight.calculateValue(diceListTwo);
        assertEquals(largeStraight.toString(), "LARGE_STRAIGHT: 40");
    }
}
