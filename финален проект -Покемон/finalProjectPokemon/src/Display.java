import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Display {
    User user1 = new User();
    Pokemon firePokemon = new Pokemon("Dragonus", "Red",PokemonType.FIRE, 100, 50, 30, new Size(Size.SMALL),new Attack());
    Pokemon waterPokemon = new Pokemon("Wobafet", "Blue",PokemonType.WATER, 100, 50, 30, new Size(Size.SMALL),new Attack());
    Pokemon grassPokemon = new Pokemon("Bulbasore", "Green",PokemonType.GRASS, 100, 50, 30, new Size(Size.SMALL),new Attack());
    Pokemon electricPokemon = new Pokemon("Pikachu", "Yellow",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL), new Attack());
    Pokemon flyingPokemon = new Pokemon("Charizard", "Orange",PokemonType.FLYING, 100, 50, 30, new Size(Size.SMALL),new Attack());
    ArrayList<Pokemon> pokemons
            = Stream.of(firePokemon,waterPokemon,grassPokemon,electricPokemon,flyingPokemon)
            .collect(Collectors.toCollection(
                    ArrayList::new));

    public Pokemon choosePokemonForOneBattle(){
        Scanner input = new Scanner(System.in);
        int choice;
        Pokemon currentPokemon = new Pokemon();;
        do {
            System.out.print("Choose pokemon for the first battle(1-3): ");
             choice = input.nextInt();
            switch (choice) {
                case 1:
                    currentPokemon = user1.getPokemon()[0];
                    break;
                case 2:
                    currentPokemon = user1.getPokemon()[1];
                    break;
                case 3:
                    currentPokemon = user1.getPokemon()[2];
                    break;
                default:
                    System.out.println("Invalid input!");

            }
        }
        while(choice > 3);
        return currentPokemon;
    }
    public Pokemon chooseEnemyPokemonForOneBattle(){
        Scanner input = new Scanner(System.in);
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
        attacks.add(new Attack("Blaze Kick",10));
        attacks.add(new Attack("Aqua Cutter",6));
        attacks.add(new Attack("Apple Acid",7));
        attacks.add(new Attack("Charge Beam",8));
        attacks.add(new Attack("Dual Wingbeat",9));
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
        attacks.add(new Attack("Blaze Kick",10));
        attacks.add(new Attack("Aqua Cutter",6));
        attacks.add(new Attack("Apple Acid",7));
        attacks.add(new Attack("Charge Beam",8));
        attacks.add(new Attack("Dual Wingbeat",9));
        Random rand = new Random();
        int attackNumber = rand.nextInt(5);
        Attack currentEnemyAttack = new Attack();
        currentEnemyAttack = attacks.get(attackNumber);
        return currentEnemyAttack;

    }
    public void changeMyPokemon(Battle battle){
        Scanner input = new Scanner(System.in);
        String answer;
        do{
            System.out.println("Do you want to change your pokemon(Y/N)?");
            answer = input.next();
            if (answer.equalsIgnoreCase("Y")){
                user1.showMyPokemon();
                battle.setMyPokemon( choosePokemonForOneBattle());
            }
        }
        while(!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));


    }

    public void displayMainMenu(){
        for (int i = 0; i < 5; i++) {
            System.out.println("\tBATTLE " + (i+1) + "!");
            user1.choosePokemon(pokemons);
            startGame(choosePokemonForOneBattle(),chooseAttackForYourPokemon(),chooseEnemyPokemonForOneBattle(),generatingAttackForEnemyPokemon());
        }

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
        System.out.println(currentEnemyPokemon.getName() + " is using " + attackForEnemyPokemon.getName() + " attack that gets " + attackForMyPokemon.getPower() + " points from your pokemon after every attack!");
        System.out.println(currentMyPokemon.getName() + " is using " + attackForMyPokemon.getName() + " attack that gets " + attackForEnemyPokemon.getPower() + " points from enemy pokemon after every attack!");
        System.out.println("The effectiveness between " + currentMyPokemon.getName() + " and " + currentEnemyPokemon.getName() + ": " + TypeChart.getEffectiveness(currentEnemyPokemon.getType(),currentMyPokemon.getType()));
        while(currentMyPokemon.getHealthPoints() > 0 && currentEnemyPokemon.getHealthPoints() > 0) {
            battle.attackByTheEnemyPokemon(attackForEnemyPokemon, TypeChart.getEffectiveness(currentEnemyPokemon.getType(), currentMyPokemon.getType()));
            if (currentMyPokemon.getHealthPoints() > 0 && currentEnemyPokemon.getHealthPoints() > 0) {
                battle.attackByMyPokemon(attackForMyPokemon, TypeChart.getEffectiveness(currentMyPokemon.getType(), currentEnemyPokemon.getType()));
            }
            if (currentMyPokemon.getHealthPoints() > 0 && currentEnemyPokemon.getHealthPoints() > 0) {
                changeMyPokemon(battle);
            }
        }
        if (currentMyPokemon.getHealthPoints() > 0){
            System.out.println("You are the winner!");
            int currentCrystalsCount = user1.getCrystalsCount();
            currentCrystalsCount += 1;
            user1.setCrystalsCount(currentCrystalsCount);
            System.out.println("Now you have " + user1.getCrystalsCount() + " crystal!");
        }
        else{
            System.out.println("The enemy pokemon is the winner!");

        }

    }
}
