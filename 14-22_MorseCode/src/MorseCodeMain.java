import java.util.Scanner;


/**
 * The main class to utilize the morse code converter
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class MorseCodeMain {

    /**
     * Creates and starts the morse code Conversion class
     * @param args  an array of strings that can be passed in when starting the main program
     */
    public static void main(String[] args)
    {
        MorseCodeConverter m = new MorseCodeConverter();
        Scanner sc = new Scanner(System.in);
        String input = "";
        int userChoice = 0;
        while(userChoice != 3) {
            System.out.println("Enter 1 to convert English to Morse Code, 2 to convert Morse Code to convert English, and 3 to quit: ");
            userChoice = sc.nextInt();
            if(userChoice == 1) {
                sc.nextLine();
                System.out.println("Enter Word to be converted (Enter 1 to stop entering words): ");
                input = sc.nextLine();
                System.out.println(m.EnglishToMorseCode(input));
            }
            else if(userChoice == 2)
            {
                sc.nextLine();
                System.out.println("Enter Morse to be converted: ");
                input = sc.nextLine();
                System.out.println(m.MorseCodeToEnglish(input));
            }
        }
    }
}
