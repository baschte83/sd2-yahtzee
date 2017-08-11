package rules;

import dices.Dice;
import exceptions.RuleNotAvailableException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static rules.Rule.FULL_HOUSE;
import static org.junit.Assert.*;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: test for class FullHouse.java<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class FullHouseTest {

    // diceListOne is not a FullHouse-Dice-List
    private ArrayList<Dice> diceListOne = new ArrayList<>();

    // diceListOne is not a FullHouse-Dice-List
    private ArrayList<Dice> diceListTwo = new ArrayList<>();

    private FullHouse fullHouse = new FullHouse(FULL_HOUSE);

    @Before
    public void setUp() throws Exception {
        // adds five Dice objects to diceList, which creates not a
        // FullHouse-Dice-List
        diceListOne.add(new Dice(2));
        diceListOne.add(new Dice(3));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(4));

        // adds five Dice objects to diceListTwo, which creates a
        // FullHouse-Dice-List
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(3));
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(3));
    }

    @Test
    public void calculateValue_isNotAFullHouse() throws RuleNotAvailableException {
        // Checks, if the value of the FullHouse-Rule is 0,
        // because it is not a full house
        fullHouse.calculateValue(diceListOne);
        assertEquals(0, fullHouse.getValue());
    }

    @Test
    public void calculateValue_isAFullHouse() throws RuleNotAvailableException {
        // Checks, if the value of the FullHouse-Rule is 25,
        // because it is a full house
        fullHouse.calculateValue(diceListTwo);
        assertEquals(25, fullHouse.getValue());
    }

    @Test (expected = RuleNotAvailableException.class)
    public void calculateValue_throwsRuleNotAvailableException() throws RuleNotAvailableException {
        // Checks, if FullHouse-rule is supposed to be used more than once
        fullHouse.calculateValue(diceListTwo);
        fullHouse.calculateValue(diceListTwo);
    }

    @Test
    public void testGetValue() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 25
        fullHouse.calculateValue(diceListTwo);
        assertEquals(25, fullHouse.getValue());
    }

    @Test
    public void testSetValue() {
        // Checks if setValue() stores the integer 10 in value variable
        fullHouse.setValue(10);
        assertEquals(10, fullHouse.getValue());
    }

    @Test
    public void testGetRule(){
        // Checks if getRule() returns the correct Rule-Enum for FULL_HOUSE
        assertEquals(FULL_HOUSE, fullHouse.getRule());
    }

    @Test
    public void testToString() throws RuleNotAvailableException {
        // Checks if toString() returns correct string-representation of a FullHouse
        // object which should look like this: "FULL_HOUSE: 25"
        fullHouse.calculateValue(diceListTwo);
        assertEquals("FULL_HOUSE: 25", fullHouse.toString());
    }
}
