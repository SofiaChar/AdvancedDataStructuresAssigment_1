import java.util.List;

public class SequenceWithMinimum {
    ListNode head = null;
    ListNode tail = null;


    class ListNode <Integer> {
        public Integer data;
        public ListNode<Integer> prev;
        public ListNode<Integer> next;


        ListNode(Integer d) {
            this.data = d;
        }

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
        else {
            tail = new_Node;

        }

        /* 5. move the head to point to the new node */
        head = new_Node;
    }

    void insertRight(Integer value)
    {
        ListNode new_node = new ListNode(value);

        new_node.next = null;
        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            //Both head and tail will point to newNode
            head = tail = new_node;
            //head's previous will point to null
            head.prev = null;
            //tail's next will point to null, as it is the last node of the list
            tail.next = null;

            return;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = new_node;
            //newNode's previous will point to tail
            new_node.prev = tail;
            //newNode will become new tail
            tail = new_node;
            //As it is last node, tail's next will point to null
            tail.next = null;
        }
    }

    public Integer removeLeft()
    {
        // Base case
        if (head == null) {
            return (Integer) head.prev.data;
        }
        // If node to be deleted is head node
        else {
            head = head.next;
        }
        return (Integer) head.prev.data;
    }

    public Integer removeRight()
    {
        tail = tail.prev;
        tail.next = null;
        return (Integer) tail.data;
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
        //Node current will point to head
        ListNode current = head;
        Integer minimum;

        //Checks if list is empty
        if(head == null) {
            System.out.println("List is empty");
            return 0;
        }
        else {
            //Initially, min will store the value of head's data
            minimum = (Integer)head.data;
            while(current != null) {
                //If the value of min is greater than the current's data

                //Then, replace the value of min with current node's data

                if(minimum > (Integer) current.data)
                    minimum = (Integer)current.data;
                current = current.next;
            }
        }
        return minimum;
    }

}
