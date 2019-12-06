import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask2 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 1, 4, 4, 1, 1, 1}, true},
                {new int[]{5, 2, 9, 3, 3, 2, 1, 5}, false},
                {new int[]{2, 1, 4, 2}, false}
        });
    }
    private int[] in;
    private boolean out;

    public TestTask2(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private Main task2;

    @Before
    public void startTest() {
        task2 = new Main();
    }

    //Positive test
    @Test
    public void testOnly1And4() {
        Assert.assertEquals(Main.searchPairNumbers(in), out);
    }
}

