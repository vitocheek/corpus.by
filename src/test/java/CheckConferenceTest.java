import org.testng.annotations.Test;

/**
 * Created by Vitalia on 22.04.2015.
 */
public class CheckConferenceTest extends BaseTest{
    final String FIRSTNAME = "И.В.";
    final String LASTNAME = "Дмитриев";
    final String  TITLEBOOK = "Прикладная теория информации";
    final String  CONFERENCETITLE = "Теоретические основы информационной техники";
    final String  PAGETO = "100";
    final String  PAGEFROM = "20";
    final String  CITE = "Minsk";
    final String PLACEID  = "PLACEID";
    final String  PUBLICATIONHOUSE = "publishHouse";
    final int  NUMBER = 0;

    @Test
    public void checkConferenceTest(){
        step.selectConferenceEnteredAndCheckResult(FIRSTNAME,LASTNAME,TITLEBOOK,CONFERENCETITLE,PAGETO,PAGEFROM,CITE,PLACEID,PUBLICATIONHOUSE,NUMBER);
    }

}