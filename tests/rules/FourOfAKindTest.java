package rules;

import dices.Dice;
import exceptions.RuleNotAvailableException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static rules.Rule.FOUR_OF_A_KIND;
import static org.junit.Assert.*;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: test for class FourOfAKind.java<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class FourOfAKindTest {

    // diceListOne is not a ThreeOfAKind-Dice-List
    private ArrayList<Dice> diceListOne = new ArrayList<>();

    // diceListTwo is a ThreeOfAKind-Dice-List
    private ArrayList<Dice> diceListTwo = new ArrayList<>();

    // diceListThree is a ThreeOfAKind-Dice-List
    private ArrayList<Dice> diceListThree = new ArrayList<>();

    private FourOfAKind fourOfAKind = new FourOfAKind(FOUR_OF_A_KIND);

    @Before
    public void setUp() throws Exception {
        // adds five Dice objects to diceList, which creates not a
        // ThreeOfAKInd-Dice-List
        diceListOne.add(new Dice(2));
        diceListOne.add(new Dice(3));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(4));

        // adds five Dice objects to diceListTwo, which creates a
        // ThreeOfAKind-Dice-List with 4 dices with same value
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(3));
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(2));

        // adds five Dice objects to diceListThree, which creates a
        // ThreeOfAKind-Dice-List with 5 dices with same value
        diceListThree.add(new Dice(4));
        diceListThree.add(new Dice(4));
        diceListThree.add(new Dice(4));
        diceListThree.add(new Dice(4));
        diceListThree.add(new Dice(4));
    }

    @Test
    public void testCalculateValue_IsNotAFourOfAKind() throws RuleNotAvailableException {
        // Checks, if the value of the FourOfAkind-Rule is 0,
        // because it's not a four of a kind
        fourOfAKind.calculateValue(diceListOne);
        assertEquals(fourOfAKind.getValue(), 0);
    }

    @Test
    public void testCalculateValue_isAFourOfAKindWith4SameDices() throws RuleNotAvailableException {
        // Checks, if the value of the FourOfAkind-Rule is 11,
        // because it is a four of a kind with 4 same dices
        fourOfAKind.calculateValue(diceListTwo);
        assertEquals(fourOfAKind.getValue(), 11);
    }

    @Test
    public void testCalculateValue_isAFourOfAKindWith5SameDices() throws RuleNotAvailableException {
        // Checks, if the value of the FourOfAkind-Rule is 11,
        // because it is a four of a kind with 5 same dices
        fourOfAKind.calculateValue(diceListThree);
        assertEquals(fourOfAKind.getValue(), 20);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableException() throws RuleNotAvailableException {
        // Checks, if FourOfAKind-rule is supposed to be used more than once
        fourOfAKind.calculateValue(diceListThree);
        fourOfAKind.calculateValue(diceListThree);
    }

    @Test
    public void testGetValue() throws Exception {
        // Checks if getValue() returns the correct value of 11
        fourOfAKind.calculateValue(diceListTwo);
        assertEquals(fourOfAKind.getValue(), 11);
    }

    @Test
    public void testSetValue() throws Exception {
        // Checks if setValue() stores the integer 10 in value variable
        fourOfAKind.setValue(10);
        assertEquals(fourOfAKind.getValue(), 10);
    }

    @Test
    public void testGetRule() throws Exception {
        // Checks if getRule() returns the correct Rule-Enum for FOUR_OF_A_KIND
        assertEquals(fourOfAKind.getRule(), FOUR_OF_A_KIND);
    }

    @Test
    public void testToString() throws Exception {
        // Checks if toString() returns correct string-representation of a ThreeOfAKind object
        // which should look like this: "FOUR_OF_A_KIND: 11"
        fourOfAKind.calculateValue(diceListTwo);
        assertEquals(fourOfAKind.toString(), "FOUR_OF_A_KIND: 11");
    }

}
