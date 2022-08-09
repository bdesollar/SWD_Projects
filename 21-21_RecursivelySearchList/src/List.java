// Fig. 21.3: List.java
// ListNode and List class declarations.

/**
 * class to represent one node in a list
 * @param <T> Generic type of Node
 */
// class to represent one node in a list
class ListNode<T> {
    // package access members; List can access these directly
    /**
     * Data for this node
     */
    T data; // data for this node
    /**
     * reference to the next node in the list
     */
    ListNode<T> nextNode; // reference to the next node in the list

    /**
     * constructor creates a ListNode that refers to object
     * @param object What the listNode will refer to
     */
    // constructor creates a ListNode that refers to object
    ListNode(T object) {
        this(object, null);
    }

    /**
     * constructor creates ListNode that refers to the specified
     * @param object What the listNode will refer to
     * @param node Node in list to set next node to
     */
    // constructor creates ListNode that refers to the specified
    // object and to the next ListNode
    ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    /**
     * return reference to data in node
     * @return Generic type of data
     */
    // return reference to data in node
    T getData() {
        return data;
    }

    /**
     * return reference to next node in list
     * @return reference to the Generic type of node that is next in the list
     */
    // return reference to next node in list
    ListNode<T> getNext() {
        return nextNode;
    }
} // end class ListNode<T>

/**
 * class List definition
 * @param <T> Generic type
 */
// class List definition
public class List<T> {

    /**
     * reference to the first node in the linked list
     */
    private ListNode<T> firstNode;
    /**
     * reference to the last node in the linked list
     */
    private ListNode<T> lastNode;
    //
    /**
     * reference to the current node in the list
     */
    private ListNode<T> currentNode;
    /**
     * string like "list" used in printing
     */
    private String name; // string like "list" used in printing

    /**
     * constructor creates empty List with "list" as the name
     */
    // constructor creates empty List with "list" as the name
    public List() {
        this("list");
    }

    /**
     * constructor creates an empty List with a name
     * @param listName name of the list
     */
    // constructor creates an empty List with a name
    public List(String listName) {
        name = listName;
        firstNode = lastNode = null;
        currentNode = null;
    }

    /**
     * Tries to find value specified in linked list using recursion
     * @param val value to look for in linked list
     * @return Generic value if it exists, if not it is null
     */
    public T findValueInList(T val)
    {
        // Checks if the list is empty
        if(isEmpty())
        {
            return null;
        }
        // if current node has yet to be assigned then assign it to the first node
        if(currentNode == null)
        {
            currentNode = firstNode;
        }
        if(currentNode.data == val)
        {
            return currentNode.getData();
        }
        // Makes sure not at end of list
        if(currentNode.getNext() != null)
        {
            currentNode = currentNode.getNext();
        }
        else
        {
            return null;
        }
        // recursive search
        return findValueInList(val);

    }

    /**
     * insert item at front of List
     * @param insertItem item to insert at the front of the linked list
     */
    // insert item at front of List
    public void insertAtFront(T insertItem) {
        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else // firstNode refers to new node
            firstNode = new ListNode<T>(insertItem, firstNode);
    }

    /**
     * insert item at end of List
     * @param insertItem item to insert at the back of the linked list
     */
    // insert item at end of List
    public void insertAtBack(T insertItem) {
        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else // lastNode's nextNode refers to new node
            lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
    }

    /**
     * remove first node from List
     * @return The value of the data in the node that was removed
     * @throws EmptyListException throw exception if List is empty
     */
    // remove first node from List
    public T removeFromFront() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empty
            throw new EmptyListException(name);

        T removedItem = firstNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;

        return removedItem; // return removed node data
    } // end method removeFromFront

    /**
     * remove last node from List
     * @return The value of the data in the node that was removed
     * @throws EmptyListException throw exception if List is empty
     */
    // remove last node from List
    public T removeFromBack() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empty
            throw new EmptyListException(name);

        T removedItem = lastNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else // locate new last node
        {
            ListNode<T> current = firstNode;

            // loop while current node does not refer to lastNode
            while (current.nextNode != lastNode)
                current = current.nextNode;

            lastNode = current; // current is new lastNode
            current.nextNode = null;
        }

        return removedItem; // return removed node data
    }

    /**
     * determine whether list is empty
     * @return true or false based on if the list is empty or not
     */
    // determine whether list is empty
    public boolean isEmpty() {
        return firstNode == null; // return true if list is empty
    }

    /**
     * output list contents
     */
    // output list contents
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode<T> current = firstNode;

        // while not at end of list, output current node's data
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }
} // end class List<T>

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
