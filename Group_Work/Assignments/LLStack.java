
/**
 * This class will use Nodes to form a linked list. It implements the LIFO (Last
 * In First Out) methodology to reverse the input string.
 * 
 * @author Caogang Shen, Ashley Mead, Brandon Yi
 **/

public class LLStack {

    private Node head;

    // Constructor with no parameters for outer class
    public LLStack() {

    }

    // This is an inner class specifically utilized for LLStack class,
    // thus no setter or getters are needed
    private class Node {
        private Object data;
        private Node next;

        // Constructor with no parameters for inner class
        public Node() {

        }

        // Parametrized constructor for inner class
        public Node(Object newData, Node nextLink) {
            data = newData;// TODO: Data part of Node is an Object
            next = nextLink;// TODO: Link to next node is a type Node
        }
    }

    /**
     * Adds a node as the first node element at the start of the list with the
     * specified data.
     * 
     * @param itemData The data the added node contains
     */
    public void addToStart(Object itemData) {
        // TODO
        head = new Node(itemData, head);
        // NOTE: the logic here could be implemented in a single line,
        // but not required to be a one liner.
    }

    /**
     * Removes the head node
     * 
     * @return The object being deleted or null if the list is empty
     */
    public Object deleteHead() {
        if (head == null) {
            return null;// TODO
        } else {
            // Assign a new node to the head, then link the head to the next element,
            // deleting the original head,
            // and return the original head
            Object oldData = head.data;
            head = head.next;
            return oldData;
        }
    }

    /**
     * Traverses the list and:
     * 
     * @return the size of the linked list
     */
    public int size() {
        int counter = 0;
        Node iterator = head;
        // Loop until a null node is reached and keep track of the number of nodes
        while (iterator != null) {
            iterator = iterator.next;
            counter++;
        }
        return counter;
    }

    /**
     * Finds if there is a match for the given object
     * 
     * @param item The object to search for
     * @return Whether there is a match for the object in the LinkedList
     */
    public boolean contains(Object item) {
        Node iterator = head;
        while (iterator != null) {
            if (iterator.data.equals(item)) {
                return true;
            }
            iterator = iterator.next;
        }
        return false;// TODO
    }

    /**
     * Finds the first node containing the target item
     * 
     * @param target the item being searched for
     * @return A reference to the target item's node, or null if target not found
     */
    private Node findData(Object target) {
        Node current = head;
        Object itemAtPosition;
        while (current != null) {
            itemAtPosition = current.data;

            if (itemAtPosition.equals(target))
                return current;
            current = current.next;
        }
        return null; // Target not found!
    }

    public void outputList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public String toString() {
        String retValue = "";
        Node current = head;

        while (current != null) {
            retValue += current.data.toString() + " ";
            current = current.next;
        }
        return retValue;
    }

    /**
     * 
     * @return Whether the list is empty
     */
    public boolean isEmpty() {
        return head == null;
        // TODO
    }

    /**
     * Clear the LinkedList
     */
    public void clear() {
        head = null;
        // TODO
    }

    // For two lists to be equal they must contain the same data items in
    // the same order. The equals method of T is used to compare data items.
    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;

        else if (!(otherObject instanceof LLStack))
            return false;

        else {
            LLStack otherList = (LLStack) otherObject;
            if (size() != otherList.size())
                return false;
            Node position = head;
            Node otherPosition = otherList.head;
            while (position != null) {
                if (!(position.data.equals(otherPosition.data)))
                    return false;
                position = position.next;
                otherPosition = otherPosition.next;
            }
            return true; // objects are the same
        }
    }

    // There is no need to modify the driver
    public static void main(String[] args) {

        // input data for testing
        String target = "Somethings!";
        String palindrome = "a man a plan canal panama";

        LLStack list = new LLStack();
        // objects to be added to list
        Object object1 = (Character) target.charAt(4);
        Object object2 = (Character) target.charAt(1);
        Object object3 = (Character) target.charAt(2);
        Object object4 = (Character) target.charAt(9);
        Object object20 = (Character) target.charAt(6); // will not be added to list

        // add 4 objects to our linked list
        list.addToStart(object1);
        list.addToStart(object2);
        list.addToStart(object3);
        list.addToStart(object4);

        // make sure all are added
        System.out.println("My list has " + list.size() + " nodes.");
        // display the newly created list
        list.outputList();
        System.out.println("toString = " + list.toString());

        // test findData() here
        Node itemFound = list.findData(object1);
        System.out.println("Item found: " + itemFound.data);

        // Test contains() here
        if (list.contains(object1))
            System.out.println("Object1 found.");
        else
            System.out.println("There is NO object1.");

        if (list.contains(object20))
            System.out.println("Object20 found.");
        else
            System.out.println("There is NO object20.");

        // Creating a new linked list by iteration using different input
        LLStack linkedList = new LLStack();

        for (int i = 0; i < palindrome.length(); i++) {
            Object object = (Character) palindrome.charAt(i);
            linkedList.addToStart(object);
        }
        // Display your list now
        linkedList.outputList();

        // More tests; size() and is Empty()
        System.out.println("This time my list has " + linkedList.size() + " nodes.");
        System.out.println("Is our linkedList empty? " + linkedList.isEmpty());

        // Creating an Object of different class to compare with Character class
        Object mismatchObject = (Integer) Character.getNumericValue(target.charAt(0));

        boolean areEqual = linkedList.equals(mismatchObject);
        System.out.println("Are the 2 objects equal? " + areEqual);

        boolean areEqualAgain = linkedList.equals(linkedList);
        System.out.println("Are the 2 objects equal? " + areEqualAgain);

        // test deleteHead()
        list.deleteHead();
        if (list.contains(object4))
            System.out.println("Object4 found.");
        else
            System.out.println("Object4 has been deleted!");
        while (!list.isEmpty()) {
            list.deleteHead();
        }
        System.out.println("Start of list:");
        list.outputList();
        System.out.println("End of list.");

        System.out.println("In the begining linkedList has " + linkedList.size() + " nodes");
        linkedList.clear();

        System.out.println("After testing clear(), linkedList has " + linkedList.size() + " nodes");
    }

}
