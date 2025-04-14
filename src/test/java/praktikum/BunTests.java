package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTests {

    private Bun bun;
    private final String expectedName = "Test Bun";
    private final float expectedPrice = 123.4f;

    @Before
    public void setUp() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }
}
