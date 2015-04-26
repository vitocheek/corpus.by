import org.testng.annotations.Test;

/**
 * Created by Vitalia on 21.04.2015.
 */
public class CheckEnteredAndCheckResultTest extends BaseTest{
    final String FIRSTNAME = "И.В.";
    final String LASTNAME = "Дмитриев";
    final String  TITLEBOOK = "Прикладная теория информации";
    final String  PUBLICATIONTITLE = "Теоретические основы информационной техники";
    final String  PAGETO = "100";
    final String  PAGEFROM = "20";
    final String  NUMBER_EDITION = "4";
    final int  NUMBER = 0;
    @Test
    public void checkClearAndCheckResult() {
        step.checkEnteredAndResult(FIRSTNAME,LASTNAME,TITLEBOOK ,PUBLICATIONTITLE, PAGETO, PAGEFROM, NUMBER_EDITION,NUMBER);
    }
}