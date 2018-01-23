package hashmap;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class HashMapTest {
    Map<Integer, String> map;

    @Before
    public void setMap(){
        map = new HashMap<>();
        map.put(0, "Karol");
        map.put(1, "Aleksandra");
        map.put(2, "Rafał");
        map.put(3, "Konrad");
    }

    @Test
    public void checkIfPossibleToPutContentFromMap(){
        map.get(0);
        assertFalse(map.get(3).isEmpty());
        assertEquals("Karol", map.get(0));
        assertTrue(map.size() == 4);
    }

    //teraz sprawdzimy czy jak wstawimy wartość z takim samym kluczem to czy się wartość zmieni
    public static final Object[]sameKey(){
        return new Object[]{
                new Object[]{"Cezary"},
                new Object[]{"Kowalski"},
                new Object[]{"Warszawa"},
                new Object[]{"Praga"}
        };
    }

    /*Sprawdzamy czy nowe wartości w HashMap zastępują stare*/
    @Test
    @Parameters(method = "sameKey")
    public void checkIfValueWillRepleced(String string){
        // do klucza, który już istnieje wstawiam coś innego
        HashMap<Integer, String> temporary = new HashMap<>(map); // nowa mapa ze skopiowaną poprzednią
        //sprawadza czy są te mapy takie same
        assertEquals(map, temporary);
        //teraz mapa jest modyfikowana i sprawdzamy asercją czy wartości o tych samych kluczach się różnią
        for(int i = 0; i < sameKey().length; i++){
            map.put(i, string);
            assertFalse(map.get(i).equals(temporary.get(i)));
        }
        assertEquals("Karol", temporary.get(0));
    }

    /*Sprawdzamy czy metoda clear działa */
    @Test
    public void mapShouldBeClear(){
        map.clear();
        assertTrue(map.size() == 0);
    }

    /*Czy null może być użyte jako klucz?*/
    @Test
    public void nullShouldCanBeKey(){
        map.put(null, "zero");

        assertFalse(map.get(null).isEmpty()); //czy wartość w kluczu null jest pusta??
        assertEquals("zero", map.get(null)); //można podać key jako null
    }
}