import java.util.Scanner;

/**
 * The class to create and test the Easter class
 * @version 1.0, 5 October 2021
 * @author Ben DeSollar
 */


public class ComputusMain {

    /**
     * Main part of the program that will run each method in the Easter class
     * @param args - an array of strings that can be passed in when starting the main program
     */
    public static void main(String[] args)
    {
        // Instantiates an object of the easter class
        System.out.println("Enter a year to find the date easter occurs in that year: ");
        Scanner sc = new Scanner(System.in);
        double year = sc.nextDouble();
        Easter e = new Easter(year);
        System.out.println(e.calculateDateOfEaster(e.getYear()));
        sc.nextLine();
        System.out.println("Enter a month and day to find how many times easter occurs on that date in 5,700,000 years (Enter a day in either March or April: ");
        System.out.println("Enter Month: ");
        String monthInputted = sc.nextLine();
        System.out.println("Enter Day: ");
        int dayInputted = sc.nextInt();
        sc.nextLine();
        int numOfOccurrencesGathered = e.numOfEasterInGivenYears(monthInputted, dayInputted);
        System.out.println("Easter occurs on " + monthInputted + " " + dayInputted + ": " + numOfOccurrencesGathered + " times");
    }
}
