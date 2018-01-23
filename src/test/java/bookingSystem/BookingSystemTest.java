package bookingSystem;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/*  todo in Test Driven Development
* - return list of booked hours
* - not allow a particular hour to be double-booked
* - deal in a sensible manner with illegal values (provided as input parameters)
*
* - one resource to booked (court)
* - all reservations only for today
* - only whole and regular hours */

@RunWith(JUnitParamsRunner.class)
public class BookingSystemTest {
    private BookingSystem system = new BookingSystem();

    /*Before tests put in list some information in order to check if information cannot doubles*/
    @Before
    public void setUp(){
        system.reserve("Karol", 10, 15);
    }

    public final Object[] illegal(){
        return new Object[]{
                new Object[]{"Hania", 15, 20},
                new Object[]{"Olek", 25, 39},
                new Object[]{"Andrzej", -1, -2},
                new Object[]{"Leszek", 6, 10}
        };
    }

    public final Object[] legal(){
        return new Object[]{
                new Object[]{"Hania", 1, 3},
                new Object[]{"Olek", 4, 6},
                new Object[]{"Andrzej", 7, 9},
                new Object[]{"Leszek", 16, 20}
        };
    }

    @Test
    public void shouldReturnListOfBookedHours(){
        assertNotNull(system.showBookedList());
    }

    @Test
    public void checkIfSizeIsOne(){
        assertTrue(system.showBookedList().size() == 1);
    }

    @Test
    @Parameters(method = "legal")
    public void shouldAddCorrectly(String name, int begin, int end){
        system.reserve(name, begin, end);
    }

    /*exception - hours is double*/
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegal")
    public void shouldThrowException(String name, int begin, int end){
        system.reserve(name, begin, end);
    }

}