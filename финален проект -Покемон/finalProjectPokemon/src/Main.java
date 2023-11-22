
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




        Terrain volcanoTerrain = new Terrain("Volcano");
        Pokemon charmander = new Pokemon("Charmander", "Lizard-like", PokemonType.FIRE, 100, 50, 40,new Size (Size.NORMAL));

        System.out.println("Charmander attack is "+charmander.getAttackPoints());
        TerrainManager.setTerrain(charmander, volcanoTerrain);

        System.out.println("Charmander attack on tarain = "+ volcanoTerrain+ " is " +charmander.getAttackPoints());

        Pokemon duck = new Pokemon("Charmander", "Lizard-like", PokemonType.WATER, 100, 50, 40,new Size (Size.NORMAL));
        System.out.println("Duck attack is "+duck.getAttackPoints());

        double effectivenessFireVSWater= TypeChart.getEffectiveness(charmander.getType(),duck.getType());
        System.out.println("Ефективност на атака Fire vs Watter: " + effectivenessFireVSWater);
        System.out.println("Charmander vd Duck attack is = "+charmander.getAttackPoints()*effectivenessFireVSWater);
    }

    }
