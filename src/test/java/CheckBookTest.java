import org.testng.annotations.Test;

/**
 * Created by Vitalia on 22.04.2015.
 */
public class CheckBookTest extends BaseTest{
    final String FIRSTNAME = "И.В.";
    final String LASTNAME = "Дмитриев";
    final String  TITLEBOOK = "Прикладная теория информации";
    final String  NUMBERING = "400";
    final String  REDACTOR = "ТРИУМФ";
    final String  CITE = "Minsk";
    final String  PUBLICATIONHOUSE = "publishHouse";
    final int  NUMBER = 0;

    @Test
    public void checkClearTest() {
        step.selectBookEnteredAndCheckResult(FIRSTNAME, LASTNAME, TITLEBOOK,NUMBERING,CITE,PUBLICATIONHOUSE,REDACTOR,NUMBER );
    }

}
