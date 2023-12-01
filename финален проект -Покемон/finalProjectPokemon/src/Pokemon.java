import java.util.HashMap;
import java.util.Map;

public class Pokemon extends EvolvablePokemon implements PokemonAttributes {
    private static final double SMALL_SIZE_MODIFIER = 0.8;
    private static final double LARGE_SIZE_MODIFIER = 1.2;

    private String name;
    private String appearance;
    private PokemonType type;

    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private Size size;
    private Attack attack;

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }



    //дефолтен конструктор
    public Pokemon() {
    }
    //конструктор


    public Pokemon(String name, String appearance, PokemonType type, int healthPoints, int attackPoints, int defensePoints, Size size, Attack attack) {
        this.name = name;
        this.appearance = appearance;
        this.type = type;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.size = size;
        this.attack = attack;
    }

    protected void adjustStatsBySize() {
        switch (size.getSize()) {
            case Size.SMALL:
                // Намаляване на точките с 20%
                healthPoints = (int) (healthPoints * SMALL_SIZE_MODIFIER);
                attackPoints = (int) (attackPoints * SMALL_SIZE_MODIFIER);
                defensePoints = (int) (defensePoints * SMALL_SIZE_MODIFIER);
                break;
            case Size.LARGE:
                // Увеличаване на точките с 20%
                healthPoints = (int) (healthPoints * LARGE_SIZE_MODIFIER);
                attackPoints = (int) (attackPoints * LARGE_SIZE_MODIFIER);
                defensePoints = (int) (defensePoints * LARGE_SIZE_MODIFIER);
                break;
            // Останалите случаи (Size.NORMAL) ще бъдат игнорирани и няма да има промени
            default:
                break;
        }
    }

    // гетери и сетъри
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public int getAttackPoints() {
        return attackPoints;
    }

    @Override
    public int getDefensePoints() {
        return defensePoints;
    }

    // метод за добавяне на атака според терена
    public void adjustStatsByTerrain() {
        Terrain terrain = TerrainManager.getTerrain(this);
        if(terrain !=null) {
            if (terrain.getType().equals("Volcano") && type == PokemonType.FIRE) {
                attackPoints += 20; // Подходящ терен за огнени покемони на вулкан
            } else if (terrain.getType().equals("Sea") && type == PokemonType.WATER) {
                attackPoints += 15; // Подходящ терен за воден покемони на море
            } else if (terrain.getType().equals("Forest") && type == PokemonType.GRASS) {
                attackPoints += 10; // Подходящ терен за Горски покемони на гора
            } else {
                System.out.println("No terrain bonus");
            }
        }
    }

    @Override
    protected void applyEvolutionBonuses() {
        // Логика за бонусите за еволюцията на Pokemon
        attackPoints += 30;
        defensePoints += 15;
        healthPoints += 50;
    }

}

