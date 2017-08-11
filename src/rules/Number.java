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
public class Number extends AbstractRule {
    /**
     * Creates a new rule object.
     *
     * @param rule type of this object.
     */
    public Number(Rule rule) {
        super(rule);
    }

    /**
     * Calculates the value for this rule based on how often a specific dice appears in dice list cup.
     * This Method checks, if the rule NUMBER(x) (x stands for an Integer from 1 to 6) has already
     * been set once. If so, the value of object variable value is anything but -1. So first it
     * is checked, if value is anything but -1. If so, the RuleNotAvailableException
     * is thrown. Otherwise the method iterates through the list of dices (cup) and checks, if there is
     * a dice with the value of the rule of this specific number object. If so, the counter is increased
     * by one. If not, nothing happens with the counter. After the all dices in dice list cup have been
     * checked, the value of this number object is calculated by the multiplication of the counter with
     * the value of the rule of this specific number object.
     * @param cup list of all dice in the game.
     * @throws RuleNotAvailableException if rule has already been set.
     */
    @Override
    public void calculateValue(List<Dice> cup) throws RuleNotAvailableException {

        int counter = 0;

        if (getValue() != -1) {
            throw new RuleNotAvailableException();
        }
        else {
            Iterator<Dice> diceIterator = new DiceIterator(cup);
            while (diceIterator.hasNext()) {
                if (diceIterator.next().getValue() == this.getRule().getPointMultiplier()) {
                    counter++;
                }
            }
        }
        setValue(counter * this.getRule().getPointMultiplier());
    }
}
