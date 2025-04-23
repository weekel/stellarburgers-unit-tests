package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTests {

    private Ingredient ingredient;

    private final IngredientType expectedIngType = IngredientType.SAUCE;
    private final String expectedName = "White Sauce";
    private final float expectedPrice = 45.34f;

    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedIngType, expectedName, expectedPrice);
    }

    @Test
    public void getTypeShouldReturnCorrectType() {
        IngredientType actualIngType = ingredient.getType();
        assertEquals("Тип ингредиента не совпадает с ожидаемым", expectedIngType, actualIngType);
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        String actualName = ingredient.getName();
        assertEquals("Название ингредиента не совпадает с ожидаемым", expectedName, actualName);
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        float actualPrice = ingredient.getPrice();
        assertEquals("Цена ингредиента не совпадает с ожидаемой", expectedPrice, actualPrice, 0.01f);
    }
}
