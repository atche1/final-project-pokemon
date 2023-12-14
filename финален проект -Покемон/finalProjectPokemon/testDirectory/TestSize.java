import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestSize {
    @Test
    public void testValidSize() {
        String validSize = "Normal";
        Size size = new Size(validSize);
        assertEquals(validSize, size.getSize());
    }

    @Test
    public void testInvalidSize() {
        String invalidSize = "ExtraLarge";
        try {
            new Size(invalidSize);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid size", e.getMessage());
        }
    }
}
