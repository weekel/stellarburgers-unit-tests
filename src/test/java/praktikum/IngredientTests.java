package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTests {

    private Ingredient ingredient;

    private final IngredientType expectedIngType = IngredientType.SAUCE;
    private final String expectedName = "White Sauce";
    private final float expectedPrice = 45.34f;
    private IngredientType actualIngType;
    private String actualName;
    private float actualPrice;

    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedIngType, expectedName, expectedPrice);
    }

    @Test
    public void getTypeShouldReturnCorrectType() {
        actualIngType = ingredient.getType();
        assertEquals(expectedIngType, actualIngType);
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }
}
