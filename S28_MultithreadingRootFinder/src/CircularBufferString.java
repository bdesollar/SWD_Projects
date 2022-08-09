// Used Fig. 23.18: CircularBuffer.java for starting point
/**
 * Synchronizing access to a shared three-element bounded buffer.
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */
// Synchronizing access to a shared three-element bounded buffer.
public class CircularBufferString implements BufferString {
   /**
    * shared buffer
    */
   private final String[][] buffer = {{}, {}, {}};
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
    * the check used to see if all the threads are done calculating
    */
   private boolean finishedState = false;

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
    * place a String array into Buffer
    * @param array a string array to store in the buffer
    * @throws InterruptedException exception occurs if the thread has been interrupted
    */
   // place value into buffer
   public synchronized void blockingPut(String[] array)
      throws InterruptedException {               
   
      // wait until buffer has space available, then write value; 
      // while no empty locations, place thread in blocked state  
      while (occupiedCells == buffer.length && !getFinishedState()) {
         // System.out.printf("Buffer is full. Slave waits to put in value.%n");
         wait(); // wait until a buffer cell is free              
      }                                            

      buffer[writeIndex] = array; // set new buffer value

      // update circular write index
      writeIndex = (writeIndex + 1) % buffer.length;

      ++occupiedCells; // one more buffer cell is full

      notifyAll(); // notify threads waiting to read from buffer
   }

   /**
    * return double array from Buffer
    * @return a double array from Buffer
    * @throws InterruptedException exception occurs if the thread has been interrupted
    */
   // return value from buffer
   @Override
   public synchronized String[] blockingGet() throws InterruptedException {
      // wait until buffer has data, then read value;
      // while no data to read, place thread in waiting state
      while (occupiedCells == 0 && !getFinishedState()) {
         // System.out.printf("Buffer is empty. Master waits to get values.%n");
         wait(); // wait until a buffer cell is filled
      } 

      String[] array = buffer[readIndex]; // read value from buffer

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