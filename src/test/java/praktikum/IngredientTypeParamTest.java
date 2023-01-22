package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParamTest {
    private final IngredientType type;
    private final String name;
    public IngredientTypeParamTest(IngredientType type, String name) {
        this.type = type;
        this.name = name;
    }
    @Parameterized.Parameters(name = "{index} : name = {0}")
    public static Object[][] getIngredientTypeData() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }
    @Test
    public void checkIngredientTypeName() {
        assertEquals("Некорректное название типа ингредиента", name, type.name());
    }
}
