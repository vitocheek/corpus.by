import org.testng.annotations.Test;

/**
 * Created by Vitalia on 22.04.2015.
 */
public class CheckWebSourceTest extends BaseTest{
    final String FIRSTNAME = "И.В.";
    final String LASTNAME = "Дмитриев";
    final String  TITLEWEBRESOURCE = "Прикладная теория информации";
    final String  PBLICATIONTITLE = "Теоретические основы информационной техники";
    final String  WEBRESOURCEURL = "WEBRESOURCEURL";
    final int  NUMBER = 0;

    @Test
    public void checkWebSourceTest() {
        step.selectWebResourceEnteredAndCheckResult(FIRSTNAME,LASTNAME,PBLICATIONTITLE,TITLEWEBRESOURCE,WEBRESOURCEURL,NUMBER); }

}