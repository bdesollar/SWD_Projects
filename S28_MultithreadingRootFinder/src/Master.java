import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * creates the slave threads that calculate a specified number of roots
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */
public class Master {

   /**
    * The number of masters created by the GUI
    */
   private static int masterNumber = 0;
   /**
    * number of sets of roots to calculate
    */
   private int numberOfSetsToCalculate;
   /**
    * used to store all the roots calculated
    */
   private ArrayList<String[]> arrayList;
   /**
    * Synchronizing access to a shared three-element bounded buffer.
    */
   private CircularBufferDouble sharedLocationMaster;
   /**
    * Synchronizing access to a shared three-element bounded buffer.
    */
   private CircularBufferString sharedLocationSlave;

   /**
    * constructor initializes the buffers, sets to calculate, and the number of masters created
    */
   public Master(){
      masterNumber++;
      System.out.println("Master " + masterNumber + " Created");
      this.arrayList = new ArrayList<>();
      this.sharedLocationMaster = new CircularBufferDouble();
      this.sharedLocationSlave = new CircularBufferString();
      this.numberOfSetsToCalculate = 0;
   }

   /**
    * gets the number of sets of roots to calculate as specified by the user
    * @return  the number of sets of roots to calculate as specified by the user
    */
   public int getNumberOfSetsToCalculate() {
      return numberOfSetsToCalculate;
   }

   /**
    * sets the number of sets of roots to calculate as specified by the user
    * @param numberOfSetsToCalculate the number of sets of roots to calculate as specified by the user
    */
   public void setNumberOfSetsToCalculate(int numberOfSetsToCalculate) {
      this.numberOfSetsToCalculate = numberOfSetsToCalculate;
   }

   /**
    * gets the buffer shared between the master and the slave
    * @return the buffer shared between the master and the slave
    */
   public CircularBufferDouble getSharedLocationMaster() {
      return sharedLocationMaster;
   }

   /**
    * gets the buffer shared between the slave and the master
    * @return the buffer shared between the slave and the master
    */
   public CircularBufferString getSharedLocationSlave() {
      return sharedLocationSlave;
   }

   /**
    * gets the array list that holds all the calculated roots
    * @return the array list that holds all the calculated roots
    */
   public ArrayList<String[]> getArrayList() {
      return arrayList;
   }

   /**
    * creates and runs the slave threads using the ExecutorService
    * @throws InterruptedException exception occurs if the thread has been interrupted
    */
   public void runMaster() throws InterruptedException {
      // create new thread pool
      ExecutorService executorService = Executors.newCachedThreadPool();

      getSharedLocationMaster().setNumberOfSetsToCalculate(getNumberOfSetsToCalculate());

      for(int i = 0; i < 10; i++) {
         executorService.execute(new Slave(getSharedLocationMaster(), getSharedLocationSlave()));
      }

      double min = 1;
      double max = 10;
      double[] randomNumberList;
      SecureRandom generator = new SecureRandom();
      for(int k = 0; k < getNumberOfSetsToCalculate(); k++)
      {
         double randomNumber1 = (Math.random() * ((max - min) + 1)) + min;
         randomNumber1 = Math.round(randomNumber1 * 100.0) / 100.0;

         double randomNumber2 = (Math.random() * ((max - min) + 1)) + min;
         randomNumber2 = Math.round(randomNumber2 * 100.0) / 100.0;

         double randomNumber3 = (Math.random() * ((max - min) + 1)) + min;
         randomNumber3 = Math.round(randomNumber3 * 100.0) / 100.0;

         randomNumberList = new double[]{randomNumber1, randomNumber2, randomNumber3};

         getSharedLocationMaster().blockingPut(randomNumberList);
         String[] returnedNumberList = getSharedLocationSlave().blockingGet();
         // adds a string array of the roots calculated by a slave
         getArrayList().add(returnedNumberList);
      }
      // sets the slaves to done and stops the master to slave buffer
      getSharedLocationSlave().setFinishedState(true);
      // sets the slaves to done and stops the slave to master buffer
      getSharedLocationMaster().setFinishedState(true);
      Thread.sleep(generator.nextInt(3000));
      System.out.println("Calculated " + getSharedLocationMaster().getNumberCalculated() + " times");

      executorService.shutdown();
      executorService.awaitTermination(1, TimeUnit.MINUTES);
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