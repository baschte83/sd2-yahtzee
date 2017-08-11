import dices.Dice;
import exceptions.*;
import rules.Rule;

import java.util.ArrayList;
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
public class GameController implements IGameController {

    private static final int AMOUNT_OF_DICES = 5;
    private static final int AMOUNT_OF_ROLES = 3;
    private static int players = 0;

    private ArrayList<Playcard> playcardList = new ArrayList<>();
    private ArrayList<Dice> diceList = new ArrayList<>();
    private PlaycardIterator playcardIterator = new PlaycardIterator(playcardList);
    private Playcard currentPlaycard;
    private int rollCounter = 0;
    private int gameTurnCounter = 0;
    private boolean hasRolled = false;

    /**
     * Create new player card. Any player who participates in the game,
     * is represented by his or hers player card.
     *
     * @param name player name
     * @return play card list of all participating players
     */
    @Override
    public List<Playcard> newPlayer(String name) {
        playcardList.add(new Playcard(name));
        players++;
        return playcardList;
    }

    /**
     * Start a new game. This method requires a minimum of one participating
     * player in the game.
     *
     * @return play card of the first player that entered the game.
     */
    @Override
    public Playcard startGame() {
        for (int i = 0; i < AMOUNT_OF_DICES; i++) {
            diceList.add(new Dice(-1));
        }
        currentPlaycard = playcardList.get(0);
        return currentPlaycard;
    }

    /**
     * Throw all five dice. As a result each dice receives a random
     * number between 1 and 6.
     *
     * @return the list of dice with current values.
     * @throws NoRollsLeftException if all available rolls have been consumed.
     */
    @Override
    public List<Dice> roll() throws NoRollsLeftException {
        if (rollCounter == AMOUNT_OF_ROLES) {
            throw new NoRollsLeftException();
        }
        for (Dice dice : diceList) {
            dice.roll();
        }
        rollCounter++;
        hasRolled = true;
        return diceList;
    }

    /**
     * Throw a selected number of dice. As a result each selected dice receives
     * a random number between 1 and 6. Non-selected dice stay unchanged.
     *
     * @param indizes of the dice to roll.
     * @return the list of all dice with current values.
     * @throws NoRollsLeftException if all available rolls have been consumed.
     */
    @Override
    public List<Dice> roll(List<Integer> indizes) throws NoRollsLeftException, NotRolledYetException {
        if (rollCounter == AMOUNT_OF_ROLES) {
            throw new NoRollsLeftException();
        }

        if (!hasRolled) {
            throw new NotRolledYetException();
        }
        for (Integer ints : indizes) {
            diceList.get(ints - 1).roll();
        }
        rollCounter++;
        return diceList;
    }

    /**
     * Insert current dice value in the selected rule. If the dice value do not
     * match the rule, the value of this rule is set to 0.
     *
     * @param rule name or ordinal number of the rule as defined in the Rule-Enum.
     * @return play card of the next player. Indicates who is next in the game.
     * @throws UnknownRuleException      if given rule cannot be identified.
     * @throws RuleNotAvailableException if rule has already been set.
     */
    @Override
    public Playcard insert(String rule) throws UnknownRuleException, RuleNotAvailableException, NotRolledYetException {
        if (!hasRolled) {
            throw new NotRolledYetException();
        }
        currentPlaycard.setRuleValue(getRule(rule), diceList);
        currentPlaycard = playcardIterator.next();
        rollCounter = 0;
        hasRolled = false;
        gameTurnCounter++;
        return currentPlaycard;
    }

    /**
     * Return play card of current player.
     *
     * @return play card of current player.
     */
    @Override
    public Playcard getCurrentPlaycard() {
        return currentPlaycard;
    }

    /**
     * Return play cards of all participating players.
     *
     * @return list of all play cards in the game.
     */
    @Override
    public List<Playcard> getAllPlaycards() {
        return playcardList;
    }

    private Rule getRule(String rule) throws UnknownRuleException {
        switch (rule.toUpperCase()) {
            case "ONE" :
                return Rule.ONE;
            case "TWO" :
                return Rule.TWO;
            case "THREE" :
                return Rule.THREE;
            case "FOUR" :
                return Rule.FOUR;
            case "FIVE" :
                return Rule.FIVE;
            case "SIX" :
                return Rule.SIX;
            case "THREE_OF_A_KIND" :
                return Rule.THREE_OF_A_KIND;
            case "FOUR_OF_A_KIND" :
                return Rule.FOUR_OF_A_KIND;
            case "FULL_HOUSE" :
                return Rule.FULL_HOUSE;
            case "SMALL_STRAIGHT" :
                return Rule.SMALL_STRAIGHT;
            case "LARGE_STRAIGHT" :
                return Rule.LARGE_STRAIGHT;
            case "YAHTZEE" :
                return Rule.YAHTZEE;
            case "CHANCE" :
                return Rule.CHANCE;
            default:
                throw new UnknownRuleException();
        }
    }
}
