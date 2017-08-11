import dices.Dice;
import exceptions.NoRollsLeftException;
import exceptions.NotRolledYetException;
import exceptions.RuleNotAvailableException;
import exceptions.UnknownRuleException;

import java.util.List;

/**
 * Game controller interface. Defines methods to
 * control the complete game cycle.
 * @author hammerschall
 */
public interface IGameController {

    /**
     * Create new player card. Any player who participates in the game,
     * is represented by his or hers player card.
     * @param name player name
     * @return play card list of all participating players
     */
    List<Playcard> newPlayer(String name);

    /**
     * Start a new game. This method requires a minimum of one participating
     * player in the game.
     * @return play card of the first player that entered the game.
     */
    Playcard startGame();

    /**
     * Throw all five dice. As a result each dice receives a random
     * number between 1 and 6.
     * @return the list of dice with current values.
     * @throws NoRollsLeftException if all available rolls have been consumed.
     */
    List<Dice> roll() throws NoRollsLeftException;

    /**
     * Throw a selected number of dice. As a result each selected dice receives
     * a random number between 1 and 6. Non-selected dice stay unchanged.
     * @param indizes of the dice to roll.
     * @return the list of all dice with current values.
     * @throws NoRollsLeftException if all available rolls have been consumed.
     * @throws NotRolledYetException if the has not been a call of roll() method yet.
     */
    List<Dice> roll(List<Integer> indizes) throws NoRollsLeftException, NotRolledYetException;

    /**
     * Insert current dice value in the selected rule. If the dice value do not
     * match the rule, the value of this rule is set to 0.
     * @param rule name or ordinal number of the rule as defined in the Rule-Enum.
     * @return play card of the next player. Indicates who is next in the game.
     * @throws UnknownRuleException if given rule cannot be identified.
     * @throws RuleNotAvailableException if rule has already been set.
     * @throws NotRolledYetException if the has not been a call of roll() method yet.
     */
    Playcard insert(String rule) throws UnknownRuleException, RuleNotAvailableException, NotRolledYetException;

    /**
     * Return play card of current player.
     * @return play card of current player.
     */
    Playcard getCurrentPlaycard();

    /**
     * Return play cards of all participating players.
     * @return list of all play cards in the game.
     */
    List<Playcard> getAllPlaycards();

}
