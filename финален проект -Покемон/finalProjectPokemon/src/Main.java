
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

//        Pokemon firePokemon = new Pokemon("Dragonus", "Red",PokemonType.FIRE, 100, 50, 30, new Size(Size.SMALL));
//        Pokemon waterPokemon = new Pokemon("Wobafet", "Blue",PokemonType.WATER, 100, 50, 30, new Size(Size.SMALL));
//        Pokemon GrassPokemon = new Pokemon("Bulbasore", "Green",PokemonType.GRASS, 100, 50, 30, new Size(Size.SMALL));
//        Pokemon ElectricPokemon = new Pokemon("Pikachu", "Yellow",PokemonType.ELECTRIC, 100, 50, 30, new Size(Size.SMALL));
//        double effectivenessWaterVsFire = TypeChart.getEffectiveness(waterPokemon.getType(),firePokemon.getType());
//        double effectivenessGrassVsFire = TypeChart.getEffectiveness(GrassPokemon.getType(),firePokemon.getType());
//        double effectivenessElectricVsFire = TypeChart.getEffectiveness(ElectricPokemon.getType(),firePokemon.getType());
//        System.out.println("Ефективност на атака Water VS Fire: " + effectivenessWaterVsFire);
//        System.out.println("Ефективност на атака Grass VS Fire: " + effectivenessGrassVsFire);
//        System.out.println("Ефективност на атака Electric VS Fire: " + effectivenessElectricVsFire);



        //веднъж преди началото на битката ще се избира терен за битката
        Terrain volcanoTerrain = new Terrain("Volcano");
        Pokemon charmander = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40,new Size (Size.NORMAL));

        System.out.println("Charmander attack is "+charmander.getAttackPoints());

        // ефективноста на терена ще се поставя на всички покемони
        TerrainManager.setTerrain(charmander, volcanoTerrain);

        System.out.println("Charmander attack on tarain = "+ volcanoTerrain+ " is " +charmander.getAttackPoints());

        Pokemon duck = new Pokemon("Duck", "Duck", PokemonType.WATER, 100, 50, 40,new Size (Size.NORMAL));
        System.out.println("Duck attack is "+duck.getAttackPoints());

        // на всеки вход преди атаката ще се проверява ефективноста на даден покемон срещу дригия
        double effectivenessFireVSWater= TypeChart.getEffectiveness(charmander.getType(),duck.getType());
        System.out.println("Ефективност на атака Fire vs Watter: " + effectivenessFireVSWater);
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
        System.out.println("Charmander vs Duck attack is = "+charmander.getAttackPoints()*effectivenessFireVSWater);



        // в началото на всеки вход на покемон ще се проверява дали може да еволюира, ако е успял да еволюира
        // повече няма да се правят опити за еволюция
        EvolutionManager.evolvePokemon(charmander);
        System.out.println(charmander.getAttackPoints());
    }

    }
