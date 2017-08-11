import exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: solution to lab 02: Yahtzee game<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class YahtzeeGame {

    private static final int MAX_ARGUMENT_INDEX = 6;
    private static final int MAX_DICE_NUMBER = 5;
    private static final int AMOUNT_OF_RULES = 13;
    private static int turnCounter = 0;


    /**
     * The main-method controls the game loop and acts as the user interface.
     *
     * @param args no command line arguments expected.
     */
    public static void main(String[] args) {

        // Read everything from the commandline
        try (Scanner scanner = new Scanner(System.in)) {

            // Create a new Kniffel Game
            IGameController game = new GameController();

            // Container for the indices of a roll command
            List<Integer> indices = new ArrayList<>();

            // Contains the current scanned line
            String[] command;

            boolean canStart = true;

            // Main Loop
            while (true) {
                System.out.println("Welcome to Kniffel");
                int playerCounter = 0;

                while (true) {
                    System.out.println("Please add player" + " " + (playerCounter + 1));
                    System.out.println("Or type 'play' to start the game");

                    String next = scanner.nextLine();

                    if ("play".equals(next) && playerCounter < 1) {
                        System.out.println("Add atleast one player!");
                        break;
                    } else if ("play".equals(next)) {
                        System.out.println("Starting game...");
                        game.startGame();

                        while (true) {
                            System.out.println("You can type 'roll', 'roll <indicies>','insert <rule>','show','all'");
                            checkEndOfGame(game);

                            System.out.println("It's " + game.getCurrentPlaycard().getName() + "'s turn");
                            command = scanner.nextLine().split(" ");

                            boolean hasIndices = command.length > 1 && command.length <= MAX_ARGUMENT_INDEX;
                            try {
                                pollingCommands(command, hasIndices, indices, game);
                            } catch (NoRollsLeftException e) {
                                System.err.println("No rolls left!");
                            } catch (RuleNotAvailableException e) {
                                System.err.println("You already used that rule!");
                            } catch (UnknownRuleException e) {
                                System.err.println("Unknown rule!");
                            } catch (NotRolledYetException e) {
                                System.err.println("Please roll once!");
                            } catch (NotAValidDiceNumberException e) {
                                System.err.println("Not a valid dice number");
                            } catch (NumberFormatException e) {
                                System.err.println("Not a valid command");
                            }
                        }
                    }
                    game.newPlayer(next);
                    playerCounter++;
                }
            }
        }
    }

    private static void pollingCommands(String[] command, boolean hasIndices, List<Integer> indices, IGameController game) throws NotAValidDiceNumberException, NotRolledYetException, NoRollsLeftException, RuleNotAvailableException, UnknownRuleException {
        if ("roll".equals(command[0])) {
            if (hasIndices) {
                initializeIndices(command, indices);
            } else if (command.length > MAX_ARGUMENT_INDEX) {
                throw new NotAValidDiceNumberException();
            }

            if (hasIndices) {
                System.out.println(game.roll(indices));
            } else {
                System.out.println(game.roll());
            }
        } else if ("show".equals(command[0])) {
            System.out.println(game.getCurrentPlaycard().toString());
        } else if ("insert".equals(command[0])) {
            game.insert(command[1]);
            turnCounter++;
        } else if ("all".equals(command[0])) {
            for (Playcard current : game.getAllPlaycards()) {
                System.out.println(current);
            }
        } else {
            System.err.println("Invalid command!");
        }
    }

    private static void checkEndOfGame(IGameController game) {
        if ((turnCounter / game.getAllPlaycards().size()) == AMOUNT_OF_RULES) {
            System.out.println("Game Over");
            printSum(game);
            System.out.println("Exiting game...");
            System.exit(0);

        }
    }

    private static void printSum(IGameController game) {
        for (Playcard current : game.getAllPlaycards()) {
            System.out.println(current.getName() + " hat " + current.calculateTotalScore() + " Punkte");
        }
    }

    private static void initializeIndices(String[] command, List<Integer> indices) throws NotAValidDiceNumberException {
        indices.clear();
        for (int i = 1; i < command.length; i++) {
            String s = command[i];
            int value = Integer.parseInt(s);
            if (value < 1 || value > MAX_DICE_NUMBER) {
                throw new NotAValidDiceNumberException();
            }
            indices.add(value);
        }
    }
}
