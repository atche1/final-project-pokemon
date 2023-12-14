import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDisplay {
    Display display;
    InputStream originalSystemIn;
    PrintStream originalSystemOut;
    Pokemon firePokemon;
    Pokemon waterPokemon;
    @BeforeEach
    void setUp(){
        display = new Display();
        originalSystemIn = System.in;
        originalSystemOut = System.out;
         firePokemon = new Pokemon("Dragonus", "Red",PokemonType.FIRE, 100, 50, 30, new Size(Size.SMALL),new Attack());
         waterPokemon = new Pokemon("Wobafet", "Blue",PokemonType.WATER, 100, 50, 30, new Size(Size.SMALL),new Attack());
    }
    @Test
    public void testChooseAttackForYourPokemonWhenInputValidChoiceThenReturnsAttack() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Attack chosenAttack = display.chooseAttackForYourPokemon();
        assertNotNull(chosenAttack);
    }
    @Test
    public void testChooseEnemyPokemonForOneBattleWhenInputValidChoiceThenReturnsPokemon() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Pokemon chosenEnemyPokemon = display.chooseEnemyPokemonForOneBattle();
        assertNotNull(chosenEnemyPokemon);
    }
    @Test
    public void testGeneratingAttackForEnemyPokemonThenReturnsValidAttack() {
        Attack generatedAttack = display.generatingAttackForEnemyPokemon();
        assertNotNull(generatedAttack);
    }

}

