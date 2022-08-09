// Fig. 28.10: ClientTest.java
// Class that tests the Client.

import java.io.IOException;

/**
 * Creates and runs the client
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class ClientTest {
    /**
     * creates and Client object and runs it
     * @param args an array of strings that can be passed in when starting the main program
     * @throws IOException exception that occurs if there is an I/O error
     */
    public static void main(String[] args) throws IOException {
        Client application = new Client(); // create client
        application.runClient();
    }
}


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
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
