import java.util.HashMap;
import java.util.Map;

public class TerrainManager {

    private static Map<Pokemon, Terrain> pokemonTerrainMap = new HashMap<>();

    public static void setTerrain(Pokemon pokemon, Terrain terrain) {
        pokemonTerrainMap.put(pokemon, terrain);
        pokemon.adjustStatsByTerrain();
    }

    public static Terrain getTerrain(Pokemon pokemon) {
        return pokemonTerrainMap.get(pokemon);
    }
}
