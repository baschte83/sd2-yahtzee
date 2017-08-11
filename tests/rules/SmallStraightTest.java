package rules;

import dices.Dice;
import exceptions.RuleNotAvailableException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static rules.Rule.SMALL_STRAIGHT;
import static org.junit.Assert.*;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: test for class SmallStraight.java<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class SmallStraightTest {

    // diceListOne is not a SmallStraight-Dice-List
    private ArrayList<Dice> diceListOne = new ArrayList<>();

    // diceListOne is a SmallStraight-Dice-List from 1 to 4
    private ArrayList<Dice> diceListTwo = new ArrayList<>();

    // diceListOne is a SmallStraight-Dice-List from 2 to 5
    private ArrayList<Dice> diceListThree = new ArrayList<>();

    // diceListOne is a SmallStraight-Dice-List from 3 to 6
    private ArrayList<Dice> diceListFour = new ArrayList<>();

    private SmallStraight smallStraight = new SmallStraight(SMALL_STRAIGHT);

    @Before
    public void setUp() throws Exception {
        // adds five Dice objects to diceList, which creates not a
        // Small-Straight-Dice-List
        diceListOne.add(new Dice(2));
        diceListOne.add(new Dice(2));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(1));

        // adds five Dice objects to diceListTwo, which creates a
        // Small-Straight-Dice-List from 1 to 4
        diceListTwo.add(new Dice(1));
        diceListTwo.add(new Dice(4));
        diceListTwo.add(new Dice(3));
        diceListTwo.add(new Dice(1));
        diceListTwo.add(new Dice(2));

        // adds five Dice objects to diceListTwo, which creates a
        // Small-Straight-Dice-List from 2 to 5
        diceListThree.add(new Dice(2));
        diceListThree.add(new Dice(2));
        diceListThree.add(new Dice(3));
        diceListThree.add(new Dice(5));
        diceListThree.add(new Dice(4));

        // adds five Dice objects to diceListTwo, which creates a
        // Small-Straight-Dice-List from 3 to 6
        diceListFour.add(new Dice(1));
        diceListFour.add(new Dice(6));
        diceListFour.add(new Dice(5));
        diceListFour.add(new Dice(4));
        diceListFour.add(new Dice(3));
    }

    @Test
    public void testCalculateValue_isNotASmallStraight() throws RuleNotAvailableException {
        // Checks, if the value of the Small-Straight-Rule is 0,
        // because it is not a small straight
        smallStraight.calculateValue(diceListOne);
        assertEquals(smallStraight.getValue(), 0);
    }

    @Test
    public void testCalculateValue_isASmallStraightOneToFour() throws RuleNotAvailableException {
        // Checks, if the value of the Small-Straight-Rule is 30,
        // because it is a small straight from 1 to 4
        smallStraight.calculateValue(diceListTwo);
        assertEquals(smallStraight.getValue(), 30);
    }

    @Test
    public void testCalculateValue_isASmallStraightTwoToFive() throws RuleNotAvailableException {
        // Checks, if the value of the Small-Straight-Rule is 30,
        // because it is a small straight from 2 to 5
        smallStraight.calculateValue(diceListThree);
        assertEquals(smallStraight.getValue(), 30);
    }

    @Test
    public void testCalculateValue_isASmallStraightThreeToSix() throws RuleNotAvailableException {
        // Checks, if the value of the Small-Straight-Rule is 30,
        // because it is a small straight from 3 to 6
        smallStraight.calculateValue(diceListFour);
        assertEquals(smallStraight.getValue(), 30);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void calculateValue_throwsRuleNotAvailableException() throws RuleNotAvailableException {
        // Checks, if Small-Straight-Rule is supposed to be used more than once
        smallStraight.calculateValue(diceListTwo);
        smallStraight.calculateValue(diceListTwo);
    }

    @Test
    public void testGetValue() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 30
        smallStraight.calculateValue(diceListTwo);
        assertEquals(smallStraight.getValue(), 30);
    }

    @Test
    public void testSetValue() {
        // Checks if setValue() stores the integer 10 in value variable
        smallStraight.setValue(10);
        assertEquals(smallStraight.getValue(), 10);
    }


    @Test
    public void testGetRule() {
        // Checks if getRule() returns the correct Rule-Enum for SMALL_STRAIGHT
        assertEquals(smallStraight.getRule(), SMALL_STRAIGHT);
    }

    @Test
    public void testToString() throws RuleNotAvailableException {
        // Checks if toString() returns correct string-representation of a FullHouse
        // object which should look like this: "SMALL_STRAIGHT: 30"
        smallStraight.calculateValue(diceListTwo);
        assertEquals(smallStraight.toString(), "SMALL_STRAIGHT: 30");
    }
}
