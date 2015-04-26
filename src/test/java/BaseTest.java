import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * Created by Vitalia on 21.04.2015.
 */
public class BaseTest {
    Step step = new Step();

    @BeforeClass
    public void init()
    {
        step.initBrowser();
        step.goHome();
    }

    @AfterClass
    public void tearDown()
    {
         step.closeDriver();
    }
}
