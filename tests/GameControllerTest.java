import exceptions.NoRollsLeftException;
import exceptions.NotRolledYetException;
import exceptions.RuleNotAvailableException;
import exceptions.UnknownRuleException;
import rules.Rule;
import dices.Dice;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: test for class GameControllerTest.java<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class GameControllerTest {

    private String name;
    private GameController gc = new GameController();
    private ArrayList<Playcard> playcardList = new ArrayList<>();
    private Playcard playcard;

    @Before
    public void setUp() throws Exception {
        // SetUp vor jedem Test
        this.name = "Korbinian Karl";
    }

    @Test
    public void testNewPlayer_isSuccesful() {
        // 1.) Testet, ob eine neue Playcard zum Spieler mit dem Namen "name" erstellt wurde.
        //     Jede Rule muss den Wert -1 haben. Gibt die Playcard-Liste aller teilnehmenden Spieler zurück.
        boolean isOK = true;
        playcardList.add(new Playcard(this.name));
        List<Playcard> pl = gc.newPlayer(this.name);
        for (int i = 0; i < pl.size(); i++) {
            if (!pl.get(i).equals(playcardList.get(i))) {
                isOK = false;
            }
        }
        assertTrue(isOK);
    }

    @Test
    public void testStartGame_isSuccesful() {
        // 1.) Startet ein Spiel mit allen eingetragenen Spielern. Gibt Playcard des ersten Spielers zurück.
        gc.newPlayer(this.name);
        playcard = new Playcard(this.name);
        assertTrue(playcard.equals(gc.startGame()));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testStartGame_failsOfTooLessPlayers() {
        // 2.) Startet kein Spiel, wenn weniger als 1 Spieler vorhanden ist.
        gc.startGame();
    }

    @Test
    public void testRoll_isSuccesful() throws NoRollsLeftException {
        // 1.) Würfelt mit allen 5 Würfeln. Jeder Würfel bekommt eine Augenzahl zwischen 1 und 6 (inklusive).
        //     Gibt eine Liste mit 5 Würfeln zurück.
        List<Dice> dl;
        boolean isOK = true;

        for (int i = 0; i < 3; i++) {
            dl = gc.roll();
            for (Dice d: dl) {
                if (d.getValue() < 1 && d.getValue() > 6) {
                    isOK = false;
                    break;
                }
            }
        }
        assertTrue(isOK);
    }

    @Test (expected = NoRollsLeftException.class)
    public void testRoll_throwsNoRollsLeftException() throws NoRollsLeftException {
        // 2.) Wirft NoRollsLeftException, falls schon 3 Mal gewürfelt wurde.
        for (int i = 0; i < 4; i++) {
            gc.roll();
        }
    }

    @Test
    public void testRollIndizes_isSuccesful() throws NoRollsLeftException, NotRolledYetException {
        // 1.) Würfelt mit allen 5 Würfeln. Jeder Würfel bekommt eine Augenzahl zwischen 1 und 6 (inklusive).
        //     Gibt eine Liste mit 5 Würfeln zurück.
        gc.newPlayer(this.name);
        gc.startGame();
        List<Dice> dl = gc.roll();
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        List<Dice> dlNew = gc.roll(intList);
        boolean isOK = false;

        if (dl.get(1) == dlNew.get(1) && dl.get(3) == dlNew.get(3) && dl.get(4) == dlNew.get(4)) {
            isOK = true;
        }
        assertTrue(isOK);
    }

    @Test (expected = NoRollsLeftException.class)
    public void testRollIndizes_throwsNoRollsLeftException() throws NoRollsLeftException, NotRolledYetException {
        // 2.) Wirft NoRollsLeftException, falls schon 3 Mal gewürfelt wurde.
        gc.newPlayer(this.name);
        gc.startGame();
        gc.roll();
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        for (int i = 0; i < 4; i++) {
            gc.roll(intList);
        }
    }

    @Test (expected = NotRolledYetException.class)
    public void testRollIndizes_throwsNotRolledYetException() throws NoRollsLeftException, NotRolledYetException {
        // 2.) Wirft NoRollsLeftException, falls schon 3 Mal gewürfelt wurde.
        gc.newPlayer(this.name);
        gc.startGame();
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        for (int i = 0; i < 4; i++) {
            gc.roll(intList);
        }
    }

    @Test
    public void testInsert_isSucessful() throws RuleNotAvailableException, UnknownRuleException, NoRollsLeftException, NotRolledYetException {
        // 1.) Fügt die Dice-Liste in die angegebene Regel ein.
        gc.newPlayer(this.name);
        gc.newPlayer(this.name);
        Playcard pl = gc.startGame();
        List<Dice> dl = gc.roll();
        int sum = 0;
        for (Dice d: dl) {
            sum += d.getValue();
        }
        gc.insert("Chance");
        assertEquals(sum, pl.getLower().get(Rule.CHANCE).getValue());
    }

    @Test (expected = NullPointerException.class)
    public void testInsert_throwsRuleNotAvailableException() throws RuleNotAvailableException, UnknownRuleException, NoRollsLeftException, NotRolledYetException {
        // 2.) Wirft UnknownRuleException, da die Regel nicht existiert.
        gc.newPlayer(this.name);
        gc.roll();
        gc.insert("Chance");
        gc.roll();
        gc.insert("Chance");
    }

    @Test (expected = UnknownRuleException.class)
    public void testInsert_throwsUnknownRuleException() throws RuleNotAvailableException, UnknownRuleException, NoRollsLeftException, NotRolledYetException {
        // 3.) Wirft UnknownRuleException, da die Regel bereits eingetragen wurde.
        gc.newPlayer(this.name);
        List<Dice> dl = gc.roll();
        int sum = 0;
        for (Dice d: dl) {
            sum += d.getValue();
        }
        gc.insert("Chancee");
    }

    @Test
    public void testGetCurrentPlaycard() {
        // 1.) Gbt die Playcard des aktuellen Spielers aus.
        gc.newPlayer(this.name);
        gc.newPlayer("Hans WasAuchImmer");
        Playcard pl = gc.startGame();
        assertEquals(pl, gc.getCurrentPlaycard());
    }

    @Test
    public void testGetAllPlaycards_isTrue() {
        // 1.) Gbt die Playcard aller Spieler aus.
        boolean isOK = true;
        gc.newPlayer(this.name);
        gc.newPlayer("Hans WasAuchImmer");
        List<Playcard> pl = new ArrayList<>();
        pl.add(new Playcard(this.name));
        pl.add(new Playcard("Hans WasAuchImmer"));
        for (int i = 0; i < gc.getAllPlaycards().size(); i++) {
            if (!gc.getAllPlaycards().get(i).equals(pl.get(i))) {
                isOK = false;
            }
        }
        assertTrue(isOK);
    }

    @Test
    public void testGetAllPlaycards_isFalse() {
        // 1.) Gbt die Playcard aller Spieler aus.
        boolean isOK = true;
        gc.newPlayer(this.name);
        gc.newPlayer("WasAuchImmer");
        List<Playcard> pl = new ArrayList<>();
        pl.add(new Playcard(this.name));
        pl.add(new Playcard("Hans WasAuchImmer"));
        for (int i = 0; i < gc.getAllPlaycards().size(); i++) {
            if (!gc.getAllPlaycards().get(i).equals(pl.get(i))) {
                isOK = false;
            }
        }
        assertFalse(isOK);
    }
}