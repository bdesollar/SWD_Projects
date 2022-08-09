/**
 * used to calculate the dates of easter and the amount of times easter occurs on a specific date in 5,700,000 years
 * @version 1.0, 5 October 2021
 * @author Ben DeSollar
 */

public class Easter {

    /**
     * The year that the Easter day and month is being looked for
     */
    private double year;
    /**
     * The month of Easter in the year looked for
     */
    private int month;
    /**
     * The day of Easter in the year looked for
     */
    private int day;

    /**
     * Constructor for the Easter class
     * @param year   Year that the user wants to find the Month and Day of Easter in
     */
    Easter(double year)
    {
        this.year = year;
    }

    /**
     * Gets the year
     * @return the year set in the class
     */
    public double getYear() {
        return year;
    }

    /**
     * Set the year in which to look for the day and month of Easter
     * @param year  year to be set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * gets the day of easter in the year specified
     * @return the day of easter in the year specified
     */
    public int getDay() {
        return day;
    }

    /**
     * Calculated the Month and day of Easter in the year given
     * @param year1  Year in which to look for the day and month of Easter
     * @return the month, day, and year of the Easter in the year given
     */
    public String calculateDateOfEaster(double year1)
    {
        // Algorithm to calculate the Gregorian Easter
        double a = year1 % 19;
        double b = Math.floor(year1/100);
        double c = year1 % 100;
        double d = Math.floor(b/4);
        double e = b % 4;
        double g = Math.floor(((8*b) + 13)/25);
        double h = ((19*a) + b - d - g + 15) % 30;
        double i = Math.floor(c/4);
        double k = c % 4;
        double l = (32 + (2*e) + (2*i) - h - k) % 7;
        double m = Math.floor((a + (11*h) + (19*l))/433);
        double n = Math.floor((h + l - (7*m) + 90)/25);
        double p = (h + l - (7*m) + (33*n) + 19) % 32;
        int day = (int) p;
        int month = (int) n;
        int yearAsAnInt = (int) year1;
        String monthString = "";
        // Only checks 3 and 4 due to Easter only being in March or April
        if(month == 3)
        {
            monthString = "March";
        }
        else if(month == 4)
        {
            monthString = "April";
        }
        return String.format("%s %d, %d", monthString, day, yearAsAnInt);
    }

    /**
     * Calculates the number of Times Easter occurs on the month and day given for a 5,700,000-year cycle
     * @param month month to check
     * @param day day to check
     * @return number of times the month and day given were Easter in 5,700,000 years
     */
    public int numOfEasterInGivenYears(String month, int day)
    {
        month = month.toLowerCase();
        String dayAndMonthOfCurrentYear = String.format("%s %d", month, day);
        String outputMonthDayOfYearTested;
        String[] newOutput;
        int numberOfOccurrences = 0;
        // Tests the day and month given every year for 5700000 years and see when they occur
        for(double i = 0; i < 5700000; i++)
        {
            outputMonthDayOfYearTested = calculateDateOfEaster(i);
            // Used to get rid of teh comma and year. Do not care about the year in this case
            newOutput = outputMonthDayOfYearTested.split(",");
            newOutput[0] = newOutput[0].toLowerCase();
            if(newOutput[0].equals(dayAndMonthOfCurrentYear))
            {
                numberOfOccurrences += 1;
            }
        }
        return numberOfOccurrences;

    }

}
