public class ST_7_ReverseLinkList_Caogang_Shen {
    /**
     * A simple node for linked list
     * 
     * @author Marcelo Shen
     */
    static class ListNode {
        private Object data;
        private ListNode next;

        /**
         * Constructor for a null-pointing node
         * 
         * @param o the information stored
         */
        private ListNode(Object o) {
            data = o;
            next = null;
        }

        /**
         * Constructor for a node that points another node
         * 
         * @param o the information stored
         * @param n the next node
         */
        private ListNode(Object o, ListNode n) {
            data = o;
            next = n;
        }

        @Override
        public String toString() {
            try {
                return (String) data; // return string if data can be a string
            } catch (ClassCastException e) {
                return ""; // return empty string
            }
        }
    }

    /**
     * Reverse the linked list with iterative steps
     * 
     * @param head the head of the linked list to be reversed
     * @return the new head of the reversed linked list
     */
    public static ListNode reverseListIter(ListNode head) {
        ListNode pre = null; // pre variable stores the previous node
                             // so that the current node can point to it
        ListNode curr = head; // curr variable stores the current node
        while (curr != null) {
            ListNode next = curr.next; // next variable stores the next node so the information is not lost
                                       // when curr.next is set to pre
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * Reverse the linked list with recursive steps
     * 
     * @param head the head of the linked list to be reversed
     * @return the new head of the reversed linked list
     */
    public static ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) { // head == null check the edge case where the head is empty,
                                                 // head.next == null check if the head is the tail of the node
            return head; // return tail of the original linked list
        } else {
            ListNode newHead = reverseListRec(head.next); // get the tail of the original linked list
            head.next.next = head; // meanwhile reversing the pointer along the way to the tail
            head.next = null; // make the current head pointing to null so that the new tail point to null
            return newHead; // make the tail of the original linked list the head of the new linked list
        }
    }

    /**
     * Test my methods to make sure they works
     * 
     * @param args main method useless stuff
     */
    public static void main(String[] args) {
        ListNode a = new ListNode("a");
        ListNode b = new ListNode("b", a);
        ListNode c = new ListNode("c", b);
        System.out.println(c + ", " + b + ", " + a); // expect "c, b, a"
        ListNode newHeadIter = reverseListIter(c); // c is the head, will make a the head
        while (newHeadIter != null) {
            System.out.print(newHeadIter + ", ");
            newHeadIter = newHeadIter.next;
        } // expect "a, b, c, "
        System.out.println();
        ListNode newHeadRec = reverseListRec(a); // a is the head, will make c the head
        while (newHeadRec != null) {
            System.out.print(newHeadRec + ", ");
            newHeadRec = newHeadRec.next;
        } // expect "c, b, a, "
    }
}
