package rules;

import dices.DiceIterator;
import dices.Dice;
import exceptions.RuleNotAvailableException;

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
public class Chance extends AbstractRule {

    /**
     * Creates a new chance object..
     *
     * @param rule type of this object.
     */
    public Chance(Rule rule) {
        super(rule);
    }

    /**
     * Method calculates the value for this rule based on the current dice values.
     * This Method checks, if the rule CHANCE has already been set once.
     * If so, the value of object variable value is anything but -1. So first it
     * is checked, if value is anything but -1. If so, the RuleNotAvailableException
     * is thrown. If not, all combinations of 5 dices is a valid combination of
     * dices to count as a chance. So the sum of all dices in the list of dices is
     * calculated and stored in value.
     *
     * @param cup list of all dice in the game.
     * @throws RuleNotAvailableException if rule has already been set.
     */
    @Override
    public void calculateValue(List<Dice> cup) throws RuleNotAvailableException {

        int sum = 0;

        if (getValue() != -1) {
            throw new RuleNotAvailableException("You can not use this rule twice!");
        }
        else {
            Iterator<Dice> diceIterator = new DiceIterator(cup);
            while (diceIterator.hasNext()) {
                sum += diceIterator.next().getValue();
            }
        }
        setValue(sum);
    }
}
