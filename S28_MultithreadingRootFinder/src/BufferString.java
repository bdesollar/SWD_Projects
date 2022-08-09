// Fig. 23.9: Buffer.java

/**
 * Buffer interface specifies methods called by Master and Slave
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

// Buffer interface specifies methods called by Master and Slave.
public interface BufferString {
   /**
    * place a String array into Buffer
    * @param array a string array to store in the buffer
    * @throws InterruptedException exception occurs if the thread has been interrupted
    */
   // place a String array into Buffer
   public void blockingPut(String[] array) throws InterruptedException;

   /**
    * return double array from Buffer
    * @return a double array from Buffer
    * @throws InterruptedException exception occurs if the thread has been interrupted
    */
   // return double array from Buffer
   public String[] blockingGet() throws InterruptedException;

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