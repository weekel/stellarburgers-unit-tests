package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Enclosed.class)
public class BurgerTests {


    public static class BurgerNonParameterizedTests {
        private Burger burger;

        @Mock
        private Bun mockBun;

        @Mock
        private Ingredient mockIngredient1;

        @Mock
        private Ingredient mockIngredient2;

        @Before
        public void setUp() {
            initMocks(this);
            burger = new Burger();
            burger.addIngredient(mockIngredient1);
            burger.addIngredient(mockIngredient2);
        }

        @Test
        public void setBunsShouldAssignMockBunCorrectly() {
            burger.setBuns(mockBun);

            Bun actualBun = burger.bun;
            assertEquals("Установленная булка не совпадает с ожидаемой", mockBun, actualBun);
        }

        @Test
        public void addIngredientShouldAddIngredientToList() {
            burger = new Burger();
            burger.addIngredient(mockIngredient1);

            Ingredient actualIngredient = burger.ingredients.get(0);
            assertEquals("Ингредиент не был добавлен в список", mockIngredient1, actualIngredient);
        }

        @Test
        public void removeIngredientShouldRemoveIngredientFromList() {
            burger.removeIngredient(0);

            int expectedListSize = 1;
            int actualListSize = burger.ingredients.size();
            assertEquals("Размер списка ингредиентов после удаления некорректен", expectedListSize, actualListSize);
        }

        @Test
        public void removeIngredientShouldLeaveCorrectIngredient() {
            burger.removeIngredient(0);

            Ingredient expectedRemaining = mockIngredient2;
            Ingredient actualRemaining = burger.ingredients.get(0);
            assertEquals("Удалён не тот ингредиент", expectedRemaining, actualRemaining);
        }

        @Test
        public void moveIngredientShouldMoveFirstIngredientToSecondPosition() {
            burger.moveIngredient(0, 1);

            Ingredient firstIngredient = burger.ingredients.get(0);

            assertEquals("Ингредиент на позиции 0 не соответствует ожидаемому", mockIngredient2, firstIngredient);
        }

        @Test
        public void moveIngredientShouldMoveSecondIngredientToFirstPosition() {
            burger.moveIngredient(0, 1);

            Ingredient secondIngredient = burger.ingredients.get(1);

            assertEquals("Ингредиент на позиции 1 не соответствует ожидаемому",mockIngredient1, secondIngredient);
        }



        @Test
        public void getReceiptShouldReturnCorrectFormattedReceipt() {
            when(mockBun.getName()).thenReturn("black bun");
            when(mockBun.getPrice()).thenReturn(100f);

            when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
            when(mockIngredient1.getName()).thenReturn("hot sauce");
            when(mockIngredient1.getPrice()).thenReturn(100f);

            when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
            when(mockIngredient2.getName()).thenReturn("dinosaur");
            when(mockIngredient2.getPrice()).thenReturn(200f);

            burger.setBuns(mockBun);

            String expectedReceipt = "(==== black bun ====)\r\n" +
                    "= sauce hot sauce =\r\n" +
                    "= filling dinosaur =\r\n" +
                    "(==== black bun ====)\r\n\r\n" +
                    "Price: 500,000000\r\n";

            String actualReceipt = burger.getReceipt();
            assertEquals("Сформированный чек не соответствует ожидаемому", expectedReceipt, actualReceipt);
        }
    }

    @RunWith(Parameterized.class)
    public static class BurgerParameterizedTests {
        private Burger burger;

        private final float bunPrice;
        private final float ingredient1Price;
        private final float ingredient2Price;
        private final float expectedTotal;

        @Mock
        private Bun mockBun;

        @Mock
        private Ingredient mockIngredient1;

        @Mock
        private Ingredient mockIngredient2;

        public BurgerParameterizedTests(float bunPrice, float ingredient1Price, float ingredient2Price, float expectedTotal) {
            this.bunPrice = bunPrice;
            this.ingredient1Price = ingredient1Price;
            this.ingredient2Price = ingredient2Price;
            this.expectedTotal = expectedTotal;
        }

        @Parameterized.Parameters(name = "Цена булки: {0}, ингредиенты: {1}, {2} -> итог: {3}")
        public static Object[][] getTestData() {
            return new Object[][]{
                    {100f, 0f, 0f, 200f},
                    {100f, 50f, 0f, 250f},
                    {200f, 50f, 150f, 600f},
                    {0f, 50f, 50f, 100f}
            };
        }

        @Before
        public void setUp() {
            initMocks(this);
            burger = new Burger();
            burger.addIngredient(mockIngredient1);
            burger.addIngredient(mockIngredient2);
        }

        @Test
        public void getPriceShouldReturnCorrectTotal() {
            when(mockBun.getPrice()).thenReturn(bunPrice);
            when(mockIngredient1.getPrice()).thenReturn(ingredient1Price);
            when(mockIngredient2.getPrice()).thenReturn(ingredient2Price);

            burger = new Burger();
            burger.setBuns(mockBun);
            if(ingredient1Price > 0f) burger.addIngredient(mockIngredient1);
            if(ingredient2Price > 0f) burger.addIngredient(mockIngredient2);

            float actualTotal = burger.getPrice();

            assertEquals("Цена бургера рассчитана неверно", expectedTotal, actualTotal, 0.01f);
        }
    }
}
