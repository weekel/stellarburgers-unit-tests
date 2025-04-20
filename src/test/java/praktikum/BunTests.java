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
        assertEquals("Ожидалось другое имя булки", expectedName, actualName);
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        float actualPrice = bun.getPrice();
        assertEquals("Ожидалась другая цена булки", expectedPrice, actualPrice, 0.01f);
    }
}
