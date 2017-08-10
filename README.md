# Yahtzee

### Assignment, class and language
This is the solution to the assignment **Yahtzee** of class **software developement 2,** written in Java with my two team members [Korbinian Karl](https://github.com/korbster) and [Ehsan Moslehi](https://github.com/eca852).

### Requirements
Yahtzee is a game where you try to dice several combinations of five dices. The combinations are specified by the Yahtzee rules. Everytime you dice with the five dices, you have to look up the rules and see if your toss matches any of the demanded dice combnations. If so, you get a certain amount of points for your toss. If not, you have to scratch one of the not yet successfuly tossed dice combinations and get 0 points for your toss. You have exactly one toss per dice combination in the rules, ether your toss matches a demanded combination or not (so if there are 3 combinations demanded you have exactly 3 tosses till the end of the game). At the end the player with the most points wins the game. In Germany Yahtzee is also known as Kniffel.

Rule | Explanation | Points
---- | ----------- | ------
One | Any dice with one dot counts | 1 point for every right dice
Two | Any dice with two dots counts | 2 point for every right dice
Three | Any dice with three dots counts | 3 point for every right dice
Four | Any dice with four dots counts | 4 point for every right dice
Five | Any dice with five dots counts | 5 point for every right dice
Six | Any dice with six dots counts | 6 point for every right dice
Three Of A Kind | Any combination with at least three dices with the same amount of dots counts | sum of dots of all dices
Four Of A Kind | Any combination with at least four dices with the same amount of dots counts | sum of dots of all dices
Full House | Any combination of three and two equal dices or five equal dices counts | 25 points
Small Straight | One of the following dice combinations counts: 1-2-3-4 or 2-3-4-5 or 3-4-5-6 | 30 points
Large Straight | One of the following dice combinations counts: 1-2-3-4-5 or 2-3-4-5-6 | 40 points
Yahtzee | A toss with five equal dices counts | 50 points
Chance | Any tossed dice combination | sum of dots of all dices


This was just a glimpse at the rules but enough for now. It was our task to write a program to play Yahtzee via the terminal with any number of players. The program consists of 25 classes: class **YahtzeeGame,** interface **IGameController,** class **GameController,** class **Dice,** class **Playcard,** abstract class **AbstractRule,** class **Chance,** class **FullHouse,** class **Yahtzee,** class **Number,** class **Straight,** class **SmallStraight,** class **LargeStraight,** class **OfAKind,** class **ThreeOfAKind,** class **FourOfAKind** and enum **Rule** and JUnit test classes for every rule. This task was another one we should practice the method of "test driven developement".

My task was to write all classes that affect the recognition and assignment of the tossed dice combinations to the demanded ones and in addition the computation of the right amount of points for each toss. I also wrote all JUnit test files for every rule. So below I only explain the classes I wrote by myself. Below all demanded dice combinations are mentioned as **rules**.

#### Abstract Class AbstractRule
This is the base class for all rules and implements all methods that fit to each rule.

#### Abstract Class OfAKind
This is the base class for the rules **ThreeOfAKind** and **FourOfAKind** and implements all methods that these two latter classes have in common.

#### Class ThreeOfAKind
This class represents the rule **Three Of A Kind** and the main method computes the sum of all dots of all tossed dices if the tossed dices match this rule.

#### Class FourOfAKind
This class represents the rule **Four Of A Kind** and the main method computes the sum of all dots of all tossed dices if the tossed dices match this rule.

#### Abstract Class Straight
This is the base class for the rules **Small Straight** and **Large Straight** and implements all methods that these two latter classes have in common.

#### Class SmallStraight
This class represents the rule **Small Straight** and the main method returns 30 points if the tossed dices match this rule.

#### Class LargeStraight
This class represents the rule **Large Straight** and the main method returns 40 points if the tossed dices match this rule.

#### Class Chance
This class represents the rule **Chance** and the main method computes the sum of all dots of all tossed dices no matter what dice combination was tossed.

#### Class FullHouse
This class represents the rule **Full House** and the main method returns 25 points if the tossed dices match this rule.

#### Class Yahtzee
This class represents the rule **Yahtzee** and the main method returns 50 points if the tossed dices match this rule.

#### Class Number
This class represents six rules at once: **One, Two, Three, Four, Five** and **Six**. Its main method checks if the player wants to check in this rule for dices with one, two, three, four, five or six dots, whether the demanded rule has already been used and if the rule has not been used it computes the right amount of points.
