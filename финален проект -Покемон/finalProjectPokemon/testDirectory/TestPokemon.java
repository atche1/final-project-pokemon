import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPokemon {

    // set / get тест
    @Test
    public void testSetterAndGetters() {
        // Arrange
        Pokemon pokemon = new Pokemon();

        // Set values using setters
        pokemon.setName("Pikachu");
        pokemon.setAppearance("Electric");
        pokemon.setType(PokemonType.ELECTRIC);
        pokemon.setHealthPoints(90);
        pokemon.setAttackPoints(55);
        pokemon.setDefensePoints(40);
        pokemon.setSize(new Size(Size.NORMAL));

        // Assert values using getters
        assertEquals("Pikachu", pokemon.getName());
        assertEquals("Electric", pokemon.getAppearance());
        assertEquals(PokemonType.ELECTRIC, pokemon.getType());
        assertEquals(90, pokemon.getHealthPoints());
        assertEquals(55, pokemon.getAttackPoints());
        assertEquals(40, pokemon.getDefensePoints());
       // assertEquals(Size.NORMAL, pokemon.getSize());
    }


    // тестване на статистика според размер

    @Test
    public void testAdjustStatsBySizeSmall() {
        Pokemon pokemon = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40, new Size(Size.SMALL));

        //pokemon.adjustStatsBySize();

        // Assert
        assertEquals(80, pokemon.getHealthPoints());
        assertEquals(40, pokemon.getAttackPoints());
        assertEquals(32, pokemon.getDefensePoints());
    }

    @Test
    public void testAdjustStatsBySizeLarge() {
        // Arrange
        Pokemon pokemon = new Pokemon("Bulbasaur", "Plant-like", PokemonType.GRASS, 120, 60, 55, new Size(Size.LARGE));

       // pokemon.adjustStatsBySize();

        // Assert
        assertEquals(144, pokemon.getHealthPoints());
        assertEquals(72, pokemon.getAttackPoints());
        assertEquals(66, pokemon.getDefensePoints());
    }

    @Test
    public void testAdjustStatsBySizeNormal() {
        Pokemon pokemon = new Pokemon("Squirtle", "Turtle-like", PokemonType.WATER, 80, 45, 35, new Size(Size.NORMAL));

        pokemon.adjustStatsBySize();

        // Assert
        assertEquals(80, pokemon.getHealthPoints());
        assertEquals(45, pokemon.getAttackPoints());
        assertEquals(35, pokemon.getDefensePoints());
    }


    // тестване на фукнции свързани с терен

    @Test
    public void testAdjustStatsByTerrainVolcano() {
        // Arrange
        Terrain volcanoTerrain = new Terrain("Volcano");
        Pokemon pokemon = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40, new Size(Size.NORMAL));

        // Act
        TerrainManager.setTerrain(pokemon, volcanoTerrain);

        // Assert
        assertEquals(100, pokemon.getHealthPoints()); // No change for health points
        assertEquals(70, pokemon.getAttackPoints()); // +20 for fire-type on volcano terrain
        assertEquals(40, pokemon.getDefensePoints()); // No change for defense points
    }

    @Test
    public void testAdjustStatsByTerrainSea() {
        // Arrange
        Terrain seaTerrain = new Terrain("Sea");
        Pokemon pokemon = new Pokemon("Squirtle", "Turtle-like", PokemonType.WATER, 80, 45, 35, new Size(Size.NORMAL));

        // Act
        TerrainManager.setTerrain(pokemon, seaTerrain);

        // Assert
        assertEquals(80, pokemon.getHealthPoints()); // No change for health points
        assertEquals(60, pokemon.getAttackPoints()); // +15 for water-type on sea terrain
        assertEquals(35, pokemon.getDefensePoints()); // No change for defense points
    }

    @Test
    public void testAdjustStatsByTerrainForest() {
        // Arrange
        Terrain forestTerrain = new Terrain("Forest");
        Pokemon pokemon = new Pokemon("Bulbasaur", "Plant-like", PokemonType.GRASS, 120, 60, 55, new Size(Size.NORMAL));

        // Act
        TerrainManager.setTerrain(pokemon, forestTerrain);

        // Assert
        assertEquals(120, pokemon.getHealthPoints()); // No change for health points
        assertEquals(70, pokemon.getAttackPoints()); // +10 for grass-type on forest terrain
        assertEquals(55, pokemon.getDefensePoints()); // No change for defense points
    }

    // тест еволюция бонуси
    @Test
    public void testApplyEvolutionBonuses() {
        // Arrange
        Pokemon pokemon = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40, new Size(Size.NORMAL));

        // Act
        pokemon.applyEvolutionBonuses();

        // Assert
        assertEquals(150, pokemon.getHealthPoints()); // +50 health points for evolution
        assertEquals(80, pokemon.getAttackPoints());  // +30 attack points for evolution
        assertEquals(55, pokemon.getDefensePoints()); // +15 defense points for evolution
    }
}
