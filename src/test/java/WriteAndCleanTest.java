import org.testng.annotations.Test;

/**
 * Created by Vitalia on 21.04.2015.
 */
public class WriteAndCleanTest extends BaseTest{
    final String FIRSTNAME = "И.А.";
    final String LASTNAME = "Бродский";
    final int  NUMBER = 0;
    @Test
    public void writeAndCleanTest()  { //check please locators of the firstname/lastname deletion buttons. It uses wrong js script (eraseFirstNameField('2_author_id1') instead of eraseLastNameField('2_author_id1'))
        step.writeAndClean(FIRSTNAME,LASTNAME,NUMBER);
    }

}