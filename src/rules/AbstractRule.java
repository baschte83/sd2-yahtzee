package rules;

import dices.Dice;
import dices.DiceIterator;
import exceptions.RuleNotAvailableException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: solution to lab 02: Yahtzee game<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public abstract class AbstractRule {

    private static final int GREATES_DICE_VALUE = 6;    // used only in AbstractRule.java
    private static final int LOWEST_DICE_VALUE = 1;     // used only in AbstractRule.java
    static final int AMOUNT_OF_TWO_OF_A_KIND = 2;       // used only in FullHouse.java
    static final int AMOUNT_OF_THREE_OF_A_KIND = 3;     // used only in FullHouse.java & ThreeOfAKind.java
    static final int AMOUNT_OF_FOUR_OF_A_KIND = 4;      // used only in FourOfAKind.java & ThreeOfAKind.java
    static final int VALUE_OF_FULLHOUSE = 25;           // used only in FullHouse.java
    static final int VALUE_OF_SMALL_STRAIGHT = 30;      // used only in SmallStraight.java
    static final int VALUE_OF_LARGE_STRAIGHT = 40;      // used only in LargeStraight.java
    static final int VALUE_OF_YAHTZEE = 50;             // used only in Yahtzee.java

    /**
     * Current value of rule field. A negative value indicates
     * that this field has not yet been set.
     */
    private int value = -1;

    /**
     * Enum with readable string value of the rule type.
     */
    private final Rule rule;

    /**
     * Creates a new rule object.
     * @param rule type of this object.
     */
    AbstractRule(Rule rule) {
        this.rule = rule;
    }

    /**
     * Getter for current value of this rule.
     * @return current value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter for value. This method is used after the new value
     * has been calculated based on the dice values.
     * @param value calculated based on dice.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Calculates the value for this rule based on the current dice values.
     * This method needs to be redefined in derived classes.
     * @param cup list of all dice in the game.
     * @throws RuleNotAvailableException if rule has already been set.
     */
    public abstract void calculateValue(List<Dice> cup) throws RuleNotAvailableException;

    /**
     * Getter for the type of rule that this object represents.
     * @return rule value.
     */
    public Rule getRule() {
        return rule;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", getRule().name(), value);
    }

    /**
     * Assistance method to check, if there are dices of the same kind in a list of dices.
     * Method is used by ThreeOfAKind.java and FourOfAKind.java.
     * This method stores the occurance of dices with the same value. For example, if the five
     * dices handled over are like this: [2, 3, 4, 2, 2], than the 2 occures 3 times. so three
     * dices have the same value. So, the counterList would look like this: counterList = [3].
     * If no dice appears more than one time, an empty list counterList = [] is handled over
     * to the caller of testOfAKind.
     * @param diceList is a list of dices as an ArrayList.
     * @return a list of integers of found dices of a kind.
     */
    ArrayList<Integer> testOfAKind(List<Dice> diceList) {

        int counter = 0;
        ArrayList<Integer> counterList = new ArrayList<>();

        for (int i = LOWEST_DICE_VALUE; i <= GREATES_DICE_VALUE; i++) {
            Iterator<Dice> diceIterator = new DiceIterator(diceList);
            while (diceIterator.hasNext()) {
                if (i == diceIterator.next().getValue()) {
                    counter++;
                }
            }
            if (counter > 1) {
                counterList.add(counter);
            }
            counter = 0;
        }
        return counterList;
    }

    /**
     * Assistance method checks, if the dices in the dice list cup are in a row from lower to upper.
     * To iterate through the list of dices the method uses an iterator object.
     * @param lower is the lower border as an integer.
     * @param upper is the upper border as an integer.
     * @param cup is the list of dices as an ArrayList.
     * @return true, if the dices in cup are in a row of lower to upper, false otherwise.
     */
    boolean isAStraight(int lower, int upper, List<Dice> cup) {

        int foundIt = 0;

        for (int i = lower; i <= upper; i++) {
            Iterator<Dice> diceIterator = new DiceIterator(cup);
            while (diceIterator.hasNext()) {
                if (diceIterator.next().getValue() == i) {
                    foundIt++;
                    break;
                }
            }
            if (foundIt == 0) {
                return false;
            }
            foundIt = 0;
        }
        return true;
    }

}
