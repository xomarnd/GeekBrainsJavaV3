import org.junit.Before;
import org.junit.Test;

public class TestTask1Ex {

    @Before
    public void startTest() {
        Main task1 = new Main();
    }

    //Позитивный тест. Проверка вывода ошибки.
    @Test(expected = RuntimeException.class)
    public void afterLastNumbers() {
        Main.afterLastNumbers(new int[]{3, 3, 7, 5, 0, 0, 3, 2});
    }
}
