/**
 * Tested on LeetCode
 */
public class ST_P7_ReverseLinkedList_Ashley_Mead {

    /**
     * ListNode class
     */
    private class ListNode {
        Object data;
        ListNode next;
        ListNode() {}
        ListNode(int data) { this.data = data; }
        ListNode(int data, ListNode next) { this.data = data; this.next = next; }
    }

    /**
     * Iterative version of reversing LinkedList
     * @param head The head of the LinkedList to be reversed
     * @return The head of the of the newly reversed LinkedList
     */
    public ListNode reverseLinkedListIterative(ListNode head) {
        // Edge cases
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        ListNode pre = null;
        // Loop until the current node reaches the tail (the tail is null)
        while(current != null) {
            ListNode next = current.next;
            // Make the current node refer to the previous node
            // and shift the variables to be assigned to the next set of nodes
            // for the next iteration
            current.next = pre;
            pre = current;
            current = next;
        }
        // If current node is null, we have reached the tail of the original LinkedList
        // and the previous one represents the head of the reversed LinkedList
        return pre;
    }

    /**
     * Recursive version of reversing LinkedList
     * @param head of the LinkedList to be reversed
     * @return The head of the of the newly reversed LinkedList
     */
    public ListNode reverseLinkedListRecursive(ListNode head) {
        // Edge cases or base case
        if(head == null || head.next == null) {
            return head;
        }

        // Call this method with the next node as the head until the base case is reached
        ListNode newHead = reverseLinkedListRecursive(head.next);
        // When this method is called, the next nodes are adjusted
        head.next.next = head;
        head.next = null;
        // Return the head of the sub-list in this recursion
        // to represent the adjustment progress
        return newHead;
    }
}
