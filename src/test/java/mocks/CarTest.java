package mocks;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarTest {
    private Car ferrari = Mockito.mock(Car.class); //test double

    private static final double DELTA = 1e-15;

    @Test
    public void instanceCheck(){
        assertTrue(ferrari instanceof Car);
    }

    @Test
    public void testDefaultBehaviourOfTestDouble() {
        assertFalse("new test double should return false as boolean",
                ferrari.needsFuel());
        assertEquals("new test double should return 0.0 as double",
                0.0, ferrari.getEngineTemperature(), DELTA);
    }

    @Test
    public void testStubbing() {
        assertFalse("new test double should return false as boolean",
                ferrari.needsFuel());
        when(ferrari.needsFuel()).thenReturn(true);
        assertTrue("after instructed test double should return what we want",
                ferrari.needsFuel());
    }

    @Test(expected = RuntimeException.class)
    public void throwException() {
        when(ferrari.needsFuel()).thenThrow(new RuntimeException());
        ferrari.needsFuel();
    }

    @Test
    public void testVerification() {
        ferrari.driveTo("Sweet home Alabama");
        ferrari.needsFuel();

        verify(ferrari).driveTo("Sweet home Alabama");
        verify(ferrari).needsFuel();
    }

    @Test
    public void testVerificationFailure() {
        ferrari.getEngineTemperature();  //wywołyjemy
        verify(ferrari).getEngineTemperature();  //sprawdzamy czy wywołano
    }

    /*@Test
    public void testVerificationFailureArguments() {
        ferrari.driveTo("Sweet home Alabama");
        verify(ferrari).driveTo("Sweet home Honolulu");
    }*/

    @Test
    public void testVerificationFailureArguments() {
        ferrari.driveTo("Sweet home Alabama");
        verify(ferrari).driveTo("Sweet home Alabama");
    }
}