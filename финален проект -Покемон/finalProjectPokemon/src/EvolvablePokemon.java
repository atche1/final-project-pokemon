import java.util.Random;

public abstract class EvolvablePokemon implements PokemonAttributes,Evolvable {
    private boolean evolved;

    public boolean isEvolved() {
        return evolved;
    }

    public void evolve() {
        Random random = new Random();
        int randomNumber = random.nextInt(2); // Случайно число от 0 до 10
      // randomNumber=5;
        if (randomNumber == 1) { // Примерно число за еволюция


            if (!evolved) {
                // Логика за еволюцията
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
