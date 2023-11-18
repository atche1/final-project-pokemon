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
    // методът не връща верен резултат
    void attackByTheEnemyPokemon() {
       double allPoints;
        if (enemyPokemon.getType().equals(PokemonType.WATER) && myPokemon.getType().equals(PokemonType.FIRE)) {
            allPoints = enemyPokemon.getAttackPoints() * TypeChart.getEffectiveness(enemyPokemon.getType(), myPokemon.getType());
            if (myPokemon.getDefensePoints() < allPoints){
                System.out.println("Defense points after attack: " + 0);
                double allPointsAfterAttack = allPoints - myPokemon.getDefensePoints();
                double healthPointsOfMyPokemonAfterAttack = myPokemon.getHealthPoints() - allPointsAfterAttack;
                System.out.println("Health points after attack: " + healthPointsOfMyPokemonAfterAttack);
            }

        }

    }

    }


