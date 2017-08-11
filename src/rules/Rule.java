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
public enum Rule {
    /** Enum for Rule ONE. */
    ONE(1),
    /** Enum for Rule TWO. */
    TWO(2),
    /** Enum for Rule THREE. */
    THREE(3),
    /** Enum for Rule FOUR. */
    FOUR(4),
    /** Enum for Rule FIVE. */
    FIVE(5),
    /** Enum for Rule SIX. */
    SIX(6),
    /** Enum for Rule THREE OF A KIND. */
    THREE_OF_A_KIND,
    /** Enum for Rule FOUR OF A KIND. */
    FOUR_OF_A_KIND,
    /** Enum for Rule FULL HOUSE. */
    FULL_HOUSE,
    /** Enum for Rule SMALL STRAIGHT. */
    SMALL_STRAIGHT,
    /** Enum for Rule LARGE STRAIGHT. */
    LARGE_STRAIGHT,
    /** Enum for Rule YAHTZEE. */
    YAHTZEE,
    /** Enum for Rule CHANCE. */
    CHANCE;

    /** Point multiplier for some rules. */
    private int pointMultiplier;

    /**
     * Default constructor.
     */
    Rule() { }

    /**
     * Constructor for Enums.
     * @param pointMultiplier of the Enums.
     */
    Rule(int pointMultiplier) {
        this.pointMultiplier = pointMultiplier;
    }

    /**
     * returns the Value of Enums.
     * @return value of Enums.
     */
    public int getPointMultiplier() {
        return pointMultiplier;
    }

}
