import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Gregorian Easters for 20 different years
 * @version 1.0, 5 October 2021
 * @author Ben DeSollar
 */
public class ComputusTest {


    // List of Gregorian Easter Sundays found on https://webspace.science.uu.nl/~gent0113/easter/easter_text3a.htm

    /**
     * Tests the date April 22, 1590 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest1() {
        // 1st Test
        // Easter should be on April 22, 1590
        Easter e = new Easter(1590);
        assertEquals("April 22, 1590", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date March 22, 1598 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest2() {
        // 2nd Test
        // Easter should be on March 22, 1598
        Easter e = new Easter(1598);
        assertEquals("March 22, 1598", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 19, 1609 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest3() {
        // 3rd Test
        // Easter should be on April 19, 1609
        Easter e = new Easter(1609);
        assertEquals("April 19, 1609", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date March 27, 1622 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest4() {
        // 4th Test
        // Easter should be on March 27, 1622
        Easter e = new Easter(1622);
        assertEquals("March 27, 1622", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 15, 1629 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest5() {
        // 5th Test
        // Easter should be on April 15, 1629
        Easter e = new Easter(1629);
        assertEquals("April 15, 1629", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 25, 1666" to see if the program output is the same
     */
    @Test
    public void EasterDaysTest6() {
        // 6th Test
        // Easter should be on April 25, 1666
        Easter e = new Easter(1666);
        assertEquals("April 25, 1666", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 22, 1685 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest7() {
        // 7th Test
        // Easter should be on April 22, 1685
        Easter e = new Easter(1685);
        assertEquals("April 22, 1685", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 11, 1700 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest8() {
        // 8th Test
        // Easter should be on April 11, 1700
        Easter e = new Easter(1700);
        assertEquals("April 11, 1700", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 8, 1798 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest9() {
        // 9th Test
        // Easter should be on April 8, 1798
        Easter e = new Easter(1798);
        assertEquals("April 8, 1798", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date March 22, 1818 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest10() {
        // 10th Test
        // Easter should be on March 22, 1818
        Easter e = new Easter(1818);
        assertEquals("March 22, 1818", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 16, 1876 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest11() {
        // 11th Test
        // Easter should be on April 16, 1876
        Easter e = new Easter(1876);
        assertEquals("April 16, 1876", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 25, 1943 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest12() {
        // 12th Test
        // Easter should be on April 25, 1943
        Easter e = new Easter(1943);
        assertEquals("April 25, 1943", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 18, 1954 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest13() {
        // 13th Test
        // Easter should be on April 18, 1954
        Easter e = new Easter(1954);
        assertEquals("April 18, 1954", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date March 26, 1967 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest14() {
        // 14th Test
        // Easter should be on March 26, 1967
        Easter e = new Easter(1967);
        assertEquals("March 26, 1967", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 14, 1974 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest15() {
        // 15th Test
        // Easter should be on April 14, 1974
        Easter e = new Easter(1974);
        assertEquals("April 14, 1974", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 19, 1981 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest16() {
        // 16th Test
        // Easter should be on April 19, 1981
        Easter e = new Easter(1981);
        assertEquals("April 19, 1981", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 21, 2019 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest17() {
        // 17th Test
        // Easter should be on April 21, 2019
        Easter e = new Easter(2019);
        assertEquals("April 21, 2019", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 25, 2038 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest18() {
        // 18th Test
        // Easter should be on April 25, 2038
        Easter e = new Easter(2038);
        assertEquals("April 25, 2038", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 9, 2045 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest19() {
        // 19th Test
        // Easter should be on April 9, 2045
        Easter e = new Easter(2045);
        assertEquals("April 9, 2045", e.calculateDateOfEaster(e.getYear()));
    }

    /**
     * Tests the date April 18, 2049 to see if the program output is the same
     */
    @Test
    public void EasterDaysTest20() {
        // 20th Test
        // Easter should be on April 18, 2049
        Easter e = new Easter(2049);
        assertEquals("April 18, 2049", e.calculateDateOfEaster(e.getYear()));
    }

}
