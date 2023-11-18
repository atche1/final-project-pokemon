import java.util.ArrayList;
import java.util.Scanner;

public class PokemonSelector implements ChoosingPokemon {
    private ArrayList<Pokemon> allPokemon;
    private Pokemon myPokemon;
    private Pokemon enemyPokemon;

    // getters and setters
    public Pokemon getMyPokemon() {
        return myPokemon;
    }

    public void setMyPokemon(Pokemon myPokemon) {
        this.myPokemon = myPokemon;
    }

    public Pokemon getEnemyPokemon() {
        return enemyPokemon;
    }

    public void setEnemyPokemon(Pokemon enemyPokemon) {
        this.enemyPokemon = enemyPokemon;
    }

    public ArrayList<Pokemon> getAllPokemon() {
        return allPokemon;
    }

    public void setAllPokemon(ArrayList<Pokemon> allPokemon) {
        this.allPokemon = allPokemon;
    }

    PokemonSelector(ArrayList<Pokemon> allPokemon) {
        this.allPokemon = allPokemon;
    }

    // method for choosing pokemon

    @Override
    public void choosePokemon() {
        ArrayList<Pokemon> chosenPokemon = new ArrayList<>();
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
                        case 1 -> {
                            chosenPokemon.add(allPokemon.get(0));
                        }
                        case 2 -> {
                            chosenPokemon.add(allPokemon.get(1));
                        }
                        case 3 -> {
                            chosenPokemon.add(allPokemon.get(2));
                        }
                        case 4 -> {
                            chosenPokemon.add(allPokemon.get(3));
                        }
                        case 5 -> {
                            chosenPokemon.add(allPokemon.get(4));
                        }
                    }
                }
            }
            catch (Exception e) {
                System.out.println(e);
                System.out.println("Choose 3 pokemon");
                for (i = 0; i < 3; i++) {
                    System.out.print("Choose pokemon" + (i + 1) + ": ");
                    numberOfChosenPokemon = input.nextInt();

                    {
                        switch (numberOfChosenPokemon) {
                            case 1 -> {
                                chosenPokemon.add(allPokemon.get(0));
                            }
                            case 2 -> {
                                chosenPokemon.add(allPokemon.get(1));
                            }
                            case 3 -> {
                                chosenPokemon.add(allPokemon.get(2));
                            }
                            case 4 -> {
                                chosenPokemon.add(allPokemon.get(3));
                            }
                            case 5 -> {
                                chosenPokemon.add(allPokemon.get(4));
                            }
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
    }

