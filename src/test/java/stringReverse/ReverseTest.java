package stringReverse;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class ReverseTest {

    private static final String INVALID_STRING = "";

    private static final Object[] strings(){
        return new Object[]{
                new Object[]{"Hey You!"},
                new Object[]{"To jest przykładowy String"},
                new Object[]{"Alicja w krainie czarów"},
                new Object[]{"desreveR"}
        };
    }

    @Test
    @Parameters(method = "strings")
    public static void stringShouldBeReversed(String string){
        char[]chars1 = string.toCharArray(); //wkładam Stringa do tablicy
        String then = Reverse.reverse(string); //odwracam Stringi i zapisuję je do zmiennej
        char[]chars = then.toCharArray(); //wkładam zmienionego stringa do tablicy

        assertEquals(chars[0], chars1[chars1.length-1]);
        assertTrue(string.length() == then.length()); //długość taka sama
    }

    /*another way*/
    @Test
    @Parameters(method = "strings")
    public void stringSholdBeReversedCorrectly(String string){
        String reversed = Reverse.reverse(string);
        assertNotEquals(string, reversed);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException(){
        Reverse.reverse(INVALID_STRING);
    }
}