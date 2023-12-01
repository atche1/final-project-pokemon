import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestSize {
    @Test
    public void testValidSize() {
        // Arrange
        String validSize = "Normal";

        // Act
        Size size = new Size(validSize);

        // Assert
        assertEquals(validSize, size.getSize());
    }

    @Test
    public void testInvalidSize() {
        // Arrange
        String invalidSize = "ExtraLarge";

        // Act and Assert
        try {
            new Size(invalidSize);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid size", e.getMessage());
        }
    }
}
