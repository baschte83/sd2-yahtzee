package dices;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: solution to lab 02: Yahtzee game<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */

public class Dice {

    private static final int DICE_SIDES = 6;
    /** Object variable to value of a dice. */
    private int value;

    /**
     * Constructor of dices.Dice.
     * @param value of a dice side.
     */
    public Dice(int value) {
        this.value = value;
    }

    /**
     * get value of a dice.
     * @return value of a dice.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets a random value between 1 and 6 both included to a dice.
     */
    public void roll() {
        this.value = (int) ((Math.random() * DICE_SIDES) + 1);
    }

    @Override
    public String toString() {
        return "["
                + value
                + "]";
    }

    /**
     * Metod checks if two dice objects are equal.
     * @param o is the other object.
     * @return true, if both dices are of same value and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dice)) return false;

        Dice dice = (Dice) o;

        return getValue() == dice.getValue();
    }

    @Override
    public int hashCode() {
        return getValue();
    }
}
