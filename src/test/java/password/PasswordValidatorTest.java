package password;

import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;

/*8 characters long minimum
 * one big upercase letter
 * contain . / \ , etc.*/

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {
    private PasswordValidator validator;
    private final String VALID_PASSWORD = "Karol2018_m";
    //pasword has one uper case letter, some numbers and special sign
    private final String [] sign = new String[6];

    @Before
    public void setValidator(){
        validator = new PasswordValidator(VALID_PASSWORD);
        sign[0] = ".";
        sign[1] = ",";
        sign[2] = "-";
        sign[3] = "_";
        sign[4] = "?";
        sign[5] = "!";
    }

    @Test
    public void passwordShouldHaveMoreThan8Characters(){
        assertTrue(validator.getPassword().length() > 8);
    }

    @Test
    public void passwordShouldNotToBeBiggerThan15(){
        assertTrue(validator.getPassword().length() < 15);
    }

    @Test
    public void passwordShouldHaveBigLetter(){
        assertTrue(validator.hasBigLetter());
    }

    @Test
    public void passwordShouldContainSpecialSign(){
        assertTrue(validator.checkIfContainSpecialSign());
    }
}