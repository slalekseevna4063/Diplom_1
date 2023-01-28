package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    private Bun bun;

    @Before
    public void createNewInstance() {
        bun = new Bun("Ржаная булочка", 100.0f);
    }

    @Test
    public void getName() {
        String expected = "Ржаная булочка";
        String actual = bun.getName();
        assertEquals("Используется некорректное значение названия булочки", expected, actual);
    }

    @Test
    public void getPrice() {
        float expected = 100.0f;
        float actual = bun.getPrice();

        assertEquals("Используется некорректное значение стоимости булочки", expected, actual, 0);
    }
}