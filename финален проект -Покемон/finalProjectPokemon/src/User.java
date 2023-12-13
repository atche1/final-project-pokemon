import java.util.ArrayList;
import java.util.Scanner;

public class User implements Chooseable {
    private Pokemon[] pokemon = new Pokemon[3];
    private int crystalsCount;

    public Pokemon[] getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon[] pokemon) {
        this.pokemon = pokemon;
    }

    public int getCrystalsCount() {
        return crystalsCount;
    }

    public void setCrystalsCount(int crystalsCount) {
        this.crystalsCount = crystalsCount;
    }
    public void showMyPokemon(){
        System.out.println("These are the pokemon you chose: ");
        for (Pokemon pokemon : pokemon) {
            System.out.println(pokemon.getName());
        }
    }

    public void choosePokemon(ArrayList<Pokemon> allPokemon) {
        Scanner input = new Scanner(System.in);
        System.out.println("Available pokemon:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < allPokemon.size(); j++) {
                System.out.println((j + 1) + "." + allPokemon.get(j).getName());
            }
            System.out.println("Choose 3 pokemon");
            pokemon[i] = getPokemonByNumber(allPokemon,i);
            allPokemon.remove(pokemon[i]);
        }
        showMyPokemon();
    }

    public Pokemon getPokemonByNumber(ArrayList<Pokemon> allPokemon,int i) {
        Scanner input = new Scanner(System.in);
        Pokemon pokemon1 = new Pokemon();
        System.out.print("Choose pokemon" + (i + 1) + ": ");
        int numberOfChosenPokemon = input.nextInt();
        switch (numberOfChosenPokemon) {
            case 1: pokemon1 =  allPokemon.get(0);
            break;
            case 2: pokemon1 =  allPokemon.get(1);
            break;
            case 3: pokemon1 =  allPokemon.get(2);
            break;
            case 4: pokemon1 =  allPokemon.get(3);
            break;
            case 5: pokemon1 =  allPokemon.get(4);
            break;
            default:
                System.out.println("You only have 5 pokemon!");
                return getPokemonByNumber(allPokemon,i);
        }
        return pokemon1;
    }

}
