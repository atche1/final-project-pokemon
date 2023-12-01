import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Display {
    User user1 = new User();

    public void displayMainMenu(){
        Scanner input = new Scanner(System.in);
        Pokemon firePokemon = new Pokemon("Dragonus", "Red",PokemonType.FIRE, 100, 50, 30, new Size(Size.SMALL),new Attack());
        Pokemon waterPokemon = new Pokemon("Wobafet", "Blue",PokemonType.WATER, 100, 50, 30, new Size(Size.SMALL),new Attack());
        Pokemon grassPokemon = new Pokemon("Bulbasore", "Green",PokemonType.GRASS, 100, 50, 30, new Size(Size.SMALL),new Attack());
        Pokemon electricPokemon = new Pokemon("Pikachu", "Yellow",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL), new Attack());
        Pokemon flyingPokemon = new Pokemon("Charizard", "Orange",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL),new Attack());
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(firePokemon);
        pokemons.add(waterPokemon);
        pokemons.add(grassPokemon);
        pokemons.add(flyingPokemon);
        pokemons.add(electricPokemon);
        ArrayList<Attack> attacks = new ArrayList<>();
        attacks.add(new Attack("Blaze Kick",20));
        attacks.add(new Attack("Aqua Cutter",30));
        attacks.add(new Attack("Apple Acid",20));
        attacks.add(new Attack("Charge Beam",15));
        attacks.add(new Attack("Dual Wingbeat",30));

        user1.choosePokemon(pokemons);
        System.out.print("Choose pokemon for the first battle(1-3): ");
        int choice = input.nextInt();
        Pokemon currentPokemon = new Pokemon();
        switch (choice){
            case 1: currentPokemon = user1.getPokemon()[0];
            break;
            case 2: currentPokemon = user1.getPokemon()[1];
            break;
            case 3: currentPokemon = user1.getPokemon()[2];
            break;
            default:
                System.out.println("Invalid input!");

        }
        System.out.print("Choose enemy pokemon for the first battle(1-5): ");
        int choiceEnemy = input.nextInt();
        Pokemon enemyPokemon = new Pokemon();
        switch (choiceEnemy){
            case 1: enemyPokemon = pokemons.get(0);
                break;
            case 2: enemyPokemon = pokemons.get(1);
                break;
            case 3: enemyPokemon = pokemons.get(2);
            break;
            case 4: enemyPokemon = pokemons.get(3);
                break;
            case 5: enemyPokemon = pokemons.get(4);
                break;
            default:
                System.out.println("Invalid input!");

        }

       Battle battle1 = new Battle(currentPokemon,enemyPokemon);
        System.out.println("");
        Random rand = new Random();
        int attackNumber = rand.nextInt(5);
        battle1.attackByTheEnemyPokemon(attacks.get(attackNumber),TypeChart.getEffectiveness(enemyPokemon.getType(),currentPokemon.getType()));

    }

}
