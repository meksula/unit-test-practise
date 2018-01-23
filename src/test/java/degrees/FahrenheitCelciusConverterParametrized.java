package degrees;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

/*Testy nie przechodzą, bo brak poprawnej implementacji*/

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterParametrized {

    public final Object[] degrees(){
        return new Object[]{
                new Object[]{32, 0},
                new Object[]{98, 37},
                new Object[]{212, 100}
        };
    }

    @Test
    @Parameters(method = "celcius")
    public void shouldConvertCelciusToFahrenheit(int x, int y) {
        assertEquals(x, FahrenheitCelciusConverter.toFahrenheit(y));
    }

    @Test
    @Parameters(method = "fahrenheit")
    public void shouldConvertFahrenheitToCelcius(int x, int y) {
        assertEquals(y, FahrenheitCelciusConverter.toCelcius(x));
    }
}
