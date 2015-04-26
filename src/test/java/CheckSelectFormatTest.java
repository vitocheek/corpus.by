import org.testng.annotations.Test;

/**
 * Created by Vitalia on 26.04.2015.
 */
public class CheckSelectFormatTest extends BaseTest{

    final int  SUM = 2;
    @Test
    public void checkSelectTest() {
        step.checkSelectFormat(SUM);
    }
}