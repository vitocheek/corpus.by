import org.testng.annotations.Test;

/**
 * Created by Vitalia on 26.04.2015.
 */
public class CheckSelectLanguageTest extends BaseTest {

    final int  SUM = 3;

    @Test
    public void checkSelectTest() {
        step.checkSelectLanguage(SUM);
    }
}