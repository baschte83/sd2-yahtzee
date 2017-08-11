package rules;

import dices.Dice;
import exceptions.RuleNotAvailableException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static rules.Rule.*;
import static org.junit.Assert.*;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: test for class Number.java<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class NumberTest {

    // diceListOne is not a Number(1)-Dice-List
    private ArrayList<Dice> diceListOne = new ArrayList<>();

    // diceListTwo is a Number(2)-Dice-List
    private ArrayList<Dice> diceListTwo = new ArrayList<>();

    // diceListThree is a Number(3)-Dice-List
    private ArrayList<Dice> diceListThree = new ArrayList<>();

    // diceListFour is a Number(4)-Dice-List
    private ArrayList<Dice> diceListFour = new ArrayList<>();

    // diceListFive is a Number(5)-Dice-List
    private ArrayList<Dice> diceListFive = new ArrayList<>();

    // diceListSix is a Number(6)-Dice-List
    private ArrayList<Dice> diceListSix = new ArrayList<>();

    private Number  numberOne = new Number(ONE);
    private Number  numberTwo = new Number(TWO);
    private Number  numberThree = new Number(THREE);
    private Number  numberFour = new Number(FOUR);
    private Number  numberFive = new Number(FIVE);
    private Number  numberSix = new Number(SIX);

    @Before
    public void setUp() throws Exception {
        // adds five Dice objects to diceList, which creates a
        // Number(1)-Dice-List with sum 3
        diceListOne.add(new Dice(1));
        diceListOne.add(new Dice(2));
        diceListOne.add(new Dice(1));
        diceListOne.add(new Dice(5));
        diceListOne.add(new Dice(1));

        // adds five Dice objects to diceListTwo, which creates a
        // Number(2)-Dice-List with sum 8
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(3));
        diceListTwo.add(new Dice(2));
        diceListTwo.add(new Dice(2));

        // adds five Dice objects to diceListTwo, which creates a
        // Number(3)-Dice-List with sum 6
        diceListThree.add(new Dice(3));
        diceListThree.add(new Dice(1));
        diceListThree.add(new Dice(3));
        diceListThree.add(new Dice(5));
        diceListThree.add(new Dice(4));

        // adds five Dice objects to diceListTwo, which creates a
        // Number(4)-Dice-List with sum 4
        diceListFour.add(new Dice(1));
        diceListFour.add(new Dice(6));
        diceListFour.add(new Dice(5));
        diceListFour.add(new Dice(4));
        diceListFour.add(new Dice(3));

        // adds five Dice objects to diceListTwo, which creates a
        // Number(5)-Dice-List with sum 15
        diceListFive.add(new Dice(5));
        diceListFive.add(new Dice(5));
        diceListFive.add(new Dice(5));
        diceListFive.add(new Dice(4));
        diceListFive.add(new Dice(3));

        // adds five Dice objects to diceListTwo, which creates a
        // Number(6)-Dice-List with sum 12
        diceListSix.add(new Dice(1));
        diceListSix.add(new Dice(6));
        diceListSix.add(new Dice(6));
        diceListSix.add(new Dice(4));
        diceListSix.add(new Dice(3));
    }

    @Test
    public void testCalculateValue_isNotANumberOne() throws RuleNotAvailableException {
        // Checks, if the value of the Number(1)-Rule is 0,
        // because there are no dices with the value 1
        numberOne.calculateValue(diceListFive);
        assertEquals(0, numberOne.getValue());
    }

    @Test
    public void testCalculateValue_isNotANumberTwo() throws RuleNotAvailableException {
        // Checks, if the value of the Number(2)-Rule is 0,
        // because there are no dices with the value 2
        numberTwo.calculateValue(diceListThree);
        assertEquals(0, numberTwo.getValue());
    }

    @Test
    public void testCalculateValue_isNotANumberThree() throws RuleNotAvailableException {
        // Checks, if the value of the Number(3)-Rule is 0,
        // because there are no dices with the value 3
        numberThree.calculateValue(diceListOne);
        assertEquals(0, numberThree.getValue());
    }

    @Test
    public void testCalculateValue_isNotANumberFour() throws RuleNotAvailableException {
        // Checks, if the value of the Number(4)-Rule is 0,
        // because there are no dices with the value 4
        numberFour.calculateValue(diceListOne);
        assertEquals(0, numberFour.getValue());
    }

    @Test
    public void testCalculateValue_isNotANumberFive() throws RuleNotAvailableException {
        // Checks, if the value of the Number(5)-Rule is 0,
        // because there are no dices with the value 5
        numberFive.calculateValue(diceListTwo);
        assertEquals(0, numberFive.getValue());
    }

    @Test
    public void testCalculateValue_isNotANumberSix() throws RuleNotAvailableException {
        // Checks, if the value of the Number(6)-Rule is 0,
        // because there are no dices with the value 6
        numberSix.calculateValue(diceListOne);
        assertEquals(0, numberSix.getValue());
    }

    @Test
    public void testCalculateValue_isANumberOne() throws RuleNotAvailableException {
        // Checks, if the value of the Number(1)-Rule is 3,
        // because there are 3 dices with the value 1
        numberOne.calculateValue(diceListOne);
        assertEquals(3, numberOne.getValue());
    }

    @Test
    public void testCalculateValue_isANumberTwo() throws RuleNotAvailableException {
        // Checks, if the value of the Number(2)-Rule is 8,
        // because there are 4 dices with the value 2
        numberTwo.calculateValue(diceListTwo);
        assertEquals(8, numberTwo.getValue());
    }

    @Test
    public void testCalculateValue_isANumberThree() throws RuleNotAvailableException {
        // Checks, if the value of the Number(3)-Rule is 6,
        // because there are 2 dices with the value 3
        numberThree.calculateValue(diceListThree);
        assertEquals(6, numberThree.getValue());
    }

    @Test
    public void testCalculateValue_isANumberFour() throws RuleNotAvailableException {
        // Checks, if the value of the Number(4)-Rule is 4,
        // because there is 1 dice with the value 4
        numberFour.calculateValue(diceListFour);
        assertEquals(4, numberFour.getValue());
    }

    @Test
    public void testCalculateValue_isANumberFive() throws RuleNotAvailableException {
        // Checks, if the value of the Number(5)-Rule is 15,
        // because there are 3 dices with the value 5
        numberFive.calculateValue(diceListFive);
        assertEquals(15, numberFive.getValue());
    }

    @Test
    public void testCalculateValue_isANumberSix() throws RuleNotAvailableException {
        // Checks, if the value of the Number(6)-Rule is 12,
        // because there are 2 dices with the value 6
        numberSix.calculateValue(diceListSix);
        assertEquals(12, numberSix.getValue());
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableExceptionNumberOne() throws RuleNotAvailableException {
        // Checks, if Number(1)-Rule is supposed to be used more than once
        numberOne.calculateValue(diceListOne);
        numberOne.calculateValue(diceListOne);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableExceptionNumberTwo() throws RuleNotAvailableException {
        // Checks, if Number(2)-Rule is supposed to be used more than once
        numberTwo.calculateValue(diceListTwo);
        numberTwo.calculateValue(diceListTwo);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableExceptionNumberThree() throws RuleNotAvailableException {
        // Checks, if Number(3)-Rule is supposed to be used more than once
        numberThree.calculateValue(diceListThree);
        numberThree.calculateValue(diceListThree);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableExceptionNumberFour() throws RuleNotAvailableException {
        // Checks, if Number(4)-Rule is supposed to be used more than once
        numberFour.calculateValue(diceListFour);
        numberFour.calculateValue(diceListFour);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableExceptionNumberFive() throws RuleNotAvailableException {
        // Checks, if Number(5)-Rule is supposed to be used more than once
        numberFive.calculateValue(diceListFive);
        numberFive.calculateValue(diceListFive);
    }

    @Test (expected = RuleNotAvailableException.class)
    public void testCalculateValue_throwsRuleNotAvailableExceptionNumberSix() throws RuleNotAvailableException {
        // Checks, if Number(6)-Rule is supposed to be used more than once
        numberSix.calculateValue(diceListSix);
        numberSix.calculateValue(diceListSix);
    }

    @Test
    public void testGetValue_NumberOne() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 3
        numberOne.calculateValue(diceListOne);
        assertEquals(3, numberOne.getValue());
    }

    @Test
    public void testGetValue_NumberTwo() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 8
        numberTwo.calculateValue(diceListTwo);
        assertEquals(8, numberTwo.getValue());
    }

    @Test
    public void testGetValue_NumberThree() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 6
        numberThree.calculateValue(diceListThree);
        assertEquals(6, numberThree.getValue());
    }

    @Test
    public void testGetValue_NumberFour() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 4
        numberFour.calculateValue(diceListFour);
        assertEquals(4, numberFour.getValue());
    }

    @Test
    public void testGetValue_NumberFive() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 15
        numberFive.calculateValue(diceListFive);
        assertEquals(15, numberFive.getValue());
    }

    @Test
    public void testGetValue_NumberSix() throws RuleNotAvailableException {
        // Checks if getValue() returns the correct value of 12
        numberSix.calculateValue(diceListSix);
        assertEquals(12, numberSix.getValue());
    }

    @Test
    public void testSetValue_NumberOne() {
        // Checks if setValue() stores the integer 10 in value variable
        numberOne.setValue(10);
        assertEquals(10, numberOne.getValue());
    }

    @Test
    public void testSetValue_NumberTwo() {
        // Checks if setValue() stores the integer 10 in value variable
        numberTwo.setValue(10);
        assertEquals(10, numberTwo.getValue());
    }

    @Test
    public void testSetValue_NumberThree() {
        // Checks if setValue() stores the integer 10 in value variable
        numberThree.setValue(10);
        assertEquals(10, numberThree.getValue());
    }

    @Test
    public void testSetValue_NumberFour() {
        // Checks if setValue() stores the integer 10 in value variable
        numberFour.setValue(10);
        assertEquals(10, numberFour.getValue());
    }

    @Test
    public void testSetValue_NumberFive() {
        // Checks if setValue() stores the integer 10 in value variable
        numberFive.setValue(10);
        assertEquals(10, numberFive.getValue());
    }

    @Test
    public void testSetValue_NumberSix() {
        // Checks if setValue() stores the integer 10 in value variable
        numberSix.setValue(10);
        assertEquals(10, numberSix.getValue());
    }

    @Test
    public void testGetRule_NumberOne() {
        // Checks if getRule() returns the correct Rule-Enum for ONE
        assertEquals(ONE, numberOne.getRule());
    }

    @Test
    public void testGetRule_NumberTwo(){
        // Checks if getRule() returns the correct Rule-Enum for TWO
        assertEquals(TWO, numberTwo.getRule());
    }

    @Test
    public void testGetRule_NumberThree() {
        // Checks if getRule() returns the correct Rule-Enum for THREE
        assertEquals(THREE, numberThree.getRule());
    }

    @Test
    public void testGetRule_NumberFour() {
        // Checks if getRule() returns the correct Rule-Enum for FOUR
        assertEquals(FOUR, numberFour.getRule());
    }

    @Test
    public void testGetRule_NumberFive() {
        // Checks if getRule() returns the correct Rule-Enum for FIVE
        assertEquals(FIVE, numberFive.getRule());
    }

    @Test
    public void testGetRule_NumberSix() {
        // Checks if getRule() returns the correct Rule-Enum for SIX
        assertEquals(SIX, numberSix.getRule());
    }

    @Test
    public void testToString_NumberOne() throws RuleNotAvailableException {
        // Checks if toString() returns correct string-representation of a Number(1)
        // object which should look like this: "ONE: 3"
        numberOne.calculateValue(diceListOne);
        assertEquals("ONE: 3", numberOne.toString());
    }

    @Test
    public void testToString_NumberTwo() throws RuleNotAvailableException {
        // Checks if toString() returns correct string-representation of a Number(2)
        // object which should look like this: "TWO: 8"
        numberTwo.calculateValue(diceListTwo);
        assertEquals("TWO: 8", numberTwo.toString());
    }

    @Test
    public void testToString_NumberThree() throws RuleNotAvailableException {
        // Checks if toString() returns correct string-representation of a Number(3)
        // object which should look like this: "THREE: 6"
        numberThree.calculateValue(diceListThree);
        assertEquals("THREE: 6", numberThree.toString());
    }

    @Test
    public void testToString_NumberFour() throws RuleNotAvailableException {
        // Checks if toString() returns correct string-representation of a Number(4)
        // object which should look like this: "FOUR: 4"
        numberFour.calculateValue(diceListFour);
        assertEquals("FOUR: 4", numberFour.toString());
    }

    @Test
    public void testToString_NumberFive() throws RuleNotAvailableException {
        // Checks if toString() returns correct string-representation of a Number(5)
        // object which should look like this: "FIVE: 15"
        numberFive.calculateValue(diceListFive);
        assertEquals("FIVE: 15", numberFive.toString());
    }

    @Test
    public void testToString_NumberSix() throws RuleNotAvailableException {
        // Checks if toString() returns correct string-representation of a Number(6)
        // object which should look like this: "SIX: 12"
        numberSix.calculateValue(diceListSix);
        assertEquals("SIX: 12", numberSix.toString());
    }
}
