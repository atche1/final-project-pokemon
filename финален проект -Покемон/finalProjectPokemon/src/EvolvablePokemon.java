import java.util.Random;

public abstract class EvolvablePokemon implements PokemonAttributes,Evolvable {
    private boolean evolved;

    public boolean isEvolved() {
        return evolved;
    }

    public void evolve() {
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        if (randomNumber == 1) {
            if (!evolved) {
                evolved = true;
                applyEvolutionBonuses();
                System.out.println("Pokemon evolved!");
            } else {
                System.out.println("Pokemon is already evolved.");
            }
        }
    }

    protected abstract void applyEvolutionBonuses();
}
