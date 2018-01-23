package regex;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class RegexSampleTest {
    private RegexSample regexSample;

    @Before
    public void setRegexSample(){
        regexSample = new RegexSample("nj0hne7ecne82cjn391n");
    }

    /*check how much digits String contain*/
    @Test
    public void shouldContainMoreDifferentDigitsThan3(){
        assertTrue(regexSample.containDigits() > 3);
    }

    @Test
    public void shouldContainSameDigitsMoreThan3(){
        assertTrue(regexSample.howMuchDigits() > 3);
    }

    //todo write next tests
}