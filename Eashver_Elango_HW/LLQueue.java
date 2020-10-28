/*
 * This class implements a queue with linked list
 * Author: Eashver Elango
 * Date: Fall 2020
 */

// This is the outer Queue class, the main driver is in the public class, at the bottom
class LLQueueForStudents{
    // This is an inner class specifically utilized for LLQueue class,
    // thus no setter or getters are needed
    private class Node {
        private Object data;
        private Node next;

        // Constructor for creating standalone Node for inner class
        public Node(Object newData){
            this.data = newData;
            this.next = null;
        }
    }
    
    private Node front = null;
    private Node back = null;

    public LLQueueForStudents() {

    }
    
    //offer(enqueue) adds the object at the back of the queue
    public void offer(Object o) {
        Node temp = new Node(o); // create new Node
        if(this.front == null){ // If the queue is empty, make those Nodes
            this.front = this.back = temp;
            return;
        }
        this.back.next = temp; //Else add the Node to the back of the queue
        this.back = temp;
    }
    
    //poll(dequeue): retrieves and removes the head of this queue, 
    //or returns null if this queue is empty.
    public Object poll() {
        if(this.isEmpty()){ // if its empty, return null
            return null;
        }
        Node temp = this.front; // save the front
        this.front = this.front.next; //move the front to the next node (deleting the head)
        Object result = temp.data; // get the value

        if(this.front == null){ // if we poll the last Node, remember to remove our back value as well
            this.back = null;
        }

        return result;

    }
    
    // Returns the size of linked list by traversing the list
    public int size() { 
        if(isEmpty()){ // if its empty, return 0
            return 0;
        }
        //start off at one, because of how we iterate
        int result = 1;
        Node iterator = this.front; // start at the beginning of the queue
        while(iterator.next != null){ //keep iterating until you see that the next value is null
            result++; // keep adding to a counter
            iterator = iterator.next; // move the iterator forward
        }
        return result; // return the size
    }
    //peek: Retrieves, but does not remove, the head of this queue, 
    //or returns null if this queue is empty.
    public Object peek() {
        if(this.isEmpty()){ // if its empty, return null
            return null;
        }
        return this.front.data; //else return the front's data
    } 
    
    //
    public boolean isEmpty() {
        return this.back==null && this.front==null; // if both are null, say queue is empty
    }
    
    
    // For two lists to be equal they must contain the same data items in
    // the same order. The equals method of T is used to compare data items.
    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;

        else if (!(otherObject instanceof LLQueueForStudents)) {
            return false;
        } else {
            LLQueueForStudents otherList = (LLQueueForStudents) otherObject;
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
}

public class LLQueue {    
    // There is no need to modify the driver
    public static void main(String[] args) {
     // input data for testing
        String target = "Somethings!";
        //String palindrome = "a man a plan canal panama";

        LLQueueForStudents list = new LLQueueForStudents();
        // objects to be added to list
        Object object1 = (Character) target.charAt(4);
        Object object2 = (Character) target.charAt(1);
        Object object3 = (Character) target.charAt(2);
        Object object4 = (Character) target.charAt(9);
        //Object object20 = (Character) target.charAt(6); // will not be added to list

        // add 4 objects to our linked list
        list.offer(object1);
        list.offer(object2);
        list.offer(object3);
        list.offer(object4);
        
        // make sure all are added
        System.out.println("My list has " + list.size() + " nodes.");
        
        //testing equals
        LLQueueForStudents list2 = new LLQueueForStudents();
        // add 4 objects to the new linked list
        list2.offer(object1);//t
        list2.offer(object2);//o
        list2.offer(object3);//m
        list2.offer(object4);//s
        boolean isEqual2 = list.equals(list2);
        System.out.println("list2 is equal to list1? " + isEqual2);
        
        // add 4 objects to our linked list in a different order
        LLQueueForStudents list3 = new LLQueueForStudents();
        list3.offer(object3);//m
        list3.offer(object1);//t
        list3.offer(object2);//o
        list3.offer(object4);//s
        boolean isEqual3 = list.equals(list3);
        System.out.println("list3 is equal to list1? " + isEqual3);
        
        // testing isEmpty() and poll()
        while(!list.isEmpty()) {
            Object temp = list.poll();
            System.out.println("Polling " + temp);
        }
       
    }
}
