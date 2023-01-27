package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient trivialIngredient;
    @Mock
    Ingredient nontrivialIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(trivialIngredient);

        Assert.assertEquals(trivialIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getBunsPrice() {
        burger.setBuns(bun);
        burger.addIngredient(trivialIngredient);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(trivialIngredient.getPrice()).thenReturn(300F);

        Assert.assertEquals(burger.getPrice(), 700, 0);
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(trivialIngredient);
        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(trivialIngredient);
        Mockito.when(bun.getName()).thenReturn("rye");
        Mockito.when(trivialIngredient.getName()).thenReturn("salsa");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(trivialIngredient.getPrice()).thenReturn(100F);
        Mockito.when(trivialIngredient.getType()).thenReturn(IngredientType.SAUCE);

        String expectedReceipt = "(==== rye ====)\r\n" + "= sauce salsa =\r\n" + "(==== rye ====)\r\n" +
                "\r\nPrice: 300,000000\r\n";
        Assert.assertEquals("что-то не так", expectedReceipt, burger.getReceipt());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(trivialIngredient);
        burger.addIngredient(nontrivialIngredient);
        burger.moveIngredient(0, 1);

        Assert.assertEquals(1, burger.ingredients.lastIndexOf(trivialIngredient));
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(trivialIngredient);
        burger.addIngredient(nontrivialIngredient);
        float expected = bun.price * 2 + trivialIngredient.price + nontrivialIngredient.price;
        float actual = burger.getPrice();

        assertEquals("Используется некорректное значение стоимости бургера", expected, actual, 0);
    }
}