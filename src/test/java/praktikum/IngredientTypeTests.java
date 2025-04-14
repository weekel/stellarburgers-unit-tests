package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTests {

    private final String SAUCE_NAME = "SAUCE";
    private final String FILLING_NAME = "FILLING";

    @Test
    public void enumShouldContainSauce() {
        assertNotNull(IngredientType.valueOf(SAUCE_NAME));
    }

    @Test
    public void enumShouldContainFilling() {
        assertNotNull(IngredientType.valueOf(FILLING_NAME));
    }

    @Test
    public void sauceToStringShouldReturnCorrectName() {
        assertEquals(SAUCE_NAME, IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingToStringShouldReturnCorrectName() {
        assertEquals(FILLING_NAME, IngredientType.FILLING.toString());
    }
}
