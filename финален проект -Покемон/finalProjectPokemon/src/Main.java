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


        //веднъж преди началото на битката ще се избира терен за битката
        Terrain volcanoTerrain = new Terrain("Volcano");
        Pokemon charmander = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40,new Size (Size.NORMAL),new Attack("Apple Acid",20));

        System.out.println("Charmander attack is "+charmander.getAttackPoints());
        TerrainManager.setTerrain(charmander, volcanoTerrain);

        System.out.println("Charmander attack on tarain = "+ volcanoTerrain+ " is " +charmander.getAttackPoints());

        Pokemon duck = new Pokemon("Charmander", "Lizard-like", PokemonType.WATER, 100, 50, 40,new Size (Size.NORMAL),new Attack("Apple Acid",20));
        System.out.println("Duck attack is "+duck.getAttackPoints());

        double effectivenessFireVSWater= TypeChart.getEffectiveness(charmander.getType(),duck.getType());
        System.out.println("Ефективност на атака Fire vs Watter: " + effectivenessFireVSWater);
        System.out.println("Charmander vd Duck attack is = "+charmander.getAttackPoints()*effectivenessFireVSWater);

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

        //charmander.setAttackPoints( (int) (charmander.getAttackPoints()*effectivenessFireVSWater));
        //тази ефективност ще се прилага само при атаката на един ход , няма да променя цялата аката на покемона
        //защото като дойде следващия покемон може ефективноста да е друга и за да не се налага постоя да даваме
        //началната атака на покемона и после да му я сменяме с ефективноста , ефективноста ще я приложим само при
        //атаката за да се сметне колко точно кръв ще се вземе от противниковия покемон
        // hp-=charmander.getAttackPoints()*effectivenessFireVSWater пример
        // по този начин ако покемона на противника умре и дойде следващоя там ще се смята ефективноста към него
        // като базовара атака на покемона няма да се е променила
        // Единственото което променя атаката на покемона ще бъде Еволюцията и Размера му което се задава още при
        // създаването на дадения покемон , и вида на терена което се определя преди началото на битката

        // в началото на всеки вход на покемон ще се проверява дали може да еволюира, ако е успял да еволюира
        // повече няма да се правят опити за еволюция
        EvolutionManager.evolvePokemon(charmander);
        System.out.println(charmander.getAttackPoints());
        System.out.println("Charmander vd Duck attack is = "+charmander.getAttackPoints()*effectivenessFireVSWater);

        Display display = new Display();
        display.displayMainMenu();
    }

    }
