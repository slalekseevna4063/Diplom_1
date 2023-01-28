package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void getTypeReturnIngredientType() {
        Ingredient ingredient = new Ingredient(SAUCE, "name", 1);
        IngredientType expectedType = SAUCE;
        IngredientType actualType = ingredient.getType();
        assertEquals("Некорректный тип", expectedType, actualType);
    }


    @Test
    public void getNameReturnIngredientName() {
        Ingredient ingredient = new Ingredient(SAUCE, "name", 1);
        String expectedName = "name";
        String actualName = ingredient.getName();
        assertEquals("Некоректное имя", expectedName, actualName);
    }

    @Test
    public void getPriceReturnIngredientPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "name", 1);
        float expectedPrice = 1;
        float actualPrice = ingredient.getPrice();
        assertEquals("Некорректная цена", expectedPrice, actualPrice, 0);
    }


}
