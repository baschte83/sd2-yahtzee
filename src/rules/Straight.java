package rules;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: solution to lab 02: Yahtzee game<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
abstract class Straight extends AbstractRule {

    static final int BORDER_ONE = 1;
    static final int BORDER_TWO = 2;
    static final int BORDER_THREE = 3;
    static final int BORDER_FOUR = 4;
    static final int BORDER_FIVE = 5;
    static final int BORDER_SIX = 6;

    /**
     * Creates a new rule object.
     *
     * @param rule type of this object.
     */
    Straight(Rule rule) {
        super(rule);
    }
}
