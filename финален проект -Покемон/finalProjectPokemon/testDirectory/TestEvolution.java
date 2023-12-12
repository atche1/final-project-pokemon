import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEvolution {
    @Test
    public void testEvolve() {
        Pokemon charmander = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40,new Size (Size.NORMAL),new Attack());
        EvolutionManager.evolvePokemon(charmander);
        assertTrue(charmander.isEvolved());
    }

    @Test
    public void testNotEvolved(){
        Pokemon charmander = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40,new Size (Size.NORMAL),new Attack());
        EvolutionManager.evolvePokemon(charmander);
        assertFalse(charmander.isEvolved());
    }

    @Test
    public void areBonusesApplyed(){

    }


}
