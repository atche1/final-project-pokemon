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

        Pokemon firePokemon = new Pokemon("Dragonus", "Red",PokemonType.FIRE, 100, 50, 30, new Size(Size.SMALL));
        Pokemon waterPokemon = new Pokemon("Wobafet", "Blue",PokemonType.WATER, 100, 50, 30, new Size(Size.SMALL));
        Pokemon GrassPokemon = new Pokemon("Bulbasore", "Green",PokemonType.GRASS, 100, 50, 30, new Size(Size.SMALL));
        Pokemon ElectricPokemon = new Pokemon("Pikachu", "Yellow",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL));
        //Добавих още един покемон защото в условието пише че трябва да са 5
        Pokemon flyingPokemon = new Pokemon("Charizard", "Orange",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL));
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
        PokemonSelector select1 = new PokemonSelector(pokemon);
        select1.choosePokemon();
        //тестване на класовете атаки
        Attack firePokemonAttack = new FirePokemonAttack("Blaze Kick",20);
        Attack flyingPokemonAttack = new FlyingPokemonAttack("Dual Wingbeat",30);
        Attack electricPokemonAttack = new ElectricPokemonAttack("Charge Beam",15);
        Attack grassPokemonAttack = new GrassPokemonAttack("Apple Acid",20);
        Attack waterPokemonAttack = new WaterPokemonAttack("Aqua Cutter",30);

        Attack firePokemonAttack2 = new FirePokemonAttack("Fire Fang",15);
        Attack flyingPokemonAttack2 = new FlyingPokemonAttack("Air Slash",25);
        Attack electricPokemonAttack2 = new ElectricPokemonAttack("Discharge",30);
        Attack grassPokemonAttack2 = new GrassPokemonAttack("Flower Trick",20);
        Attack waterPokemonAttack2 = new WaterPokemonAttack("Aqua Jet",35);
        //атака от страна на покемона противник
        Battle battle1 = new Battle(firePokemon,waterPokemon);
        battle1.attackByTheEnemyPokemon(waterPokemonAttack,effectivenessWaterVsFire);
        //атака от страна на нашия покемон
        Battle battle2 = new Battle(firePokemon,GrassPokemon);
        battle2.attackByMyPokemon(grassPokemonAttack,effectivenessGrassVsFire);

    }

    }
