public class Terrain {
    // създаване на клас за терен
    private String type;

    public Terrain() {
    }

    // създаване на get / set за този клас
    public Terrain(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    // toString за визуализиране
    @Override
    public String toString() {
        return "Terrain{" +
                "type='" + type + '\'' +
                '}';
    }
}
