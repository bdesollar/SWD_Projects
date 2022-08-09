import java.util.Scanner;

/**
 * The class to start the change computation class
 * @version 1.0, 21 Sept 2021
 * @author Ben DeSollar
 */
public class ChangeComputationMain {
    /**
     * Creates and starts the computation class
     * @param args  an array of strings that can be passed in when starting the main program
     */
    public static void main(String[] args){
        ChangeComputation cc = new ChangeComputation();
        System.out.println("Enter amount in USD to convert to Euros: ");
        // create Scanner to obtain input from command window
        Scanner sc = new Scanner(System.in);
        double usd = sc.nextDouble();
        // Calls the convertUsdToEu function
        int[] num_of_each_currency_unit = cc.ConvertUsdToEu(usd);
        // Displays the amount of each currency that was used to give change back to the user in euros from usd
        System.out.println("Change back is " + num_of_each_currency_unit[0] + " : 20(s), " + num_of_each_currency_unit[1] + " : 10(s), " + num_of_each_currency_unit[2] + " : 5(s), " +
                num_of_each_currency_unit[3] + " : 1(s), " + num_of_each_currency_unit[4] + " : 50 cent Euro Coin(s), " + num_of_each_currency_unit[5] + " : 20 cent Euro Coin(s), " +
                num_of_each_currency_unit[6] + " : 10 cent Euro coin(s), " + num_of_each_currency_unit[7] + " : 5 cent Euro coin(s), " + num_of_each_currency_unit[8] + " : 1 cent Euro coin(s)");
    }
}
