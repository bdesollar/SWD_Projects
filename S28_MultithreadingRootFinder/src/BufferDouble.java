import java.util.ArrayList;
import java.util.HashMap;

// Fig. 23.9: Buffer.java
/**
 * Buffer interface specifies methods called by Master and Slave
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

// Buffer interface specifies methods called by Master and Slave
public interface BufferDouble {

   /**
    * // place double array into Buffer
    * @param array array containing the 3 values for the root finder
    * @throws InterruptedException exception occurs if the thread has been interrupted
    */
   // place double array into Buffer
   public void blockingPut(double[] array) throws InterruptedException;

   /**
    * gets a double array containing the 3 values for the root finder
    * @return a double array containing the 3 values for the root finder
    * @throws InterruptedException exception occurs if the thread has been interrupted
    */
   // return int value from Buffer
   public double[] blockingGet() throws InterruptedException;

   /**
    * gets the number of sets the user asks to calculate the roots for
    * @return the number of sets the user asks to calculate the roots for
    */
   public int getNumberOfSetsToCalculate();

   /**
    * sets the number of sets the user asks to calculate the roots for
    * @param num the number of sets the user asks to calculate the roots for
    */
   public void setNumberOfSetsToCalculate(int num);

   /**
    * checks whether the slaves are done calculating the roots or not
    * @return true or false depending on if the slaves are done calculating the roots
    */
   public boolean getFinishedState();

   /**
    * sets whether the slaves are done calculating the roots or not
    * @param finishedState true or false depending on if the slaves are done calculating the roots
    */
   public void setFinishedState(boolean finishedState);

   /**
    * gets a hashmap with the key as the thread number and the value as the number of roots that thread calculated
    * @return a hashmap with the key as the thread number and the value as the number of roots that thread calculated
    */
   public HashMap<Integer, Integer> getNumberOfCalculationsEachThreadDid();

   /**
    * gets a hashmap with the key as the thread number and the value as the time it too to calculate all the roots
    * @return a hashmap with the key as the thread number and the value as the time it too to calculate all the roots
    */
   public HashMap<Integer, Double> getTimeTakenToCalculateByEachThread();

   /**
    * gets the number of sets of roots calculated
    * @return the number of sets of roots calculated
    */
   public int getNumberCalculated();

   /**
    * sets the number of sets of roots calculated
    * @param numberCalculated the number of sets of roots calculated
    */
   public void setNumberCalculated(int numberCalculated);

}

/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/