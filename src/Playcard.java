import dices.Dice;
import exceptions.RuleNotAvailableException;
import rules.*;
import rules.Number;

import java.util.ArrayList;
import java.util.TreeMap;
/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: solution to lab 02: Yahtzee game<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class Playcard {

    /** Devider needed in toString. */
    private static final String DEVIDER = "********************";
    /** Constant to bonus points. */
    private static final int BONUS = 35;
    /** Constant because of checkestyle. */
    private static final int UPPER_SIZE = 6;
    /** Constant to minimum points at upper part to earn bonus. */
    private static final int MIN_UPPER_TO_BONUS = 63;
    /** Constant used in generated hash method. */
    private static final int MAGIC_NUMBER_FOR_HASH = 31;
    /** Object variable to store the upper part of the play card. */
    private TreeMap<Rule, AbstractRule> upper = new TreeMap<Rule, AbstractRule>();
    /** Object variable to store the lower part of the play card. */
    private TreeMap<Rule, AbstractRule> lower = new TreeMap<Rule, AbstractRule>();
    /** final variable stores the name of a player. */
    private final String name;

    /**
     * Constructor of PlayCard.
     * Sets name of the player and fills the upper and lower part.
     * @param name name of the player.
     */
    public Playcard(String name) {
        fillUpper();
        fillLower();
        this.name = name;
    }

    /**
     * Fills the upper rule part of the play card.
     */
    private void fillUpper() {
        Rule[] rules = Rule.values();
        for (int i = 0; i < UPPER_SIZE; i++) {
            this.upper.put(rules[i], new Number(rules[i]));
        }
    }

    /**
     * Fills the lower rule part of the play card.
     */
    private void fillLower() {
        this.lower.put(Rule.THREE_OF_A_KIND, new ThreeOfAKind(Rule.THREE_OF_A_KIND));
        this.lower.put(Rule.FOUR_OF_A_KIND, new FourOfAKind(Rule.FOUR_OF_A_KIND));
        this.lower.put(Rule.FULL_HOUSE, new FullHouse(Rule.FULL_HOUSE));
        this.lower.put(Rule.SMALL_STRAIGHT, new SmallStraight(Rule.SMALL_STRAIGHT));
        this.lower.put(Rule.LARGE_STRAIGHT, new LargeStraight(Rule.LARGE_STRAIGHT));
        this.lower.put(Rule.YAHTZEE, new Yahtzee(Rule.YAHTZEE));
        this.lower.put(Rule.CHANCE, new Chance(Rule.CHANCE));
    }

    /**
     * Returns the name of the Player.
     * @return name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Calculates the total score of the card.
     * @return the total score of the card.
     */
    public int calculateTotalScore() {
        int upperScore = calculatePartScore(this.upper);
        int lowerScore = calculatePartScore(this.lower);
        if (upperScore >= MIN_UPPER_TO_BONUS) {
            return upperScore + lowerScore + BONUS;
        }
        return upperScore + lowerScore;
    }

    /**
     * Calculates the reached score of upper or lower part of the card.
     * @param tree TreeMap represents upper or lower part of the card.
     * @return score reached in upper or lower part of the card.
     */
    private int calculatePartScore(TreeMap<Rule, AbstractRule> tree) {
        int result = 0;
        for (Rule r: tree.keySet()) {
            result += tree.get(r).getValue();
        }
        return result;
    }

    /**
     * Sets the value of a rule.
     * @param rule for whom the value schuld be set.
     * @param dices the list of dices to calculate value.
     * @throws RuleNotAvailableException .
     */
    public void setRuleValue(Rule rule, ArrayList<Dice> dices) throws RuleNotAvailableException {
        if (this.upper.containsKey(rule)) {
            this.upper.get(rule).calculateValue(dices);
        }
        else {
            this.lower.get(rule).calculateValue(dices);
        }
    }

    @Override
    public String toString() {
        String string = this.getName() + "\n" + DEVIDER + "\n";
        for (Rule r : this.upper.keySet()) {
            string += this.upper.get(r).toString();
            string += "\n";
        }
        for (Rule r : this.lower.keySet()) {
            string += this.lower.get(r).toString();
            string += "\n";
        }
        return string;
    }

    /**
     * Method returns list of upper rules.
     * @return list of upper rules as a tree map.
     */
    public TreeMap<Rule, AbstractRule> getUpper() {
        return upper;
    }

    /**
     * Method returns list of lower rules.
     * @return list of lower rules as a tree map.
     */
    public TreeMap<Rule, AbstractRule> getLower() {
        return lower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playcard)) return false;

        Playcard playcard = (Playcard) o;

        for (Rule r: upper.keySet()) {
            if (upper.get(r).getValue() != ((Playcard) o).getUpper().get(r).getValue()) {
                return false;
            }
        }

        for (Rule r: lower.keySet()) {
            if (lower.get(r).getValue() != ((Playcard) o).getLower().get(r).getValue()) {
                return false;
            }
        }

        return getName().equals(playcard.getName());

    }

    @Override
    public int hashCode() {
        int result = upper.hashCode();
        result = MAGIC_NUMBER_FOR_HASH * result + lower.hashCode();
        result = MAGIC_NUMBER_FOR_HASH * result + getName().hashCode();
        return result;
    }
}