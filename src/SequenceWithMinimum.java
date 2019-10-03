
public class SequenceWithMinimum implements A1SequenceWithMinimum{
    ListNode head;
    ListNode tail;


    class ListNode <Integer> {
        public Integer data;
        public ListNode<Integer> prev;
        public ListNode<Integer> next;
        ListNode(Integer d) {
            this.data = d;
        }
    }

    public void printSequence(ListNode current) {
        System.out.print("The sequence:  ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    @Override
    public void insertLeft(Integer value) {
        ListNode newNode = new ListNode(value);
        /* 3. Make next of new node as head and previous as NULL */
        newNode.next = head;
        newNode.prev = null;
        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = newNode;
        else {
            tail = newNode;
        }
        /* 5. move the head to point to the new node */
        head = newNode;
        System.out.println("Inserted on the left: " + value);
    }


    @Override
    public void insertRight(Integer value) {
        ListNode newNode = new ListNode(value);


        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/

        newNode.next = null;
        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            //Both head and tail will point to newNode
            head = tail = newNode;
            //head's previous will point to null
            head.prev = null;
            //tail's next will point to null, as it is the last node of the list
            tail.next = null;
            return;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode's previous will point to tail
            newNode.prev = tail;
            //newNode will become new tail
            tail = newNode;
            //As it is last node, tail's next will point to null
            tail.next = null;
        }
        System.out.println("Inserted on the right: " + value);
    }

    @Override
    public Integer removeLeft() {
        // Base case
        if (head == null) {
            return (Integer) head.prev.data;
        } else {
            head = head.next;
        }
        return (Integer) head.prev.data;
    }

    @Override
    public Integer removeRight() {
        tail = tail.prev;
        Integer temp = (Integer) tail.next.data;
        tail.next = null;
        return temp;
    }

    @Override
    public Integer findMinimum() {
        //Node current will point to head
        ListNode current = head;
        Integer minimum;

        //Checks if list is empty
        if(head == null) {
            System.out.println("List is empty");
            return 0;
        } else {
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
