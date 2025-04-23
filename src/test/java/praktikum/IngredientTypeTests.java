package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTests {

    private final String SAUCE_NAME = "SAUCE";
    private final String FILLING_NAME = "FILLING";

    @Test
    public void enumShouldContainSauce() {
        assertNotNull("Тип SAUCE не найден в перечислении IngredientType", IngredientType.valueOf(SAUCE_NAME));
    }

    @Test
    public void enumShouldContainFilling() {
        assertNotNull("Тип FILLING не найден в перечислении IngredientType", IngredientType.valueOf(FILLING_NAME));
    }

    @Test
    public void sauceToStringShouldReturnCorrectName() {
        assertEquals("Строковое представление SAUCE некорректно", SAUCE_NAME, IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingToStringShouldReturnCorrectName() {
        assertEquals("Строковое представление FILLING некорректно", FILLING_NAME, IngredientType.FILLING.toString());
    }
}
