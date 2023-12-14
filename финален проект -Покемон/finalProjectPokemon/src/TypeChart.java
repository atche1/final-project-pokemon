public class TypeChart {
    private static double[][] effectiveness = {
            // FIRE, WATER, GRASS, ELECTRIC,FLYING // и т.н.
            {1.0, 0.5, 2.0, 1.0, 0.5},  // FIRE
            {2.0, 1.0, 0.5, 1.0, 2,0},  // WATER
            {0.5, 2.0, 1.0, 1.0, 1.0},  // GRASS
            {1.0, 1.0, 1.0, 0.5, 0.5}, // ELECTRIC
            {0.5, 2.0, 1.0, 0.5, 1.0}, // FlYING
            // и т.н.
    };
    public static double getEffectiveness(PokemonType attacker, PokemonType defender) {
        return effectiveness[attacker.ordinal()][defender.ordinal()];
    }


}
