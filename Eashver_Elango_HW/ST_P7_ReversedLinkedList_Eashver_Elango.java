public class ST_P7_ReversedLinkedList_Eashver_Elango {
    // LinkedList Head Node
    Node head;

    // Inner class Node
    private static class Node {
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

    // Iterative LinkedList Reversal O(n) time
    public Node reverseIterative(){
        Node prev = null; // Hold previous Node
        Node curr = this.head; // Hold current node. At start this is the head node
        Node next = null; // Hold next node. 
        while(curr != null){ // Iterate over the entire LinkedList
            next = curr.next; // Save our next Node
            curr.next = prev; // Reverse the pointers
            prev = curr; // Move our iterator forward as current is now previous
            curr = next; // Move our iterator forward as current is now the next Node
        }
        return prev; // Since we end on a null in the while loop, the actually LL head is the previous Node value
    }

    // Recursive LinkedList Reversal
    public static Node reverseRecursive(Node curr){
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

    public static void main(String[] args) {
        Node n2 = new Node();
        System.out.println(n2.data);
        Node n1 = new Node(5, n2);
        reverseRecursive(n1);
    }
}
