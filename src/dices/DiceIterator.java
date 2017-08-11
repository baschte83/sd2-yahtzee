package dices;

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
public class DiceIterator implements Iterator<Dice> {

    /**
     * Private object variable to store a list of 5 dices.
     */
    private final List<Dice> diceList;
    private int index = 0;

    /**
     * Default-constructor of dices.DiceIterator.
     * @param diceList is an ArrayList of 5 dices.
     */
    public DiceIterator(List<Dice> diceList) {
        this.diceList = diceList;
    }

    /**
     * Method returns wether the list has a next element or nor.
     * @return true, if the list hast a next element, false otherwise.
     */
    public boolean hasNext() {
        return index < diceList.size();
    }

    /**
     * Method returns next element of ArrayList.
     * @return next dices.Dice element, if there is one.
     */
    public Dice next() {
        return diceList.get(this.index++);
    }
}
