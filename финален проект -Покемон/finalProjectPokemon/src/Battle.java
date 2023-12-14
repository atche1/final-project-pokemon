import java.util.ArrayList;

public class Battle {
    private Pokemon myPokemon;
    private Pokemon enemyPokemon;
    private Terrain volcanoTerrain = new Terrain("Sea");
    private Terrain selectedTerrain;

    public Pokemon getMyPokemon() {
        return myPokemon;
    }

    public void setMyPokemon(Pokemon myPokemon) {
        this.myPokemon = myPokemon;
    }

    public Pokemon getEnemyPokemon() {
        return enemyPokemon;
    }

    public void setEnemyPokemon(Pokemon enemyPokemon) {
        this.enemyPokemon = enemyPokemon;
    }

    public void setSelectedTerrain(Terrain selectedTerrain) {
        this.selectedTerrain = selectedTerrain;
    }

    public Battle(Pokemon myPokemon, Pokemon enemyPokemon , Terrain selectedTerrain) {
        this.myPokemon = myPokemon;
        this.enemyPokemon = enemyPokemon;
       this.selectedTerrain=selectedTerrain;
     }

    public void attackByTheEnemyPokemon(Attack attackType, double effectiveness) {
        TerrainManager.setTerrain(enemyPokemon, volcanoTerrain);
        EvolutionManager.evolvePokemon(enemyPokemon);
        // това е излишно мисля
        int healthPointsAtTheBeginning = myPokemon.getHealthPoints();
        int attackPoints = (int) (enemyPokemon.getAttackPoints() * effectiveness + attackType.getPower());
        int damage = attackPoints - myPokemon.getDefensePoints();
        int healthPoints = myPokemon.getHealthPoints() - damage;
        if(myPokemon.getDefensePoints()>attackPoints){
            System.out.println("Your attack is negated. Pokemon took 0 dmg");
        }else if (myPokemon.getDefensePoints()<attackPoints){
            myPokemon.setHealthPoints(healthPoints);
            System.out.println("Health points of your pokemon after attack: " + (myPokemon.getHealthPoints() > 0 ? myPokemon.getHealthPoints() : 0));
        }

    }

    public void attackByMyPokemon(Attack attackType, double effectiveness) {

       TerrainManager.setTerrain(myPokemon, selectedTerrain);
       EvolutionManager.evolvePokemon(myPokemon);
        System.out.println( "Attack after terain bonus"+myPokemon.getAttackPoints());
        // това е излишно мисля
        int healthPointsAtTheBeginning = enemyPokemon.getHealthPoints();
        int attackPoints = (int) (myPokemon.getAttackPoints() * effectiveness + attackType.getPower());
        int damage = attackPoints - enemyPokemon.getDefensePoints();
        int healthPoints = enemyPokemon.getHealthPoints() - damage;

        if(enemyPokemon.getDefensePoints()>attackPoints){
            System.out.println("Your attack againts the enemy is negated. Pokemon took 0 dmg");
        }else if (enemyPokemon.getDefensePoints()<attackPoints){
            enemyPokemon.setHealthPoints(healthPoints);
            System.out.println("Health points of enemy pokemon after attack: " + (enemyPokemon.getHealthPoints() > 0 ? enemyPokemon.getHealthPoints() : 0));
        }
        if(enemyPokemon.getHealthPoints()<0){
            myPokemon.setHealthPoints(100);
        }
    }

}


