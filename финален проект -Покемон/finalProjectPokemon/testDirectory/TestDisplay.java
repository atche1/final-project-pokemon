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
    public void chooseAttackForYourPokemon_InputValidChoice_ReturnsAttack() {
        // Arrange
        String input = "1\n"; // Simulating user input "1"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Act
        Attack chosenAttack = display.chooseAttackForYourPokemon();

        // Assert
        assertNotNull(chosenAttack);
        // Add more assertions based on the expected behavior
    }
    @Test
    public void chooseEnemyPokemonForOneBattle_InputValidChoice_ReturnsPokemon() {
        // Arrange
        String input = "1\n"; // Simulating user input "1"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Act
        Pokemon chosenEnemyPokemon = display.chooseEnemyPokemonForOneBattle();

        // Assert
        assertNotNull(chosenEnemyPokemon);
        // Add more assertions based on the expected behavior
    }
    @Test
    public void generatingAttackForEnemyPokemon_ReturnsValidAttack() {
        // Act
        Attack generatedAttack = display.generatingAttackForEnemyPokemon();

        // Assert
        assertNotNull(generatedAttack);
        // Add more assertions based on the expected behavior
    }

}

