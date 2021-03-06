package rules;

import dices.DiceComparator;
import dices.Dice;
import exceptions.RuleNotAvailableException;

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
public class SmallStraight extends Straight {
    /**
     * Creates a new rule object.
     *
     * @param rule type of this object.
     */
    public SmallStraight(Rule rule) {
        super(rule);
    }

    /**
     * Method calculates the value for this rule based on the fact wether dices build
     * a small straight or not. This Method checks, if the rule SMALL_STRAIGHT has already
     * been set once. If so, the value of object variable value is anything but -1.
     * So first it is checked, if value is anything but -1. If so, the RuleNotAvailableException
     * is thrown. If not so, method checks, if the dices in the dice list build one of three
     * possible small straights (dices from 1 to 4, from 2 to 5 or from 3 to 6. If one of the
     * small straights appear in the list of dices, the variable value is set to 30. Otherwise,
     * it is set to 0.
     * @param cup list of all dice in the game.
     * @throws RuleNotAvailableException if rule has already been set.
     */
    @Override
    public void calculateValue(List<Dice> cup) throws RuleNotAvailableException {

        int sum = 0;

        cup.sort(new DiceComparator());

        if (getValue() != -1) {
            throw new RuleNotAvailableException();
        }
        else {
            if (isAStraight(BORDER_ONE, BORDER_FOUR, cup) || isAStraight(BORDER_TWO, BORDER_FIVE, cup) || isAStraight(BORDER_THREE, BORDER_SIX, cup)) {
                sum = VALUE_OF_SMALL_STRAIGHT;
            }
        }
        setValue(sum);
    }
}
