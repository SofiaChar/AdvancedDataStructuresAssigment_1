public class SequenceWithMinimum {
    ListNode head = null;
    ListNode minimum;

    class ListNode <Integer> {
        public Integer data;
        public ListNode<Integer> prev;
        public ListNode<Integer> next;


        ListNode(Integer d) {
            this.data = d;
        }

    }

    public void insertLeft(Integer new_data)
    {
        ListNode new_Node = new ListNode(new_data);
        /* 3. Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;
        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;
        /* 5. move the head to point to the new node */
        head = new_Node;
    }

    void insertRight(Integer new_data)
    {
        /* 1. allocate node
         * 2. put in the data */
        ListNode new_node = new ListNode(new_data);

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

    }
    public void removeRight()
    {

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

    public Integer findMinimum(){
        ListNode minimum = null;

    }

}
