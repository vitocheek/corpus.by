import org.testng.annotations.Test;

/**
 * Created by Vitalia on 21.04.2015.
 */
public class WriteAndCleanTest extends BaseTest{
    final String FIRSTNAME = "И.А.";
    final String LASTNAME = "Бродский";
    final int  NUMBER = 0;
    @Test
    public void writeAndCleanTest()
    {
        step.writeAndClean(FIRSTNAME,LASTNAME,NUMBER);
    }

}