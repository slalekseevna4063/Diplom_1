package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParamTest {
    private Burger burger;
    private Ingredient sauce;
    private Ingredient filling;
    private final String name;
    private final float price;

    public BurgerParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void createNewObject() {
        sauce = new Ingredient(IngredientType.SAUCE, "Тар-тар", 92.0f);
        filling = new Ingredient(IngredientType.FILLING, "Креветки", 167.5f);
        burger = new Burger();
    }

    @Parameterized.Parameters(name = "{index} : price = {1}")
    public static Object[][] getBunData() {
        return new Object[][] {
                {"Креветочный бургер с тар-таром", 689.7f},
                {"Космическая фантазия", 234.0f},
        };
    }
    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expected = bun.price * 2 + sauce.price + filling.price;
        float actual = burger.getPrice();

        assertEquals("Используется некорректное значение стоимости бургера", expected, actual, 0);
    }
}
