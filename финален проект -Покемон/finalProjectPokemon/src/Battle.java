import java.util.ArrayList;
import java.util.Scanner;

public class Battle implements ChoosingPokemon{
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
    Battle(ArrayList<Pokemon> allPokemon){
        this.allPokemon = allPokemon;
    }

    // method for choosing pokemon

    @Override
    public void choosePokemon() {
        ArrayList<Pokemon> chosenPokemon = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Available pokemon:");
        for (int i = 0; i < allPokemon.size() ; i++) {
            System.out.println((i+1) + ". " + allPokemon.get(i).getName());
        }
        System.out.println("Choose 3 pokemon: ");
        for (int i = 0; i < 3; i++) {
            System.out.print("Choose pokemon" + (i+1) + ": ");
            int numberOfChosenPokemon = input.nextInt();
            if (numberOfChosenPokemon >=1 && numberOfChosenPokemon <=5) {
                switch (numberOfChosenPokemon) {
                    case 1 -> {
                        chosenPokemon.add(allPokemon.get(0));
                        allPokemon.remove(0);
                    }
                    case 2 -> {
                        chosenPokemon.add(allPokemon.get(1));
                        allPokemon.remove(1);
                    }
                    case 3 -> {
                        chosenPokemon.add(allPokemon.get(2));
                        allPokemon.remove(2);
                    }
                    case 4 -> {
                        chosenPokemon.add(allPokemon.get(3));
                        allPokemon.remove(3);
                    }
                    case 5 -> {
                        chosenPokemon.add(allPokemon.get(4));
                        allPokemon.remove(4);
                    }
                }
            }else{
                System.out.println("You only have 5 pokemon!");
            }
        }
        System.out.println("These are the pokemon you chose: ");
        for (int i = 0; i < chosenPokemon.size(); i++) {
            System.out.println(chosenPokemon.get(i).getName());
        }

    }
}
