import java.util.Scanner;

/**
 * Main class to run the Linked list
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class ListMain {
    /**
     * Creates a list object and tests the methods
     * @param args  an array of strings that can be passed in when starting the main program
     */
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        // insert integers in list
        list.insertAtFront(-1);
        list.insertAtFront(0);
        list.insertAtBack(1);
        list.insertAtBack(5);
        list.print();

        System.out.println("Enter number you are looking for: ");
        Scanner sc = new Scanner(System.in);
        Integer userNumberToFind = sc.nextInt();
        Integer itemToLookFor = list.findValueInList(userNumberToFind);
        if (itemToLookFor == null) {
            System.out.println(userNumberToFind + " does not exist in the list");
        } else {
            System.out.println(userNumberToFind + " exists in the list");
        }
    }
}