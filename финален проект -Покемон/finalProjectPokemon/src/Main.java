
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

    }
}