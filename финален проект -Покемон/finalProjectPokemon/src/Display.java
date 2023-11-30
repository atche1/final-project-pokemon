import java.util.ArrayList;

public class Display {
    User user1 = new User();
    public void displayMainMenu(){
        Pokemon firePokemon = new Pokemon("Dragonus", "Red",PokemonType.FIRE, 100, 50, 30, new Size(Size.SMALL),new Attack("Blaze Kick",20));
        Pokemon waterPokemon = new Pokemon("Wobafet", "Blue",PokemonType.WATER, 100, 50, 30, new Size(Size.SMALL),new Attack("Aqua Cutter",30));
        Pokemon grassPokemon = new Pokemon("Bulbasore", "Green",PokemonType.GRASS, 100, 50, 30, new Size(Size.SMALL),new Attack("Apple Acid",20));
        Pokemon electricPokemon = new Pokemon("Pikachu", "Yellow",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL), new Attack("Charge Beam",15));
        Pokemon flyingPokemon = new Pokemon("Charizard", "Orange",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL),new Attack("Dual Wingbeat",30));
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(firePokemon);
        pokemons.add(waterPokemon);
        pokemons.add(grassPokemon);
        pokemons.add(flyingPokemon);
        pokemons.add(electricPokemon);
        user1.choosePokemon(pokemons);

    }

}
