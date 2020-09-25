public class ST_P7_ReversedLinkedList_Eashver_Elango {
    // LinkedList Head Node
    Node head;

    // Inner class Node
    private class Node {
        // Data parameter
        Object data;
        // next Node that this node connects to
        Node next;

        // Basic constructor
        public Node() { }

        // Parameterized Constructor with data and next
        public Node(Object _data, Node _next){
            this.data = _data;
            this.next = _next;
        }
    }

    // Iterative LinkedList Reversal
    public Node reverseIterative(){
        Node prev = null;
        Node curr = this.head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Recursive LinkedList Reversal
    public Node reverseRecursive(Node curr){
        // Base Case: If we reach the end, return the final Node
        if(curr == null || curr.next == null){
            return curr; // this will be the new head of the function
        }

        // Recursive Case: Call the function
        Node newHead = reverseRecursive(curr.next);
        curr.next.next = curr; // Our next Node's next to point back to us. This is the reversal in action
        curr.next = null; // Since it's reversed, our current shouldn't point to anything right now
        return newHead; // return the head
    }
}
