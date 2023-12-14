import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPokemon {

    @Test
    public void testSetterAndGetters() {

        Pokemon pokemon = new Pokemon();

        pokemon.setName("Pikachu");
        pokemon.setAppearance("Electric");
        pokemon.setType(PokemonType.ELECTRIC);
        pokemon.setHealthPoints(90);
        pokemon.setAttackPoints(55);
        pokemon.setDefensePoints(40);
        pokemon.setSize(new Size(Size.NORMAL));

        assertEquals("Pikachu", pokemon.getName());
        assertEquals("Electric", pokemon.getAppearance());
        assertEquals(PokemonType.ELECTRIC, pokemon.getType());
        assertEquals(90, pokemon.getHealthPoints());
        assertEquals(55, pokemon.getAttackPoints());
        assertEquals(40, pokemon.getDefensePoints());
       // assertEquals(Size.NORMAL, pokemon.getSize());
    }
    @Test
    public void testAdjustStatsBySizeSmall() {
        Pokemon pokemon = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40, new Size(Size.SMALL),new Attack());
        assertEquals(80, pokemon.getHealthPoints());
        assertEquals(40, pokemon.getAttackPoints());
        assertEquals(32, pokemon.getDefensePoints());
    }

    @Test
    public void testAdjustStatsBySizeLarge() {
        Pokemon pokemon = new Pokemon("Bulbasaur", "Plant-like", PokemonType.GRASS, 120, 60, 55, new Size(Size.LARGE),new Attack());
        assertEquals(144, pokemon.getHealthPoints());
        assertEquals(72, pokemon.getAttackPoints());
        assertEquals(66, pokemon.getDefensePoints());
    }

    @Test
    public void testAdjustStatsBySizeNormal() {
        Pokemon pokemon = new Pokemon("Squirtle", "Turtle-like", PokemonType.WATER, 80, 45, 35, new Size(Size.NORMAL),new Attack());
        pokemon.adjustStatsBySize();
        assertEquals(80, pokemon.getHealthPoints());
        assertEquals(45, pokemon.getAttackPoints());
        assertEquals(35, pokemon.getDefensePoints());
    }

    @Test
    public void testAdjustStatsByTerrainVolcano() {
        Terrain volcanoTerrain = new Terrain("Volcano");
        Pokemon pokemon = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40, new Size(Size.NORMAL),new Attack());
        TerrainManager.setTerrain(pokemon, volcanoTerrain);
        assertEquals(100, pokemon.getHealthPoints());
        assertEquals(70, pokemon.getAttackPoints());
        assertEquals(40, pokemon.getDefensePoints());
    }

    @Test
    public void testAdjustStatsByTerrainSea() {
        Terrain seaTerrain = new Terrain("Sea");
        Pokemon pokemon = new Pokemon("Squirtle", "Turtle-like", PokemonType.WATER, 80, 45, 35, new Size(Size.NORMAL),new Attack());
        TerrainManager.setTerrain(pokemon, seaTerrain);
        assertEquals(80, pokemon.getHealthPoints());
        assertEquals(60, pokemon.getAttackPoints());
        assertEquals(35, pokemon.getDefensePoints());
    }

    @Test
    public void testAdjustStatsByTerrainForest() {
        Terrain forestTerrain = new Terrain("Forest");
        Pokemon pokemon = new Pokemon("Bulbasaur", "Plant-like", PokemonType.GRASS, 120, 60, 55, new Size(Size.NORMAL),new Attack());
        TerrainManager.setTerrain(pokemon, forestTerrain);
        assertEquals(120, pokemon.getHealthPoints());
        assertEquals(70, pokemon.getAttackPoints());
        assertEquals(55, pokemon.getDefensePoints());
    }

    @Test
    public void testApplyEvolutionBonuses() {
        Pokemon pokemon = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40, new Size(Size.NORMAL),new Attack());
        pokemon.applyEvolutionBonuses();
        assertEquals(150, pokemon.getHealthPoints()); // +50 health points for evolution
        assertEquals(80, pokemon.getAttackPoints());  // +30 attack points for evolution
        assertEquals(55, pokemon.getDefensePoints()); // +15 defense points for evolution
    }

}
