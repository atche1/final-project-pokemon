public class Size {
    public static final String SMALL = "Small";
    public static final String NORMAL = "Normal";
    public static final String LARGE = "Large";

    private String size;

    public Size(String size) {
        // Проверка за валидност на размера
        if (size.equals(SMALL) || size.equals(NORMAL) || size.equals(LARGE)) {
            this.size = size;
        } else {
            throw new IllegalArgumentException("Invalid size");
        }
    }

    public String getSize() {
        return size;
    }
}
