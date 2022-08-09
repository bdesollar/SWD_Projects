import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the recursively search list function
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class ListTest {

    /**
     * tests to see if the search function returns the element searched for in list knowing it exists
     */
    @Test
    public void testRecursiveSearch1()
    {
        List<Integer> list = new List<Integer>();
        // insert integers in list
        list.insertAtFront(-1);
        list.insertAtFront(0);
        list.insertAtBack(1);
        list.insertAtBack(5);
        assertEquals(list.findValueInList(5), 5);
    }

    /**
     * tests to see if the search function returns null knowing that the item being searched for does not exist
     */
    @Test
    public void testRecursiveSearch2()
    {
        List<Integer> list = new List<Integer>();
        // insert integers in list
        list.insertAtFront(-1);
        list.insertAtFront(0);
        list.insertAtBack(1);
        list.insertAtBack(5);
        assertEquals(list.findValueInList(6), null);
    }
}
