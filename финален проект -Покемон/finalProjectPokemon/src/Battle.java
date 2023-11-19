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
        int allDamagePoints = (int) (enemyPokemon.getAttackPoints() * effectiveness) + attackType.getPower();
        enemyPokemon.setDefensePoints(myPokemon.getDefensePoints() - allDamagePoints);
        if (myPokemon.getDefensePoints() < allDamagePoints){
            System.out.println("Defense points of " + myPokemon.getName() + " after attack: "  + 0) ;
            int allDamagePoints2 = allDamagePoints - myPokemon.getDefensePoints();
            if (myPokemon.getHealthPoints() < allDamagePoints2){
                System.out.println("Health points of " + myPokemon.getName() + " after attack: " + 0);
            }
            else{
                myPokemon.setHealthPoints(myPokemon.getHealthPoints() - allDamagePoints2);
                System.out.println("Health points of " + myPokemon.getName() + " after attack: " + myPokemon.getHealthPoints());
            }
        }
        else{
            myPokemon.setDefensePoints(myPokemon.getDefensePoints() - allDamagePoints);
            System.out.println("Health points of " + myPokemon.getName() + " after attack: " + myPokemon.getDefensePoints());
        }
    }
}


