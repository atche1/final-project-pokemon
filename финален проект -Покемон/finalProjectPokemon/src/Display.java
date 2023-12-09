import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Display {
    User user1 = new User();
    Pokemon firePokemon = new Pokemon("Dragonus", "Red",PokemonType.FIRE, 100, 50, 30, new Size(Size.SMALL),new Attack());
    Pokemon waterPokemon = new Pokemon("Wobafet", "Blue",PokemonType.WATER, 100, 50, 30, new Size(Size.SMALL),new Attack());
    Pokemon grassPokemon = new Pokemon("Bulbasore", "Green",PokemonType.GRASS, 100, 50, 30, new Size(Size.SMALL),new Attack());
    Pokemon electricPokemon = new Pokemon("Pikachu", "Yellow",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL), new Attack());
    Pokemon flyingPokemon = new Pokemon("Charizard", "Orange",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL),new Attack());

    public Pokemon choosePokemonForOneBattle(){
        Scanner input = new Scanner(System.in);
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(firePokemon);
        pokemons.add(waterPokemon);
        pokemons.add(grassPokemon);
        pokemons.add(flyingPokemon);
        pokemons.add(electricPokemon);
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
        return currentPokemon;
    }
    public Pokemon chooseEnemyPokemonForOneBattle(){
        Scanner input = new Scanner(System.in);
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(firePokemon);
        pokemons.add(waterPokemon);
        pokemons.add(grassPokemon);
        pokemons.add(flyingPokemon);
        pokemons.add(electricPokemon);
        System.out.println("These are the available pokemon: ");
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println((i + 1) + "." + pokemons.get(i).getName());
        }
        System.out.print("Choose enemy pokemon for the first battle(1-5): ");
        int choiceEnemy = input.nextInt();
        Pokemon currentenemyPokemon = new Pokemon();
        switch (choiceEnemy){
            case 1: currentenemyPokemon = pokemons.get(0);
                break;
            case 2: currentenemyPokemon = pokemons.get(1);
                break;
            case 3: currentenemyPokemon = pokemons.get(2);
                break;
            case 4: currentenemyPokemon = pokemons.get(3);
                break;
            case 5: currentenemyPokemon = pokemons.get(4);
                break;
            default:
                System.out.println("Invalid input!");

        }
        return currentenemyPokemon;

    }
    public Attack chooseAttackForYourPokemon(){
        Scanner input = new Scanner(System.in);
        ArrayList<Attack> attacks = new ArrayList<>();
        attacks.add(new Attack("Blaze Kick",20));
        attacks.add(new Attack("Aqua Cutter",30));
        attacks.add(new Attack("Apple Acid",20));
        attacks.add(new Attack("Charge Beam",15));
        attacks.add(new Attack("Dual Wingbeat",30));
        System.out.println("Choose attack for the first battle for your pokemon(1-5): ");
        System.out.println("These are the available attacks: ");
        for (int i = 0; i < attacks.size(); i++) {
            System.out.println((i + 1) + ".Name: " + attacks.get(i).getName() + ", power: " + attacks.get(i).getPower());
        }
        int attackChoice = input.nextInt();
        Attack currentAttack = new Attack();
        switch(attackChoice){
            case 1: currentAttack = attacks.get(0);
                break;
            case 2: currentAttack = attacks.get(1);
                break;
            case 3: currentAttack = attacks.get(2);
                break;
            case 4: currentAttack = attacks.get(3);
                break;
            case 5: currentAttack = attacks.get(4);
                break;
            default:
                System.out.println("Invalid input!");
        }
        return currentAttack;
    }
    public Attack generatingAttackForEnemyPokemon(){
        ArrayList<Attack> attacks = new ArrayList<>();
        attacks.add(new Attack("Blaze Kick",20));
        attacks.add(new Attack("Aqua Cutter",30));
        attacks.add(new Attack("Apple Acid",20));
        attacks.add(new Attack("Charge Beam",15));
        attacks.add(new Attack("Dual Wingbeat",30));
        Random rand = new Random();
        int attackNumber = rand.nextInt(5);
        Attack currentEnemyAttack = new Attack();
        currentEnemyAttack = attacks.get(attackNumber);
        return currentEnemyAttack;

    }

    public void displayMainMenu(){
        startGame(choosePokemonForOneBattle(),chooseAttackForYourPokemon(),chooseEnemyPokemonForOneBattle(),generatingAttackForEnemyPokemon());

    }
    public void startGame(Pokemon currentMyPokemon,Attack attackForMyPokemon,Pokemon currentEnemyPokemon,Attack attackForEnemyPokemon){
        Battle battle = new Battle(currentMyPokemon,currentEnemyPokemon);
        System.out.println("Health points of your pokemon: " + currentMyPokemon.getName() + ": " + currentMyPokemon.getHealthPoints());
        System.out.println("Health points of enemy pokemon: " + currentEnemyPokemon.getName() + ": " + currentEnemyPokemon.getHealthPoints());
        System.out.println("Attack points of your pokemon: " + currentMyPokemon.getAttackPoints());
        System.out.println("Attack points of enemy pokemon: " + currentEnemyPokemon.getAttackPoints());
        System.out.println("Defense points of your pokemon: " + currentMyPokemon.getDefensePoints());
        System.out.println("Defense points of enemy pokemon: " + currentEnemyPokemon.getDefensePoints());
        System.out.println("The battle between your pokemon " + currentMyPokemon.getName() + " and enemy pokemon " + currentEnemyPokemon.getName() + " has started!");
        System.out.println("The first attack is made by the opponent pokemon!");
        System.out.println(currentEnemyPokemon.getName() + " is using " + attackForEnemyPokemon.getName() + " attack that gets " + attackForMyPokemon.getPower() + " points from your pokemon!");
        System.out.println("The effectiveness between " + currentMyPokemon.getName() + " and " + currentEnemyPokemon.getName() + ": " + TypeChart.getEffectiveness(currentEnemyPokemon.getType(),currentMyPokemon.getType()));
        battle.attackByTheEnemyPokemon(attackForEnemyPokemon, TypeChart.getEffectiveness(currentEnemyPokemon.getType(), currentMyPokemon.getType()));
        if (currentMyPokemon.getHealthPoints() > 0) {
            battle.attackByMyPokemon(attackForMyPokemon, TypeChart.getEffectiveness(currentMyPokemon.getType(), currentEnemyPokemon.getType()));
        }
    }
}
