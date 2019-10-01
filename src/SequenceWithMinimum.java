public class SequenceWithMinimum {
    ListNode head;
    ListNode tail;
    ListNode minimum;


    class ListNode <Integer> {
        public Integer data;
        public ListNode prev;
        public ListNode next;

        ListNode(Integer d) {
            this.data = d;
            prev = null;
            next = null;}
    }

    public void insertLeft(Integer value)
    {
        ListNode new_Node = new ListNode(value);
        /* 3. Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;
        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;
        /* 5. move the head to point to the new node */
        head = new_Node;
    }

    void insertRight(Integer value)
    {
        /* 1. allocate node
         * 2. put in the data */
        ListNode new_node = new ListNode(value);

        ListNode last = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        new_node.next = null;
        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }
        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;
        /* 6. Change the next of last node */
        last.next = new_node;

        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }

    public void removeLeft()
    {
        // Base case
        if (head == null) {
            return;
        }
        // If node to be deleted is head node
        else {
            head = head.next;
        }
    }

    public void removeRight()
    {
        tail = tail.prev;
    }


    public void printlist(ListNode node) {
        ListNode last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
    }
}
