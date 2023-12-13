import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBattle {
    Pokemon myPokemon;
    Pokemon enemyPokemon;
    Battle battle;
    Attack attackType;
    Terrain terrain;

    @BeforeEach
    public void setUp() {
        terrain =new Terrain();
        myPokemon = new Pokemon("Pikachu", "Yellow", PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL), new Attack());
        enemyPokemon = new Pokemon("Charizard", "Orange", PokemonType.FLYING, 100, 50, 30, new Size(Size.SMALL), new Attack());
        attackType = new Attack("Blaze Kick",10);
        battle = new Battle(myPokemon, enemyPokemon,terrain);
    }

    @Test
    public void attackByTheEnemyPokemon_InflictDamage_CorrectHealthPoints() {
        double effectiveness = 0.5; // Assuming normal effectiveness
        int attackPoints = (int) ((enemyPokemon.getAttackPoints() * effectiveness) + attackType.getPower());
        int damage = attackPoints - myPokemon.getDefensePoints();
        int expectedHealth = myPokemon.getHealthPoints() - damage;

        assertEquals(95,expectedHealth);
    }

    @Test
    public void attackByMyPokemon_InflictDamage_CorrectHealthPoints() {
        double effectiveness = 0.5; // Assuming normal effectiveness
        int attackPoints = (int) ((myPokemon.getAttackPoints() * effectiveness) + attackType.getPower());
        int damage = attackPoints - enemyPokemon.getDefensePoints();
        int expectedHealth = enemyPokemon.getHealthPoints() - damage;

        assertEquals(95,expectedHealth);
    }

}


