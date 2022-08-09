import java.util.HashMap;

// Used Fig. 23.18: CircularBuffer.java from the book for a starting point

/**
 * Synchronizing access to a shared three-element bounded buffer.
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

// Synchronizing access to a shared three-element bounded buffer.
public class CircularBufferDouble implements BufferDouble {
   /**
    * shared buffer
    */
   private final double[][] buffer = {{}, {}, {}};
   /**
    * count number of buffers used
    */
   private int occupiedCells = 0;
   /**
    * index of next element to write to
    */
   private int writeIndex = 0;
   /**
    * index of next element to read
    */
   private int readIndex = 0;
   /**
    * the number of sets of roots to calculate as determined by the user
    */
   private int numberOfSetsToCalculate;
   /**
    * the check used to see if all the threads are done calculating
    */
   private boolean finishedState = false;
   /**
    * the number of roots calculated
    */
   private int numberCalculated = 0;
   /**
    * a hashmap with the key as the thread number and the value as the number of roots that thread calculated
    */
   private HashMap<Integer, Integer> numberOfCalculationsEachThreadDid = new HashMap<Integer, Integer>();
   /**
    * a hashmap with the key as the thread number and the value as the time it too to calculate all the roots
    */
   private HashMap<Integer, Double> timeTakenToCalculateByEachThread = new HashMap<Integer, Double>();

   /**
    * gets the number of sets the user asks to calculate the roots for
    * @return the number of sets the user asks to calculate the roots for
    */
   public int getNumberCalculated() {
      return this.numberCalculated;
   }

   /**
    * sets the number of sets the user asks to calculate the roots for
    * @param numberCalculated the number of sets the user asks to calculate the roots for
    */
   public void setNumberCalculated(int numberCalculated) {
      this.numberCalculated = numberCalculated;
   }

   /**
    * gets the number of sets of roots calculated
    * @return the number of sets of roots calculated
    */
   public HashMap<Integer, Double> getTimeTakenToCalculateByEachThread() {
      return timeTakenToCalculateByEachThread;
   }

   /**
    * gets a hashmap with the key as the thread number and the value as the number of roots that thread calculated
    * @return a hashmap with the key as the thread number and the value as the number of roots that thread calculated
    */
   public HashMap<Integer, Integer> getNumberOfCalculationsEachThreadDid() {
      return numberOfCalculationsEachThreadDid;
   }

   /**
    * checks whether the slaves are done calculating the roots or not
    * @return true or false depending on if the slaves are done calculating the roots
    */
   public boolean getFinishedState() {
      return finishedState;
   }

   /**
    * sets whether the slaves are done calculating the roots or not
    * @param finishedState true or false depending on if the slaves are done calculating the roots
    */
   public void setFinishedState(boolean finishedState) {
      this.finishedState = finishedState;
   }

   /**
    * checks whether the slaves are done calculating the roots or not
    * @return true or false depending on if the slaves are done calculating the roots
    */
   public int getNumberOfSetsToCalculate() {
      return numberOfSetsToCalculate;
   }

   /**
    * sets the number of sets the user asks to calculate the roots for
    * @param numberOfSetsToCalculate the number of sets the user asks to calculate the roots for
    */
   public void setNumberOfSetsToCalculate(int numberOfSetsToCalculate) {
      this.numberOfSetsToCalculate = numberOfSetsToCalculate;
   }

   /**
    * // place double array into Buffer
    * @param array array containing the 3 values for the root finder
    * @throws InterruptedException exception occurs if the thread has been interrupted
    */
   // place value into buffer
   public synchronized void blockingPut(double[] array)
      throws InterruptedException {               
   
      // wait until buffer has space available, then write value; 
      // while no empty locations, place thread in blocked state  
      while (occupiedCells == buffer.length && !getFinishedState() && getNumberCalculated() < getNumberOfSetsToCalculate()) {
         // System.out.printf("Buffer is full. Master waits to put in value.%n");
         wait(); // wait until a buffer cell is free              
      }                                            

      buffer[writeIndex] = array; // set new buffer value

      // update circular write index
      writeIndex = (writeIndex + 1) % buffer.length;

      ++occupiedCells; // one more buffer cell is full

      notifyAll(); // notify threads waiting to read from buffer
   }

   /**
    * gets a double array containing the 3 values for the root finder
    * @return a double array containing the 3 values for the root finder
    * @throws InterruptedException exception occurs if the thread has been interrupted
    */
   // return value from buffer
   @Override
   public synchronized double[] blockingGet() throws InterruptedException {
      // wait until buffer has data, then read value;
      // while no data to read, place thread in waiting state
      while (occupiedCells == 0 && !getFinishedState() && getNumberCalculated() < getNumberOfSetsToCalculate()) {
         // System.out.printf("Buffer is empty. Slave waits to get value.%n");
         wait(); // wait until a buffer cell is filled
      } 

      double[] array = buffer[readIndex]; // read value from buffer

      // update circular read index
      readIndex = (readIndex + 1) % buffer.length;

      --occupiedCells; // one fewer buffer cells are occupied

      notifyAll(); // notify threads waiting to write to buffer

      return array;
   }
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