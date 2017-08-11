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
class OfAKind extends AbstractRule {

    /**
     * Creates a new rule object.
     *
     * @param rule type of this object.
     */
    OfAKind(Rule rule) {
        super(rule);
    }

    /**
     * Calculates the value for this rule based on the current dice values.
     * This method needs to be redefined in derived classes.
     *
     * @param cup list of all dice in the game.
     * @throws RuleNotAvailableException if rule has already been set.
     */
    @Override
    public void calculateValue(List<Dice> cup) throws RuleNotAvailableException { }

    /**
     * Assistance method to sum up all dices in a list of dices.
     * @param cup is a list of dices as an ArrayList.
     * @return an interger as the sum of all dices of the list of dices.
     */
    int sumUp(List<Dice> cup) {
        Iterator<Dice> diceIterator = new DiceIterator(cup);
        int sum = 0;
        while (diceIterator.hasNext()) {
            sum += diceIterator.next().getValue();
        }
        return sum;
    }
}
