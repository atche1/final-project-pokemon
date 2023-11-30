import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Pokemon pikachu = new Pokemon("Pikachu", "Yellow", "Electric", 100, 50, 30, new Size(Size.SMALL));
//
//        // Извличане на информация за покемона
//        System.out.println("Name: " + pikachu.getName());
//        System.out.println("Appearance: " + pikachu.getAppearance());
//        System.out.println("Type: " + pikachu.getType());
//        System.out.println("Health Points: " + pikachu.getHealthPoints());
//        System.out.println("Attack Points: " + pikachu.getAttackPoints());
//        System.out.println("Defense Points: " + pikachu.getDefensePoints());
//        System.out.println("Size: " + pikachu.getSize().getSize());
//
//        Pokemon smallPokemon =  new Pokemon("Pikachu", "Yellow", "Electric", 100, 50, 30, new Size(Size.SMALL));
//        Pokemon normalPokemon =  new Pokemon("Wobafet", "Yellow", "Electric", 100, 50, 30, new Size(Size.NORMAL));
//        Pokemon largePokemon =  new Pokemon("Gengar", "Yellow", "Electric", 100, 50, 30, new Size(Size.LARGE));
//
//        // Показване на стойностите след настройките за размер
//        System.out.println("Small Pokemon Stats: HP-" + smallPokemon.getHealthPoints() + " ATK-" + smallPokemon.getAttackPoints() + " DEF-" + smallPokemon.getDefensePoints());
//        System.out.println("Normal Pokemon Stats: HP-" + normalPokemon.getHealthPoints() + " ATK-" + normalPokemon.getAttackPoints() + " DEF-" + normalPokemon.getDefensePoints());
//        System.out.println("Large Pokemon Stats: HP-" + largePokemon.getHealthPoints() + " ATK-" + largePokemon.getAttackPoints() + " DEF-" + largePokemon.getDefensePoints());
//

        Pokemon firePokemon = new Pokemon("Dragonus", "Red",PokemonType.FIRE, 100, 50, 30, new Size(Size.SMALL),new Attack("Blaze Kick",20));
        Pokemon waterPokemon = new Pokemon("Wobafet", "Blue",PokemonType.WATER, 100, 50, 30, new Size(Size.SMALL),new Attack("Aqua Cutter",30));
        Pokemon GrassPokemon = new Pokemon("Bulbasore", "Green",PokemonType.GRASS, 100, 50, 30, new Size(Size.SMALL),new Attack("Apple Acid",20));
        Pokemon ElectricPokemon = new Pokemon("Pikachu", "Yellow",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL), new Attack("Charge Beam",15));
        //Добавих още един покемон защото в условието пише че трябва да са 5
        Pokemon flyingPokemon = new Pokemon("Charizard", "Orange",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL),new Attack("Dual Wingbeat",30));
        double effectivenessWaterVsFire = TypeChart.getEffectiveness(waterPokemon.getType(),firePokemon.getType());
        double effectivenessGrassVsFire = TypeChart.getEffectiveness(GrassPokemon.getType(),firePokemon.getType());
        double effectivenessElectricVsFire = TypeChart.getEffectiveness(ElectricPokemon.getType(),firePokemon.getType());
        System.out.println("Ефективност на атака Water VS Fire: " + effectivenessWaterVsFire);
        System.out.println("Ефективност на атака Grass VS Fire: " + effectivenessGrassVsFire);
        System.out.println("Ефективност на атака Electric VS Fire: " + effectivenessElectricVsFire);

        // тестване на мотодите от класа PokemonSelector
        ArrayList<Pokemon> pokemon = new ArrayList<>();
        pokemon.add(firePokemon);
        pokemon.add(waterPokemon);
        pokemon.add(GrassPokemon);
        pokemon.add(ElectricPokemon);
        pokemon.add(flyingPokemon);
        //тестване на класовете атаки
        //атака от страна на покемона противник
        Battle battle1 = new Battle(firePokemon,waterPokemon);
        battle1.attackByTheEnemyPokemon(firePokemon.getAttack(),effectivenessWaterVsFire);
        //атака от страна на нашия покемон
        Battle battle2 = new Battle(firePokemon,GrassPokemon);
        battle2.attackByMyPokemon(flyingPokemon.getAttack(),effectivenessGrassVsFire);
         Display display1 = new Display();
         display1.displayMainMenu();

    }

    }
