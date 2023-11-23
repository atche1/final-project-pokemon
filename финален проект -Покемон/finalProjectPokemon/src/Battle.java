import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
    private Pokemon myPokemon;
    private Pokemon enemyPokemon;

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

    public Battle(Pokemon myPokemon, Pokemon enemyPokemon) {
        this.myPokemon = myPokemon;
        this.enemyPokemon = enemyPokemon;
    }

    public void attackByTheEnemyPokemon(Attack attackType,double effectiveness) {
        int healthPointsAtTheBeginning = myPokemon.getHealthPoints();
        int attackPoints = (int)(enemyPokemon.getAttackPoints() * effectiveness + attackType.getPower());
           int damage = attackPoints - myPokemon.getDefensePoints();
           int healthPoints = myPokemon.getHealthPoints() - damage;
           myPokemon.setHealthPoints(healthPoints);
           System.out.println("Health points of your pokemon after attack: " + myPokemon.getHealthPoints());
           if (myPokemon.getDefensePoints() > attackPoints){
               myPokemon.setHealthPoints(healthPointsAtTheBeginning);
               System.out.println("Health points of your pokemon after attack: " + myPokemon.getHealthPoints());
           }
    }
    public void attackByMyPokemon(Attack attackType,double effectiveness) {
        int healthPointsAtTheBeginning = enemyPokemon.getHealthPoints();
        int attackPoints = (int)(myPokemon.getAttackPoints() * effectiveness + attackType.getPower());
            int damage = attackPoints - enemyPokemon.getDefensePoints();
            int healthPoints = enemyPokemon.getHealthPoints() - damage;
            enemyPokemon.setHealthPoints(healthPoints);
            System.out.println("Health points of enemy pokemon after attack: " + enemyPokemon.getHealthPoints());
            if (enemyPokemon.getDefensePoints() > attackPoints){
                enemyPokemon.setDefensePoints(healthPointsAtTheBeginning);
                System.out.println("Health points of enemy pokemon after attack: " + enemyPokemon.getHealthPoints());
            }

    }
}


