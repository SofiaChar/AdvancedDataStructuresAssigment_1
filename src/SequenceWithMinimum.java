public class SequenceWithMinimum implements A1SequenceWithMinimum{
    ListNode head;
    ListNode tail;
    ListNode minimun;


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
        newNode.next = head;
        newNode.prev = null;
        // change prev of head node to new node if head exists or tail node to new one
        if (head != null){
            head.prev = newNode;
            if (value < (Integer)minimun.data){
                minimun = newNode;
            }
        }
        else {
            minimun = newNode;
            tail = newNode;
        }
        head = newNode;
        System.out.println("Inserted on the left: " + value);
    }


    @Override
    public void insertRight(Integer value) {
        ListNode newNode = new ListNode(value);
        // This new node is going to be the last node, so make next of it as NULL
        newNode.next = null;
        // If the Linked List is empty, then make the new node as head
        if (head == null) {
            minimun = newNode;
            //Both head and tail will point to newNode
            head = tail = newNode;
            head.prev = null;
            //tail's next will point to null, as it is the last node of the list
            tail.next = null;
            return;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
            if (value < (Integer)minimun.data){
                minimun = newNode;
            }
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
            Integer temp = (Integer) head.prev.data;
            head.prev = null;
            return temp;
        }
    }

    @Override
    public Integer removeRight() {
        // Base case
        if (head == null) {
            return (Integer) head.prev.data;
        } else {
            tail = tail.prev;
            Integer temp = (Integer) tail.next.data;
            tail.next = null;
            return temp;
        }
    }

    @Override
    public Integer findMinimum() {
        //Check if list is empty
        if(head == null) {
            System.out.println("List is empty");
            return 0;
        }
        if(head==tail)
            return (Integer) head.data;
        return (Integer) minimun.data;
    }
}
