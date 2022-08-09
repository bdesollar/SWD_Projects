import java.security.SecureRandom;

/**
 * solves polynomial roots given to it
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class Slave implements Runnable {

    /**
     * the first root of the polynomial
     */
    private double firstRoot;
    /**
     * the second root of the polynomial
     */
    private double secondRoot;
    /**
     * creates a random number, used for sleeping the thread
     */
    private static final SecureRandom generator = new SecureRandom();
    /**
     * reference to shared object
     */
    private final BufferDouble sharedLocationMaster;
    /**
     * reference to shared object
     */
    private final BufferString sharedLocationSlave;
    /**
     * number of slaves created
     */
    private static int slaveCount = 0;
    /**
     * the thread number to tell which thread is doing what
     */
    private int currentSlaveNumber;
    /**
     * the amount of roots solved
     */
    private int numberSolved = 0;
    /**
     * the time taken to solve the roots
     */
    private double time = 0;

    /**
     * constructor initializes the variables for the class and updated the amount of Slave objects created
     * @param sharedLocationMaster reference to shared object
     * @param sharedLocationSlave reference to shared object
     */
    Slave(BufferDouble sharedLocationMaster, BufferString sharedLocationSlave)
    {
        this.sharedLocationMaster = sharedLocationMaster;
        this.sharedLocationSlave = sharedLocationSlave;
        this.firstRoot = 0;
        this.secondRoot = 0;
        slaveCount++;
        setCurrentSlaveNumber(slaveCount);
    }

    /**
     * gets the time taken to solve the roots
     * @return the time taken to solve the roots
     */
    public double getTime() {
        return time;
    }

    /**
     * sets the time taken to solve the roots
     * @param time the time taken to solve the roots
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * gets the number of roots solved by the slave
     * @return the number of roots solved by the slave
     */
    public int getNumberSolved() {
        return this.numberSolved;
    }

    /**
     * sets the number of roots solved by the slave
     * @param numberSolved the number of roots solved by the slave
     */
    public void setNumberSolved(int numberSolved) {
        this.numberSolved = numberSolved;
    }

    /**
     * gets the current slaves number, i.e. which thread number they are
     * @return the current slaves number, i.e. which thread number they are
     */
    public int getCurrentSlaveNumber() {
        return currentSlaveNumber;
    }

    /**
     * sets the current slaves number, i.e. which thread number they are
     * @param currentSlaveNumber sets the current slaves number, i.e. which thread number they are
     */
    public void setCurrentSlaveNumber(int currentSlaveNumber) {
        this.currentSlaveNumber = currentSlaveNumber;
    }

    /**
     * gets the numbers to calculate the roots of the polynomials and calls the function to do so
     */
    @Override
    public void run() {
        String[] returnValueList = new String[]{"", ""};
        //for(int i = 0; i < sharedLocationMaster.getNumberOfSetsToCalculate(); i++){
        while(sharedLocationMaster.getNumberCalculated() < sharedLocationMaster.getNumberOfSetsToCalculate()) {
            try {
                Thread.sleep(generator.nextInt(10));
                double[] array = sharedLocationMaster.blockingGet();
                long start = System.currentTimeMillis();
                returnValueList = calculateRoots(array[0], array[1], array[2]);
                long end = System.currentTimeMillis();
                setTime(getTime() + (end - start));
                setNumberSolved(getNumberSolved() + 1);
                // Does a double check in real time to make sure the other threads don't increment when one thread has reached the number of sets to calculate
                if(sharedLocationMaster.getNumberCalculated() < sharedLocationMaster.getNumberOfSetsToCalculate()) {
                    sharedLocationMaster.setNumberCalculated(sharedLocationMaster.getNumberCalculated() + 1);
                }
                sharedLocationSlave.blockingPut(returnValueList);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
            // System.out.println("Slave " + getCurrentSlaveNumber() + " finished calculating with values " + returnValueList[0] + " " + returnValueList[1]);
        }
        setTime((getTime() / 1000) % 60);
        sharedLocationMaster.getNumberOfCalculationsEachThreadDid().put(getCurrentSlaveNumber(), getNumberSolved());
        sharedLocationMaster.getTimeTakenToCalculateByEachThread().put(getCurrentSlaveNumber(), getTime());
        System.out.println("Slave " + getCurrentSlaveNumber() + " done calculating\n Calculated " + getNumberSolved() + " in " + getTime() +" seconds" );
    }

    /**
     * calculates the roots of the polynomials
     * @param a leading coefficient in the polynomial
     * @param b second coefficient in the polynomial
     * @param c third coefficient in the polynomial
     * @return a string array containing the roots of the polynomial
     */
    public String[] calculateRoots(double a, double b, double c)
    {
        // calculates the determinant
        double determinate = (b*b)-(4*a*c);

        // if the determinate is 0 then the square root of the determinant does not need to be calculated
        /**
         * a string of the second root of the polynomial, helpful for imaginary numbers
         */
        String secondRootString;
        /**
         * a string of the first root of the polynomial, helpful for imaginary numbers
         */
        String firstRootString;
        if(determinate == 0)
        {
            firstRoot = secondRoot = -b/(2*a);
            firstRootString = String.format("First Root = %.2f", firstRoot);
            secondRootString = String.format(", Second Root = %.2f", secondRoot);
        }
        // if the determinate is greater than zero than it is not an imaginary number
        else if(determinate > 0)
        {
            firstRoot = (-b+Math.sqrt(determinate))/(2*a);
            secondRoot = (-b-Math.sqrt(determinate))/(2*a);
            firstRootString = String.format("First Root = %.2f", firstRoot);
            secondRootString = String.format(", Second Root = %.2f", secondRoot);
        }
        // if the determinate is less than zero than it is an imaginary number
        else
        {
            double real = -b/(2*a);
            double imaginary = Math.sqrt(-determinate)/(2*a);
            firstRootString = String.format("First Root = %.2f + %.2fi", real, imaginary);
            secondRootString = String.format(", Second Root = %.2f - %.2fi", real, imaginary);
        }
        return new String[]{firstRootString, secondRootString};
    }
}
