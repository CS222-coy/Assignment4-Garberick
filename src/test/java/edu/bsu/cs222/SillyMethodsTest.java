package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SillyMethodsTest {

    @Test
    public void testDidGuess42Correctly(){
        SillyMethods sillyMethods = new SillyMethods();
        boolean result = sillyMethods.didGuess42(42);
        Assertions.assertTrue(result);
    }

    @Test
    public void testDidGuess42Incorrectly(){
        SillyMethods sillyMethods = new SillyMethods();
        boolean result = sillyMethods.didGuess42(17);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCountTo10(){
        SillyMethods sillyMethods = new SillyMethods();
        String result = sillyMethods.countTo(10);
        Assertions.assertEquals(result, "0 1 2 3 4 5 6 7 8 9 10");
    }

    @Test
    public void testCountTo15(){
        SillyMethods sillyMethods = new SillyMethods();
        String result = sillyMethods.countTo(15);
        Assertions.assertEquals(result, "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
    }
}
