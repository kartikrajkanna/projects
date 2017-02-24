package org.kits.simple.numbergame;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class NumberTest extends TestCase {

    Number number = new Number(new int[] {1, 2, 3, 4});

    public NumberTest (String testName) { super(testName); }

    public static Test suite()
    {
        return new TestSuite( NumberTest.class );
    }

    //Test equals method
    public void testEquals() {
        assertTrue(this.number.equals(new Number(new int[]{1, 2, 3, 4})));
    }

    public void testAllDifferentDigitsEqual() {
        assertFalse(this.number.equals(new Number(new int[]{5, 7, 6, 8})));
    }

    public void testSomeDifferentDigitsEqual() {
        assertFalse(this.number.equals(new Number(new int[] {1, 3, 5, 7})));
    }

    public void testDifferentOrderEqual() {
        assertFalse(this.number.equals(new Number(new int[] {4, 3, 2, 1})));
    }

    //Test getMatches method
    public void testNoMatchGetMatches() {
        assertEquals(this.number.getMatches(new Number(new int[] {5, 6, 7, 8})), 0);
    }

    public void testNoMatchFourPresentGetMatches() {
        assertEquals(this.number.getMatches(new Number(new int[] {4, 3, 2, 1})), 0);
    }

    public void testTwoMatchesGetMatches() {
        assertEquals(this.number.getMatches(new Number(new int[] {1, 2, 8, 0})), 2);
    }

    public void testAllMatchesGetMatches() {
        assertEquals(this.number.getMatches(new Number(new int[] {1, 2, 3, 4})), 4);
    }

    public void testAllMatchesMeansEquals() {
        Number newNumber = new Number(new int[] {1, 2, 3, 4});
        assertTrue(number.getMatches(newNumber) ==4 && number.equals(newNumber));
    }

}
