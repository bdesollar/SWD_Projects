/**
 * Conversions between morse code and english
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class MorseCodeConverter {

    /**
     * list of morse codes that correspond to each letter in the alphabet
     */
    private static final String[] listOfMorseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "  "};
    /**
     * List of the alphabet to be used for the morse code conversion
     */
    private static final String[] listOfLetters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " "};

    /**
     * Converts morse code to english
     * @param morseCode morse code to be converted to english
     * @return a string that is the english equivalent to the morse code
     */
    public String MorseCodeToEnglish(String morseCode)
    {
        String wordInEnglish = "";
        int countSpaces = 0;
        String[] morseCodeSplit = morseCode.split(" ");
        for(int i = 0; i < morseCodeSplit.length; i++)
        {
            if(morseCodeSplit[i].equals(""))
            {
                // check if the character in the string is also empty, which means that there is two spaces
                // thus, this is a space in the english word
                if(morseCodeSplit[i+1].equals(""))
                {
                    i+=2;
                    wordInEnglish += " ";
                }
                else {
                    i += 1;
                }
            }
            for(int k = 0; k < listOfMorseCodes.length; k++)
            {
                // Checks to see if the index in the list of morse codes is equivalent to the current character in the morse code inputted
                if(listOfMorseCodes[k].equals(morseCodeSplit[i]))
                {
                    wordInEnglish += listOfLetters[k];
                }
            }
        }
        return wordInEnglish;
    }

    /**
     * Converts english words/sentences to morse code
     * @param english a string that contains words to be converted to morse code
     * @return a string of the morse equivalent to the english word/sentence inputted
     */
    public String EnglishToMorseCode(String english)
    {
        english = english.toLowerCase();
        String[] wordInEnglishSplit = english.split("");
        String morseCode = null;
        for(int i = 0; i < wordInEnglishSplit.length; i++)
        {
            for(int k = 0; k < listOfLetters.length; k++)
                if(String.valueOf(listOfLetters[k]).equals(wordInEnglishSplit[i].toLowerCase()))
                {
                    if(morseCode == null) {
                        morseCode = listOfMorseCodes[k];
                    }
                    else
                    {
                        // if there is a space then already in the list of character then don't add a space because three spaces will be added already from the list
                        // to separate words from characters
                        if(listOfLetters[k].equals(" "))
                        {
                            morseCode += listOfMorseCodes[k];
                        }
                        // add a space because there should be a single space between each morse character
                        else {
                            morseCode += " " + listOfMorseCodes[k];
                        }
                    }
                }
        }
        return morseCode;
    }
}
