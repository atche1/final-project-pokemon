
public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "Yellow", "Electric", 100, 50, 30, new Size(Size.SMALL));

        // Извличане на информация за покемона
        System.out.println("Name: " + pikachu.getName());
        System.out.println("Appearance: " + pikachu.getAppearance());
        System.out.println("Type: " + pikachu.getType());
        System.out.println("Health Points: " + pikachu.getHealthPoints());
        System.out.println("Attack Points: " + pikachu.getAttackPoints());
        System.out.println("Defense Points: " + pikachu.getDefensePoints());
        System.out.println("Size: " + pikachu.getSize().getSize());

        Pokemon smallPokemon =  new Pokemon("Pikachu", "Yellow", "Electric", 100, 50, 30, new Size(Size.SMALL));
        Pokemon normalPokemon =  new Pokemon("Wobafet", "Yellow", "Electric", 100, 50, 30, new Size(Size.NORMAL));
        Pokemon largePokemon =  new Pokemon("Gengar", "Yellow", "Electric", 100, 50, 30, new Size(Size.LARGE));

        // Показване на стойностите след настройките за размер
        System.out.println("Small Pokemon Stats: HP-" + smallPokemon.getHealthPoints() + " ATK-" + smallPokemon.getAttackPoints() + " DEF-" + smallPokemon.getDefensePoints());
        System.out.println("Normal Pokemon Stats: HP-" + normalPokemon.getHealthPoints() + " ATK-" + normalPokemon.getAttackPoints() + " DEF-" + normalPokemon.getDefensePoints());
        System.out.println("Large Pokemon Stats: HP-" + largePokemon.getHealthPoints() + " ATK-" + largePokemon.getAttackPoints() + " DEF-" + largePokemon.getDefensePoints());
    }

    }
