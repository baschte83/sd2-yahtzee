package rules;

import dices.Dice;
import exceptions.RuleNotAvailableException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static rules.Rule.THREE_OF_A_KIND;
import static org.junit.Assert.*;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: test for class ThreeOfAKind.java<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class ThreeOfAKindTest {

    // diceList1 is not a ThreeOfAKind-Dice-List
    private ArrayList<Dice> diceListOne = new ArrayList<>();

    // diceListTwo is a ThreeOfAKind-Dice-List
    private ArrayList<Dice> diceListTwo = new ArrayList<>();

    // diceListThree is a ThreeOfAKind-Dice-List
    private ArrayList<Dice> diceListThree = new ArrayList<>();

    // diceListFour is a ThreeOfAKind-Dice-List
    private ArrayList<Dice> diceListFour = new ArrayList<>();

    private ThreeOfAKind threeOfAKind = new ThreeOfAKind(THREE_OF_A_KIND);

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
        // ThreeOfAKind-Dice-List with 3 dices with same value
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(3));
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(5));
        diceListTwo.add(new Dice(2));

        // adds five Dice objects to diceListThree, which creates a
        // ThreeOfAKind-Dice-List with 4 dices with same value
        diceListThree.add(new Dice(4));
        diceListThree.add(new Dice(4));
        diceListThree.add(new Dice(4));
        diceListThree.add(new Dice(5));
        diceListThree.add(new Dice(4));

        // adds five Dice objects to diceList, which creates a
        // ThreeOfAKind-Dice-List with 5 dices with same value
        diceListFour.add(new Dice(3));
        diceListFour.add(new Dice(3));
        diceListFour.add(new Dice(3));
        diceListFour.add(new Dice(3));
        diceListFour.add(new Dice(3));
    }

    @Test
    public void testCalculateValue_isNotThreeOfAKind() throws RuleNotAvailableException {
        // Checks, if the value of the ThreeOfAkind-Rule is 0,
        // because it's not a three of a kind
        threeOfAKind.calculateValue(diceListOne);
        assertEquals(threeOfAKind.getValue(), 0);
    }

    @Test
    public void testCalculateValue_isAThreeOfAKind() throws RuleNotAvailableException {
        // Checks, if the value of the ThreeOfAkind-Rule is 14,
        // because it is a three of a kind
        threeOfAKind.calculateValue(diceListTwo);
        assertEquals(threeOfAKind.getValue(), 14);
    }

    @Test
    public void testCalculateValue_isAThreeOfAKindWith4SameDices() throws RuleNotAvailableException {
        // Checks, if the value of the ThreeOfAkind-Rule is 14,
        // because it is a three of a kind
        threeOfAKind.calculateValue(diceListThree);
        assertEquals(threeOfAKind.getValue(), 21);
    }

    @Test
    public void testCalculateValue_isAThreeOfAKindWith5SameDices() throws RuleNotAvailableException {
        // Checks, if the value of the ThreeOfAkind-Rule is 14,
        // because it is a three of a kind
        threeOfAKind.calculateValue(diceListFour);
        assertEquals(threeOfAKind.getValue(), 15);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableException() throws RuleNotAvailableException {
        // Checks, if ThreeOfAKind-rule is supposed to be used more than once
        threeOfAKind.calculateValue(diceListTwo);
        threeOfAKind.calculateValue(diceListTwo);
    }

    @Test
    public void testGetValue() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 14
        threeOfAKind.calculateValue(diceListTwo);
        assertEquals(threeOfAKind.getValue(), 14);
    }

    @Test
    public void testSetValue() {
        // Checks if setValue() stores the integer 10 in value variable
        threeOfAKind.setValue(10);
        assertEquals(threeOfAKind.getValue(), 10);
    }

    @Test
    public void testGetRule() {
        // Checks if getRule() returns the correct Rule-Enum for ThreeOfAKind
        assertEquals(threeOfAKind.getRule(), THREE_OF_A_KIND);
    }

    @Test
    public void testToString() throws RuleNotAvailableException {
        // Checks if toString returns correct string-representation of a ThreeOfAKind object
        // which should look like this: "THREE_OF_A_KIND: 14"
        threeOfAKind.calculateValue(diceListTwo);
        assertEquals(threeOfAKind.toString(), "THREE_OF_A_KIND: 14");
    }

}
