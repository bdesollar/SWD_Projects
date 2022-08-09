import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test morse code converter
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class MorseCodeTester {

    /**
     * Tests the Conversion from a word to Morse Code
     */
    @Test
    public void TestWordToMorse1()
    {
        MorseCodeConverter testConversion = new MorseCodeConverter();
        assertEquals(testConversion.EnglishToMorseCode("Ben"), "-... . -.");
    }

    /**
     * Tests the Conversion from a word to Morse Code
     */
    @Test
    public void TestWordToMorse2()
    {
        MorseCodeConverter testConversion = new MorseCodeConverter();
        assertEquals(testConversion.EnglishToMorseCode("Stuff"), "... - ..- ..-. ..-.");
    }

    /**
     * Tests the Conversion from a word to Morse Code
     */
    @Test
    public void TestWordToMorse3()
    {
        MorseCodeConverter testConversion = new MorseCodeConverter();
        assertEquals(testConversion.EnglishToMorseCode("I love pie"), "..   .-.. --- ...- .   .--. .. .");
    }

    /**
     * Tests the Conversion from a word to Morse Code
     */
    @Test
    public void TestWordToMorse4()
    {
        MorseCodeConverter testConversion = new MorseCodeConverter();
        assertEquals(testConversion.EnglishToMorseCode("Hi"), ".... ..");
    }

    /**
     * Tests the Conversion from a word to Morse Code
     */
    @Test
    public void TestWordToMorse5()
    {
        MorseCodeConverter testConversion = new MorseCodeConverter();
        assertEquals(testConversion.EnglishToMorseCode("Coding"), "-.-. --- -.. .. -. --.");
    }

    /**
     * Tests the Conversion from Morse Code to a word
     */
    @Test
    public void TestMorseToWord1()
    {
        MorseCodeConverter testConversion = new MorseCodeConverter();
        assertEquals(testConversion.MorseCodeToEnglish(".--- .- ...- .-"), "java");
    }

    /**
     * Tests the Conversion from Morse Code to a word
     */
    @Test
    public void TestMorseToWord2()
    {
        MorseCodeConverter testConversion = new MorseCodeConverter();
        assertEquals(testConversion.MorseCodeToEnglish("-.. . ... --- .-.. .-.. .- .-."), "desollar");
    }

    /**
     * Tests the Conversion from Morse Code to a word
     */
    @Test
    public void TestMorseToWord3()
    {
        MorseCodeConverter testConversion = new MorseCodeConverter();
        assertEquals(testConversion.MorseCodeToEnglish(". -. --. .. -. . . .-. .. -. --."), "engineering");
    }

    /**
     * Tests the Conversion from Morse Code to a word
     */
    @Test
    public void TestMorseToWord4()
    {
        MorseCodeConverter testConversion = new MorseCodeConverter();
        assertEquals(testConversion.MorseCodeToEnglish("--. .- -- .. -. --."), "gaming");
    }

    /**
     * Tests the Conversion from Morse Code to a word
     */
    @Test
    public void TestMorseToWord5()
    {
        MorseCodeConverter testConversion = new MorseCodeConverter();
        assertEquals(testConversion.MorseCodeToEnglish("... --- ..-. - .-- .- .-. .   -.. . ... .. --. -."), "software design");
    }

}
