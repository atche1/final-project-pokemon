import java.util.ArrayList;
import java.util.Scanner;

public class User implements ChoosingPokemon {
    private Pokemon[] pokemon = new Pokemon[3];
    private int crystalsCount;
    @Override
   /* public void choosePokemon(ArrayList<Pokemon> allPokemon) {
        Scanner input = new Scanner(System.in);
        System.out.println("Available pokemon:");
        for (int i = 0; i < allPokemon.size(); i++) {
            System.out.println((i + 1) + ". " + allPokemon.get(i).getName());
        }
        System.out.println("Choose 3 pokemon");
        for (int i = 0; i < 3; i++) {
            System.out.print("Choose pokemon" + (i + 1) + ": ");
            int numberOfChosenPokemon = input.nextInt();
            try {
                {
                    if (numberOfChosenPokemon <= 0 || numberOfChosenPokemon > 5) {
                        throw new Exception("You only have 5 pokemon!");
                    }
                    switch (numberOfChosenPokemon) {
                        case 1:
                            pokemon[i] = allPokemon.get(0);
                            break;

                        case 2:
                            pokemon[i] = allPokemon.get(1);
                            break;
                        case 3:
                            pokemon[i] = allPokemon.get(2);
                            break;
                        case 4:
                            pokemon[i] = allPokemon.get(3);
                            break;

                        case 5:
                            pokemon[i] = allPokemon.get(4);
                            break;

                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Choose 3 pokemon");
                for (i = 0; i < 3; i++) {
                    System.out.print("Choose pokemon" + (i + 1) + ": ");
                    numberOfChosenPokemon = input.nextInt();

                    {
                        switch (numberOfChosenPokemon) {
                            case 1:
                                chosenPokemon.add(allPokemon.get(0));
                                break;

                            case 2:
                                chosenPokemon.add(allPokemon.get(1));
                                break;
                            case 3:
                                chosenPokemon.add(allPokemon.get(2));
                                break;
                            case 4:
                                chosenPokemon.add(allPokemon.get(3));
                                break;

                            case 5:
                                chosenPokemon.add(allPokemon.get(4));
                                break;
                        }
                    }
                }

            }
        }
        System.out.println("These are the pokemon you chose: ");
        for (Pokemon pokemon : chosenPokemon) {
            System.out.println(pokemon.getName());
        }
    }
    */
    public void choosePokemon(ArrayList<Pokemon> allPokemon) {
        Scanner input = new Scanner(System.in);
        System.out.println("Available pokemon:");
        for (int i = 0; i < allPokemon.size(); i++) {
            System.out.println((i + 1) + ". " + allPokemon.get(i).getName());
        }
        System.out.println("Choose 3 pokemon");
        for (int i = 0; i < 3; i++) {
            pokemon[i] = getPokemonByNumber(allPokemon,i);
        }
        System.out.println("These are the pokemon you chose: ");
        for (Pokemon pokemon : pokemon) {
            System.out.println(pokemon.getName());
        }
    }

    public Pokemon getPokemonByNumber(ArrayList<Pokemon> allPokemon,int i) {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose pokemon" + (i + 1) + ": ");
        int numberOfChosenPokemon = input.nextInt();
        switch (numberOfChosenPokemon) {
            case 1: return allPokemon.get(0);
            case 2: return allPokemon.get(1);
            case 3: return allPokemon.get(2);
            case 4: return allPokemon.get(3);
            case 5: return allPokemon.get(4);
            default:
                System.out.println("You only have 5 pokemon!");
                return getPokemonByNumber(allPokemon,i);
        }
    }

}
