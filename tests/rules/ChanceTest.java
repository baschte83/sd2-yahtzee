package rules;

import dices.Dice;
import exceptions.RuleNotAvailableException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static rules.Rule.CHANCE;
import static org.junit.Assert.*;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: test for class Chance.java<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class ChanceTest {

    private ArrayList<Dice> diceList = new ArrayList<>();
    private Chance chance = new Chance(CHANCE);

    @Before
    public void setUp() throws Exception {
        // adds five Dice objects to diceList
        diceList.add(new Dice(2));
        diceList.add(new Dice(3));
        diceList.add(new Dice(5));
        diceList.add(new Dice(5));
        diceList.add(new Dice(4));

    }

    @Test
    public void testCalculateValue() throws RuleNotAvailableException {
        // Checks, if the value of the Chance-Rule is 19
        chance.calculateValue(diceList);
        assertEquals(chance.getValue(), 19);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableException() throws RuleNotAvailableException {
        // Checks, if Chance-rule is supposed to be used more than once
        chance.calculateValue(diceList);
        chance.calculateValue(diceList);
    }

    @Test
    public void testGetValue() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 19
        chance.calculateValue(diceList);
        assertEquals(chance.getValue(), 19);
    }

    @Test
    public void testSetValue() {
        // Checks if setValue() stores the integer 10 in value variable
        chance.setValue(10);
        assertEquals(chance.getValue(), 10);
    }

    @Test
    public void testGetRule() {
        // Checks if getRule() returns the correct Rule-Enum for CHANCE
        assertEquals(chance.getRule(), CHANCE);
    }

    @Test
    public void testToString() throws RuleNotAvailableException {
        // Checks if toString() returns correct string-representation of a Chance object
        // which should look like this: "CHANCE: 19"
        chance.calculateValue(diceList);
        assertEquals(chance.toString(), "CHANCE: 19");
    }
}
