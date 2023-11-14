public class Pokemon implements  PokemonAttributes {
    private String name;
    private String appearance;
    private String type;
    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private Size size;

    //дефолтен конструктор
    public Pokemon() {
    }
    //конструктор
    public Pokemon(String name, String appearance, String type, int healthPoints, int attackPoints, int defensePoints, Size size) {
        this.name = name;
        this.appearance = appearance;
        this.type = type;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.size = size;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
}

