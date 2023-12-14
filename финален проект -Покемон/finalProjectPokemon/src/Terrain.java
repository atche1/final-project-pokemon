public class Terrain {
    private String type;

    public Terrain() {
    }

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
