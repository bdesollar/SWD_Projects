// Example 2.6: Product.java
// Calculate the product of three integers.

import java.util.Scanner;


/**
 * The class to change the amount of usd given to euros
 * @version 1.0, 21 Sept 2021
 * @author Ben DeSollar
 */
public class ChangeComputation {


    /**
     * Converts usd to change in euros in different amounts
     * @param usd   the amount of US dollars that the method will convert to Euro change
     * @return     an array of the amount of each type of change
     */
    public static int[] ConvertUsdToEu(double usd){
        // Convert usd to euro
        double euro = usd*0.84;
        // Formats the double to 2 decimal units by casting a String onto the formatted string (Found Conversion online)
        String sValue = (String) String.format("%.2f", euro);
        euro = Double.parseDouble(sValue);
        System.out.println("Amount in Euros is: "  + sValue);
        double[] amt_of_each_currency = new double[]{20, 10, 5, 1, 0.5, 0.20, 0.10, 0.05 ,0.01};
        int[] num_of_each_currency = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        double remainder = -1;
        double remaining_money = euro;
        int i = 0;
        String s;
        // Goes through loop for all currency values unless a remainder of 0 occurs
        while(i < 9){
            // Uses the mod operator to get the remainder by dividing it by the current currency amount
            remainder = remaining_money%amt_of_each_currency[i];
            // Reformats double into 2 decimal places again
            s = (String) String.format("%.2f", remainder);
            remainder = Double.parseDouble(s);
            // if the remainder is 0 then the total amount of currency has been given out
            if (remainder == 0)
            {
                // Gets the number of the current currency by casting an int onto the division of the money remaining and the amount
                // the current currency represents
                num_of_each_currency[i] = (int)(remaining_money/amt_of_each_currency[i]);
                return num_of_each_currency;
            }
            else{
                // Gets the number of the current currency by casting an int onto the division of the money remaining and the amount
                // the current currency represents
                num_of_each_currency[i] = (int)(Math.floor(remaining_money/amt_of_each_currency[i]));
                // money left will be equal to the remainder
                remaining_money = remainder;
            }
            i += 1;
        }
        return num_of_each_currency;
    }

}