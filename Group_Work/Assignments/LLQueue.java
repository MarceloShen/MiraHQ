// import jdk.jfr.internal.OldObjectSample;

/**
 * This class implements a queue with linked list
 * 
 * @since Fall 2020
 * @author Caogang Shen, Ashley Mead, Brandon Yi
 */

public class LLQueue {
    // This is an inner class specifically utilized for LLStack class,
    // thus no setter or getters are needed
    private class Node {
        private Object data;
        private Node next;

        // Constructor with no parameters for inner class
        public Node() {
            // Empty Constructor
        }

        // Parametrized constructor for inner class
        public Node(Object newData, Node nextLink) {
            data = newData; // TODO: Data part of Node is an Object
            next = nextLink;// TODO: Link to next node is a type Node
        }
    }

    private Node front;
    private Node back;

    public LLQueue() {
        // Empty Contructor
    }

    /**
     * offer(enqueue) adds the object at the back of the queue
     * 
     * @param o object to be added
     */
    public void offer(Object o) {
        // If the back is null, create the queue with a new node
        if (back == null) {
            back = new Node(o, null);
            front = back;
            // Create a new node and connect it to the back
        } else {
            back.next = new Node(o, null);
            back = back.next;
        }
        // TODO
    }

    /**
     * poll(dequeue): retrieves and removes the head of this queue, or returns null
     * if this queue is empty.
     * 
     * @return The node that was removed, or null if this queue is empty
     */
    public Object poll() {
        if (front != null) {
            // Assign a returned node to the front, then link the front to the next node
            Object result = front.data;
            front = front.next;
            return result;
        } else {
            return null;
        }
        // TODO
    }

    /**
     * Returns the size of linked list by traversing the list
     * 
     * @return the number of nonnull nodes in the linked list
     */
    public int size() {
        int counter = 0;
        Node iterator = front;
        // Loop until a null node is reached and keep track of the number of nodes
        while (iterator != null) {
            iterator = iterator.next;
            counter++;
        }
        return counter;
        // TODO
    }

    /**
     * peek: Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty. (If the queue is empty front would be null)
     * 
     * @return The head of the queue, or null if this queue is empty
     */
    public Object peek() {
        if (isEmpty() == true) {
            return null;
        }
        return front.data;
        // TODO
    }

    /**
     * @return whether list is empty
     */
    public boolean isEmpty() {
        // If front is null, the rest of the list doesn't exist, so the list is empty.
        return front == null;
        // TODO
    }

    // For two lists to be equal they must contain the same data items in
    // the same order. The equals method of T is used to compare data items.
    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;

        else if (!(otherObject instanceof LLQueue)) {
            return false;
        } else {
            LLQueue otherList = (LLQueue) otherObject;
            if (size() != otherList.size())
                return false;
            Node position = front;
            Node otherPosition = otherList.front;
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

        LLQueue list = new LLQueue();
        // objects to be added to list
        Object object1 = (Character) target.charAt(4);
        Object object2 = (Character) target.charAt(1);
        Object object3 = (Character) target.charAt(2);
        Object object4 = (Character) target.charAt(9);
        Object object20 = (Character) target.charAt(6); // will not be added to list

        // add 4 objects to our linked list
        list.offer(object1);
        list.offer(object2);
        list.offer(object3);
        list.offer(object4);

        // make sure all are added
        System.out.println("My list has " + list.size() + " nodes.");

        // testing equals
        LLQueue list2 = new LLQueue();
        // add 4 objects to the new linked list
        list2.offer(object1);// t
        list2.offer(object2);// o
        list2.offer(object3);// m
        list2.offer(object4);// s
        boolean isEqual2 = list.equals(list2);
        System.out.println("list2 is equal to list1? " + isEqual2);

        // add 4 objects to our linked list in a different order
        LLQueue list3 = new LLQueue();
        list3.offer(object3);// m
        list3.offer(object1);// t
        list3.offer(object2);// o
        list3.offer(object4);// s
        boolean isEqual3 = list.equals(list3);
        System.out.println("list3 is equal to list1? " + isEqual3);

        // testing isEmpty() and poll()
        while (!list.isEmpty()) {
            Object temp = list.poll();
            System.out.println("Polling " + temp);
        }

    }

}
