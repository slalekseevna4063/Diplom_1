package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void selectSauceTest() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void selectFillingTest() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
