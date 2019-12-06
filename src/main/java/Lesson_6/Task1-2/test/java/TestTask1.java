import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;



@RunWith(Parameterized.class)
public class TestTask1 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 6, 5, 4, 2, 3, 3}, new int[]{2, 3, 3}},
                {new int[]{4, 3, 7, 5, 4, 4, 3, 2}, new int[]{3, 2}}
        });
    }

    private int[] in;
    private int[] out;

    public TestTask1(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    private Main task1;

    @Before
    public void startTest() {
        task1 = new Main();
    }

    //Позитивный тест. Проверка вывода части массива после четверки.
    @Test
    public void testAfterLast4() {
        Assert.assertArrayEquals(out, Main.afterLastNumbers(in));
    }

    //Позитивный тест. Проверка вывода ошибки.
    @Test(expected = RuntimeException.class)
    public void testAfterLast4Ex() {
        Main.afterLastNumbers(new int[]{0, 2, 1, 2, 3, 5, 8, 2});
    }
}
